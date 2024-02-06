package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class TouristRepository {

    private List<TouristAttraction> attractions;

    public TouristRepository() {
        this.attractions = new ArrayList<>();
        this.attractions.add(new TouristAttraction("Eiffel Tower", "Iconic tower in Paris"));
        this.attractions.add(new TouristAttraction("Statue of Liberty", "Iconic statue in New York"));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public Optional<TouristAttraction> findAttractionByName(String name) {
        return attractions.stream()
                .filter(attraction -> attraction.getName().equals(name))
                .findFirst();
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public void updateAttraction(int index, TouristAttraction attraction) {
        if (index >= 0 && index < attractions.size()) {
            attractions.set(index, attraction);
        }
    }

    public void deleteAttraction(int index) {
        if (index >= 0 && index < attractions.size()) {
            attractions.remove(index);
        }
    }
}