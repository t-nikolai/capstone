package files.cc.controllers;

import files.cc.domain.ReservationService;
import files.cc.domain.Result;
import files.cc.models.Reservation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/reservation")
public class ReservationController {
    private final ReservationService service;

    public ReservationController(ReservationService service){
        this.service = service;
    }


    @GetMapping
    public List<Reservation> findAll() { return service.findAll(); }

    @GetMapping("/reservations-by-campsite/{campsiteId}")
    public ResponseEntity<List<Reservation>> findByCampsiteId(@PathVariable int campsiteId){
        List<Reservation> reservations = service.findByCampsiteId(campsiteId);
        if (reservations == null || reservations.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<Reservation> findById(@PathVariable int reservationId){
        Reservation reservation = service.findById(reservationId);
        if(reservation == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservation);
    }

    @PostMapping
    public ResponseEntity<Object> add(@RequestBody Reservation reservation) {
        Result<Reservation> result = service.add(reservation);
        if (result.isSuccess()) {
            return new ResponseEntity<>(result.getPayload(), HttpStatus.CREATED);
        }
        return ErrorResponse.build(result);
    }

    @PutMapping("/{reservationId}")
    public ResponseEntity<Object> update(@PathVariable int reservationId, @RequestBody Reservation reservation) {
        if (reservationId != reservation.getReservationId()) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        Result<Reservation> result = service.update(reservation);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return ErrorResponse.build(result);
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Void> deleteById(@PathVariable int reservationId) {
        Result<Reservation> result = service.deleteById(reservationId);
        if (result.isSuccess()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
