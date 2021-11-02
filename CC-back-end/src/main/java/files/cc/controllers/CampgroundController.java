package files.cc.controllers;

import files.cc.domain.CampgroundService;
import files.cc.models.Campground;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/campground")
public class CampgroundController {
    private final CampgroundService service;

    public CampgroundController(CampgroundService service){ this.service = service; }

    @GetMapping
    public List<Campground> findAll() { return service.findAll(); }

    @GetMapping{"/{campgroundId}"}
    public ResponseEntity<Campground> findById(@PathVariable int campgroundId){
        Campground campground = service.findById(campgroundId);
        if(campground == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(campground);
    }


}
