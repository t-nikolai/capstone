package files.cc.domain;

import files.cc.data.ReservationRepository;
import files.cc.models.Reservation;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public List<Reservation> findAll() throws DataAccessException {
        return repository.findAll();
    }

    public Reservation findById(int id) throws DataAccessException{
        return repository.findById(id);
    }

    public List<Reservation> findByCampsiteId(int id) throws DataAccessException{
        return repository.findByCampsiteId(id);
    }

    public List<Reservation> findByCampgroundId(int id) throws DataAccessException{
        return repository.findByCampgroundId(id);
    }


}
