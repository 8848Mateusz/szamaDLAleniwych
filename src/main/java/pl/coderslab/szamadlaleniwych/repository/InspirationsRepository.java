package pl.coderslab.szamadlaleniwych.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.szamadlaleniwych.domain.Inspirations;
import java.util.List;

@Repository
public interface InspirationsRepository extends JpaRepository<Inspirations, Long> {
    List<Inspirations> findFoodByUser_Id(Long userId);
    void deleteByUserId(Long userId);
}
