package pl.coderslab.szamadlaleniwych.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import pl.coderslab.szamadlaleniwych.model.Recipe;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InspirationsSpoonacularService {

    @Value("${spoonacular.api.key}")
    String spoonacularApiKey;

    private final RestTemplate restTemplate;

    public InspirationsSpoonacularService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Recipe> getRecipeDetails(String name) {
        URI searchUri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/complexSearch")
                .queryParam("query", name)
                .queryParam("number", 1) // Pobiera 5 wyników
                .queryParam("apiKey", spoonacularApiKey)
                .build()
                .toUri();

        Map<String, Object> searchResponse = restTemplate.getForObject(searchUri, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) searchResponse.get("results");

        List<Recipe> recipes = new ArrayList<>();
        for (Map<String, Object> recipeData : results) {
            Integer recipeId = (Integer) recipeData.get("id");
            String recipeTitle = (String) recipeData.get("title");

            URI detailsUri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/" + recipeId + "/information")
                    .queryParam("includeNutrition", "false")
                    .queryParam("apiKey", spoonacularApiKey)
                    .build()
                    .toUri();

            Map<String, Object> detailsResponse = restTemplate.getForObject(detailsUri, Map.class);

            Recipe recipe = new Recipe();
            recipe.setName(recipeTitle);
            recipe.setIngredients(getIngredientsString(detailsResponse));
            recipe.setInstructions((String) detailsResponse.get("instructions"));
            recipe.setImageUrl((String) detailsResponse.get("image")); // Pobiera URL zdjęcia

            recipes.add(recipe);
        }
        return recipes;
    }

    private String getIngredientsString(Map<String, Object> detailsResponse) {
        List<Map<String, Object>> ingredients = (List<Map<String, Object>>) detailsResponse.get("extendedIngredients");
        if (ingredients == null || ingredients.isEmpty()) {
            return "No ingredients found.";
        }

        StringBuilder ingredientsStr = new StringBuilder();
        for (Map<String, Object> ingredient : ingredients) {
            String originalString = (String) ingredient.get("originalName");
            if (originalString != null && !originalString.trim().isEmpty()) {
                ingredientsStr.append(originalString).append(", ");
            }
        }

        if (ingredientsStr.length() > 0) {
            ingredientsStr.setLength(ingredientsStr.length() - 2);
        }

        return ingredientsStr.toString();
    }
    }

