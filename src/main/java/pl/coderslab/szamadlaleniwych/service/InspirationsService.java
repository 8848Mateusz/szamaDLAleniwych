package pl.coderslab.szamadlaleniwych.service;


import pl.coderslab.szamadlaleniwych.domain.Inspirations;
import pl.coderslab.szamadlaleniwych.dto.InspirationsDto;
import java.util.List;

public interface InspirationsService {

    void saveInspirations(InspirationsDto inspirationsDto, Long userId);

    List<Inspirations> getFoodByUserId(Long userId);

    void deleteInspirationsByUserId(Long userId);
}
