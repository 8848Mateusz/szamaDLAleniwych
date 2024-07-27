package pl.coderslab.szamadlaleniwych.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.szamadlaleniwych.domain.FoodIngredients;
import java.util.List;

@Repository
public interface FoodIngredientsRepository extends JpaRepository<FoodIngredients, Long> {
    List<FoodIngredients> findFoodsByUser_Id(Long userId);

    void deleteByUserId(Long userId);
}
