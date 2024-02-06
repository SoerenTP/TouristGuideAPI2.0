package tourism.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/attractions")
public class TouristController {

    private TouristService touristService;

    @GetMapping("/all")
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        Optional<TouristAttraction> attraction = touristService.findAttractionByName(name);
        return attraction.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));    }


    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{index}")
    public ResponseEntity<TouristAttraction> updateAttraction(@PathVariable int index, @RequestBody TouristAttraction attraction) {
        touristService.updateAttraction(index, attraction);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{index}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable int index) {
        touristService.deleteAttraction(index);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
