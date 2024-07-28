package pl.coderslab.szamadlaleniwych.web;


import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.szamadlaleniwych.domain.FoodIngredients;
import pl.coderslab.szamadlaleniwych.domain.Inspirations;
import pl.coderslab.szamadlaleniwych.repository.FoodIngredientsRepository;
import pl.coderslab.szamadlaleniwych.repository.InspirationsRepository;
import pl.coderslab.szamadlaleniwych.service.FoodIngredientsService;
import pl.coderslab.szamadlaleniwych.service.InspirationsService;
import java.util.List;

@Controller
public class SearchHistoryController {

    @Autowired
    private InspirationsService inspirationsService;

    @Autowired
    private FoodIngredientsService foodIngredientsService;

    @Autowired
    private InspirationsRepository inspirationsRepository;

    @Autowired
    private FoodIngredientsRepository foodIngredientsRepository;

    @GetMapping("/SearchHistory{userId}")
    public String searchHistory(Model model,
                                @PathVariable Long userId) {
        List<Inspirations> inspirations = inspirationsService.getFoodByUserId(userId);
        model.addAttribute("inspirations", inspirations);
        List<FoodIngredients> foodIngredients = foodIngredientsService.getFoodsByUserId(userId);
        model.addAttribute("foodIngredients", foodIngredients);
        return "SearchHistory";
    }

    @GetMapping("/DeleteSearchHistory{userId}")
    public String aboutDeleteUser(@PathVariable Long userId) {

        return "SearchHistory";
    }

    @Transactional
    @PostMapping("/DeleteSearchHistory{userId}")
    public String deleteHistory(@PathVariable Long userId) {
        inspirationsService.deleteInspirationsByUserId(userId);
        foodIngredientsService.deleteFoodIngredientsByUserId(userId);
        return "redirect:/SearchHistory{userId}?Success";
    }
}
