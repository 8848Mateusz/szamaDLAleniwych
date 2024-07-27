package pl.coderslab.szamadlaleniwych.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.szamadlaleniwych.domain.Inspirations;
import pl.coderslab.szamadlaleniwych.domain.User;
import pl.coderslab.szamadlaleniwych.dto.InspirationsDto;
import pl.coderslab.szamadlaleniwych.repository.InspirationsRepository;
import pl.coderslab.szamadlaleniwych.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
public class InspirationsServiceImpl implements InspirationsService {

    @Autowired
    private InspirationsRepository inspirationsRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void saveInspirations(InspirationsDto inspirationsDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Inspirations inspirations = new Inspirations();
            inspirations.setName(inspirationsDto.getName());
            inspirations.setUser(user);
            inspirationsRepository.save(inspirations);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<Inspirations> getFoodByUserId(Long userId) {
        return inspirationsRepository.findFoodByUser_Id(userId);
    }

    @Override
    public void deleteInspirationsByUserId(Long userId) {
        inspirationsRepository.deleteByUserId(userId);
    }
}
