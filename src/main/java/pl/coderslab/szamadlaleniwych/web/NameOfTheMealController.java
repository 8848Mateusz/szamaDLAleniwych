package pl.coderslab.szamadlaleniwych.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.szamadlaleniwych.model.Recipe;
import pl.coderslab.szamadlaleniwych.dto.InspirationsDto;
import pl.coderslab.szamadlaleniwych.repository.InspirationsRepository;
import pl.coderslab.szamadlaleniwych.service.InspirationsService;
import pl.coderslab.szamadlaleniwych.service.InspirationsSpoonacularService;

import java.util.List;

@Controller
public class NameOfTheMealController {

    @Autowired
    private InspirationsService inspirationsService;

    @Autowired
    private InspirationsRepository inspirationsRepository;

    @Autowired
    private InspirationsSpoonacularService inspirationsSpoonacularService;

    @GetMapping( value = "/NameOfTheMeal{userId}")
    public String NameOfTheMeal(@PathVariable Long userId) {
        return "NameOfTheMeal";
    }

    @PostMapping(value = "/NameOfTheMeal{userId}")
    public String saveInspirations(InspirationsDto inspirationsDto,
                                   @PathVariable Long userId,
                                   Model model,
                                   @RequestParam(name = "name") String name) {
        if ( name== null || name.isEmpty()) {
            model.addAttribute("error", "Proszę podać nazwę potrawy.");
            return "NameOfTheMeal";
        }
        List<Recipe> recipe = inspirationsSpoonacularService.getRecipeDetails(name);
        if(recipe != null){
            model.addAttribute("recipe", recipe);
        } else {
            model.addAttribute("error", "Przepis na tą potrawę nie istnieje");
        }
        inspirationsService.saveInspirations(inspirationsDto, userId);
        return "NameOfTheMeal";
    }
}
