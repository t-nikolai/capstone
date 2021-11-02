package files.cc.controllers;
import files.cc.domain.Result;

import files.cc.domain.CampgroundService;
import files.cc.models.Campground;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/{campgroundId}")
    public ResponseEntity<Campground> findById(@PathVariable int campgroundId){
        Campground campground = service.findById(campgroundId);
        if(campground == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(campground);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Campground campground) {
        Result<Campground> result = service.add(campground);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{campgroundId}")
    public ResponseEntity<Object> update(@PathVariable int campgroundId, @RequestBody Campground campground) {
        if (campgroundId != campground.getCampgroundId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Campground> result = service.update(campground);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{campgroundId}")
    public ResponseEntity<Void> deleteById(@PathVariable int campgroundId) {
        if (service.deleteById(campgroundId)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
