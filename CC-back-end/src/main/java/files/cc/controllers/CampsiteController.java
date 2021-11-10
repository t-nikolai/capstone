package files.cc.controllers;

import files.cc.domain.CampsiteService;
import files.cc.models.Campsite;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/campsite")
public class CampsiteController {
    private final CampsiteService service;

    public CampsiteController(CampsiteService service) {
        this.service = service;
    }

    @GetMapping
    public List<Campsite> findAll(){    return service.findAll();  }

    @GetMapping("/{siteId}")
    public ResponseEntity<Campsite> findById(@PathVariable int siteId){
        Campsite campsite = service.findById(siteId);
        if (campsite == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(campsite);
    }

    @GetMapping("/find-by-campground/{campgroundId}")
    public ResponseEntity<List<Campsite>> findByCampgroundId(@PathVariable int campgroundId){
        List<Campsite> campsites = findAll().stream().filter(i -> i.getCampgroundId() == campgroundId).collect(Collectors.toList());
        if (campsites == null || campsites.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(campsites);
    }
}
