package pl.coderslab.szamadlaleniwych.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.szamadlaleniwych.model.Recipe;
import pl.coderslab.szamadlaleniwych.dto.FoodIngredientsDto;
import pl.coderslab.szamadlaleniwych.repository.FoodIngredientsRepository;
import pl.coderslab.szamadlaleniwych.service.FoodIngredientsService;
import pl.coderslab.szamadlaleniwych.service.FoodIngredientsSpoonacularService;

import java.util.List;

@Controller
public class FoodIngredientsController {

    @Autowired
    private FoodIngredientsService foodIngredientsService;

    @Autowired
    private FoodIngredientsRepository foodIngredientsRepository;

    private final FoodIngredientsSpoonacularService foodIngredientsSpoonacularService;

    public FoodIngredientsController(FoodIngredientsSpoonacularService foodIngredientsSpoonacularService) {
        this.foodIngredientsSpoonacularService = foodIngredientsSpoonacularService;
    }

    @GetMapping( value = "/FoodIngredients{userId}")
    public String FoodIngredients(@PathVariable Long userId) {
        return "FoodIngredients";
    }


    @PostMapping(value = "/FoodIngredients{userId}")
    public String searchRecipes(@RequestParam("firstIngredient") String firstIngredient,
                                @RequestParam("secondIngredient") String secondIngredient,
                                @RequestParam("thirdIngredient") String thirdIngredient,
                                Model model,
                                FoodIngredientsDto foodIngredientsDto,
                                @PathVariable Long userId) {
        List<Recipe> recipes = foodIngredientsSpoonacularService.searchRecipesByIngredients(firstIngredient, secondIngredient, thirdIngredient);
        model.addAttribute("recipes", recipes);
        foodIngredientsService.saveIngredients(foodIngredientsDto, userId);
        return "FoodIngredients";
    }
}
