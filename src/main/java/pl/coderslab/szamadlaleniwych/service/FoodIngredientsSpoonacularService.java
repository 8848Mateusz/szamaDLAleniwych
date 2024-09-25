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
public class FoodIngredientsSpoonacularService {

    @Value("${spoonacular.api.key}")
    private String spoonacularApiKey;

   private final RestTemplate restTemplate;

    public FoodIngredientsSpoonacularService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Recipe> searchRecipesByIngredients(String firstIngredient, String secondIngredient, String thirdIngredient) {
        String ingredients = String.join(",", firstIngredient, secondIngredient, thirdIngredient);

        URI searchUri = UriComponentsBuilder.fromHttpUrl("https://api.spoonacular.com/recipes/findByIngredients")
                .queryParam("ingredients", ingredients)
                .queryParam("number", 5)
                .queryParam("apiKey", spoonacularApiKey)
                .build()
                .toUri();

        List<Map<String, Object>> results = restTemplate.getForObject(searchUri, List.class);

        List<Recipe> recipes = new ArrayList<>();
        for (Map<String, Object> recipeData : results) {
            Recipe recipe = new Recipe();
            recipe.setName((String) recipeData.get("title"));
            recipe.setImageUrl((String) recipeData.get("image")); // Pobiera URL do zdjęcia
            recipes.add(recipe);
        }
        return recipes;
    }
}
