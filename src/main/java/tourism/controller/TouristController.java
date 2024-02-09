package tourism.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tourism.model.TouristAttraction;
import tourism.service.TouristService;

import java.util.List;

@Controller
@RequestMapping(path = "/attractions")
public class TouristController {

    @Autowired
    private TouristService touristService;

    @GetMapping
    public ResponseEntity<List<TouristAttraction>> getAllAttractions() {
        List<TouristAttraction> attractions = touristService.getAllAttractions();
        return new ResponseEntity<>(attractions, HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<TouristAttraction> getAttractionByName(@PathVariable String name) {
        TouristAttraction attraction = touristService.findAttractionByName(name);
        if (attraction != null) {
            return new ResponseEntity<>(attraction, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/add")
    public ResponseEntity<TouristAttraction> addAttraction(@RequestBody TouristAttraction attraction) {
        touristService.addAttraction(attraction);
        return new ResponseEntity<>(attraction, HttpStatus.CREATED);
    }

    @PostMapping("update")
    public ResponseEntity<TouristAttraction> changeAttraction(@RequestBody TouristAttraction attraction){
        TouristAttraction touristAttraction = touristService.changeAttraction(attraction);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Doesn't","Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }

    @GetMapping("delete/{name}")
    public ResponseEntity<TouristAttraction> deleteAttraction(@PathVariable String name){
        TouristAttraction touristAttraction = touristService.deleteAttraction(name);
        if (touristAttraction == null){
            return new ResponseEntity<>(new TouristAttraction(
                    "Doesn't","Exist"), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(touristAttraction, HttpStatus.OK);
    }
}
