package files.cc.controllers;

import files.cc.domain.CamperService;
import files.cc.domain.Result;
import files.cc.models.Camper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000"})
@RequestMapping("/api/camper")
public class CamperController {
    private final CamperService service;

    public CamperController(CamperService service){
        this.service = service;
    }


    @GetMapping
    public List<Camper> findAll() { return service.findAll(); }

    @GetMapping("/{camperId}")
    public ResponseEntity<Camper> findById(@PathVariable int camperId){
        Camper camper = service.findById(camperId);
        if(camper == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(camper);
    }

    @PostMapping("/login")
    public ResponseEntity<Object> verifyCredentials(@RequestBody HashMap<String, String> credentials){
        Camper result = service.findAll().stream()
                .filter(i -> (i.getUsername().equals(credentials.get("username"))
                        && i.getPassword().equals(credentials.get("password"))))
                .findFirst().orElse(null);
        if (result == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Camper camper) {
        Result<Camper> result = service.add(camper);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{camperId}")
    public ResponseEntity<Object> update(@PathVariable int camperId, @RequestBody Camper camper) {
        if (camperId != camper.getCamperId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Camper> result = service.update(camper);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{camperId}")
    public ResponseEntity<Void> deleteById(@PathVariable int camperId) {
        Result<Camper> result = service.deleteById(camperId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
