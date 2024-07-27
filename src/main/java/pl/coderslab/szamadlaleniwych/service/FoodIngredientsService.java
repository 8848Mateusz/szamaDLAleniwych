package pl.coderslab.szamadlaleniwych.service;


import pl.coderslab.szamadlaleniwych.domain.FoodIngredients;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.FoodIngredientsDto;
import java.util.List;
import java.util.Optional;

public interface FoodIngredientsService {

    void saveIngredients(FoodIngredientsDto foodIngredientsDto, Long userId);

    Optional<User> getUserById(Long id);

    FoodIngredients findByName(String name);

    List<FoodIngredients> findAll();

    List<FoodIngredients> getFoodsByUserId(Long userId);

    void deleteFoodIngredientsByUserId(Long userId);
}
