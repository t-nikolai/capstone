package files.cc.data;

import files.cc.models.Reservation;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ReservationRepository {
    List<Reservation> findAll() throws DataAccessException;

    Reservation findById(int reservationId) throws DataAccessException;

    List<Reservation> findByCampsiteId(int siteId);

    List<Reservation> findByCampgroundId(int campgroundId);

    Reservation add(Reservation reservation) throws DataAccessException;

    boolean update(Reservation reservation) throws DataAccessException;

    boolean deleteById(int reservationId) throws DataAccessException;

    boolean deleteByCamperId(int camperId) throws DataAccessException;
}
