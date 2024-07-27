package pl.coderslab.szamadlaleniwych.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.szamadlaleniwych.domain.FoodIngredients;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.FoodIngredientsDto;
import pl.coderslab.szamadlaleniwych.repository.FoodIngredientsRepository;
import pl.coderslab.szamadlaleniwych.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class FoodIngredientsServiceImpl implements FoodIngredientsService {

    @Autowired
    private FoodIngredientsRepository foodIngredientsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveIngredients(FoodIngredientsDto foodIngredientsDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            FoodIngredients foodIngredients = new FoodIngredients();
            foodIngredients.setFirstIngredient(foodIngredientsDto.getFirstIngredient());
            foodIngredients.setSecondIngredient(foodIngredientsDto.getSecondIngredient());
            foodIngredients.setThirdIngredient(foodIngredientsDto.getThirdIngredient());
            foodIngredients.setUser(user);
            foodIngredientsRepository.save(foodIngredients);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return Optional.empty();
    }

    @Override
    public FoodIngredients findByName(String name) {
        return null;
    }

    @Override
    public List<FoodIngredients> findAll() {
        return List.of();
    }

    @Override
    public List<FoodIngredients> getFoodsByUserId(Long userId) {
        return foodIngredientsRepository.findFoodsByUser_Id(userId);
    }

    @Override
    public void deleteFoodIngredientsByUserId(Long userId) {
        foodIngredientsRepository.deleteByUserId(userId);
    }
}
