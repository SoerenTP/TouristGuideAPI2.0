package tourism.repository;

import org.springframework.stereotype.Repository;
import tourism.model.TouristAttraction;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {

    private List<TouristAttraction> attractions;

    public TouristRepository() {
        attractions = new ArrayList<>();
        attractions.add(new TouristAttraction("Eiffel Tower", "Iconic tower in Paris"));
        attractions.add(new TouristAttraction("Statue of Liberty", "Iconic statue in New York"));
    }

    public List<TouristAttraction> getAllAttractions() {
        return attractions;
    }

    public TouristAttraction findAttractionByName(String name) {
        for (TouristAttraction attraction : attractions) {
            if (attraction.getName().equalsIgnoreCase(name)) {
                return attraction;
            }
        }
        return null;
    }

    public void addAttraction(TouristAttraction attraction) {
        attractions.add(attraction);
    }

    public TouristAttraction changeAttraction(TouristAttraction attraction){
        for (int i = 0; i < attractions.size(); i++) {
            if (attractions.get(i).getName().equalsIgnoreCase(attraction.getName())){
                attractions.set(i,attraction);
                return attraction;
            }
        }
        return null;
    }

    public TouristAttraction deleteAttraction(String name){
        TouristAttraction returnAttraction = null;
        for (TouristAttraction att: attractions) {
            if (att.getName().equalsIgnoreCase(name)){
                returnAttraction = att;
            }
        }
        if (returnAttraction != null){
            attractions.remove(returnAttraction);
        }
        return returnAttraction;
    }
}