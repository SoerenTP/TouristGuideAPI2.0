package tourism.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tourism.model.TouristAttraction;
import tourism.repository.TouristRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TouristService {

    @Autowired
    private TouristRepository touristRepository;

    public List<TouristAttraction> getAllAttractions() {
        return touristRepository.getAllAttractions();
    }
    public Optional<TouristAttraction> findAttractionByName(String name) {
        return touristRepository.findAttractionByName(name);
    }

    public void addAttraction(TouristAttraction attraction) {
        touristRepository.addAttraction(attraction);
    }

    public void updateAttraction(int index, TouristAttraction attraction) {
        touristRepository.updateAttraction(index, attraction);
    }

    public void deleteAttraction(int index) {
        touristRepository.deleteAttraction(index);
    }
}