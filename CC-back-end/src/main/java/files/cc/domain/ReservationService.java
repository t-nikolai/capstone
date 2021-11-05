package files.cc.domain;

import files.cc.data.CampgroundRepository;
import files.cc.data.ReservationRepository;
import files.cc.models.Reservation;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationService {
    private final ReservationRepository repository;
    private final CampgroundRepository campgroundRepository;

    public ReservationService(ReservationRepository repository, CampgroundRepository campgroundRepository) {
        this.repository = repository;
        this.campgroundRepository = campgroundRepository;
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

    public Result<Reservation> add(Reservation reservation) throws DataAccessException{
        Result<Reservation> result = new Result<>();

        if (reservation.getReservationId() != 0){
            result.addMessage("reservationId cannot be set for add operation", ResultType.INVALID);
            return result;
        }

        if (reservation.getCamper() == null){
            result.addMessage("Reservation must have an associated camper", ResultType.INVALID);
            return result;
        }

        if (reservation.getSite() == null){
            result.addMessage("Reservation must have an associated campsite", ResultType.INVALID);
            return result;
        }

        if (!areDatesValid(reservation, result).isSuccess()){
            return result;
        }

        reservation.setTotal(generateTotalForStay(reservation));

        reservation = repository.add(reservation);

        if (reservation == null){
            result.addMessage("Reservation could not be saved", ResultType.INVALID);
        }else{
            result.setPayload(reservation);
        }

        return result;
    }

    public Result<Reservation> update(Reservation reservation) throws DataAccessException{
        Result<Reservation> result = new Result<>();

        if (reservation.getReservationId() <= 0){
            result.addMessage("reservationId must be a positive integer for update operation", ResultType.INVALID);
            return result;
        }

        if (reservation.getCamper() == null){
            result.addMessage("Reservation must have an associated camper", ResultType.INVALID);
            return result;
        }

        if (reservation.getSite() == null){
            result.addMessage("Reservation must have an associated campsite", ResultType.INVALID);
            return result;
        }

        if (!areDatesValid(reservation, result).isSuccess()){
            return result;
        }

        reservation.setTotal(generateTotalForStay(reservation));

        boolean isUpdated = repository.update(reservation);

        if (!isUpdated){
            result.addMessage("Reservation could not be saved", ResultType.INVALID);
        }else{
            result.setPayload(reservation);
        }

        return result;
    }

    public Result<Reservation> deleteById(int id) throws DataAccessException {
        Result<Reservation> result = new Result<>();
        boolean isDeleted = repository.deleteById(id);

        if (!isDeleted){
            result.addMessage("This reservation could not be deleted.", ResultType.FAIL);
        }
        return result;
    }

    public Result<Reservation> deleteByCamperId(int camperId) throws DataAccessException{
        Result<Reservation> result = new Result<>();
        boolean isDeleted = repository.deleteByCamperId(camperId);

        if (!isDeleted){
            result.addMessage("This reservation could not be deleted by camper id", ResultType.FAIL);
        }
        return result;
    }

    private Result<Reservation> areDatesValid(Reservation reservation, Result<Reservation> result) throws DataAccessException {
        if (reservation.getStartDate() == null || reservation.getEndDate() == null)
        {
            result.addMessage("Reservation's start and end date must be defined.", ResultType.INVALID);
            return result;
        }

        if (!reservation.getStartDate().isBefore(reservation.getEndDate())){
            result.addMessage("Reservation's start date must come before the end date.", ResultType.INVALID);
            return result;
        }

        if (reservation.getStartDate().compareTo(LocalDate.now()) < 0){
            result.addMessage("Cannot make a reservation for a date in the past.", ResultType.INVALID);
            return result;
        }

        for (Reservation r : repository.findByCampsiteId(reservation.getSite().getSiteId())){
            if (!(reservation.getReservationId() == r.getReservationId())){        // making sure system doesn't compare updated dates with the one it's going to replace
                if (!(reservation.getEndDate().compareTo(r.getStartDate()) <= 0 || reservation.getStartDate().compareTo(r.getEndDate()) >= 0)){
                    result.addMessage("Requested reservation dates overlap with an existing reservation for this location. Reservation denied.", ResultType.INVALID);
                    return result;
                }
            }
            else{
                if (r.getStartDate().compareTo(LocalDate.now()) < 0) {
                    result.addMessage("This reservation's start date has already passed and cannot be updated.", ResultType.INVALID);
                    return result;
                }
            }
        }
        return result;
    }

    private BigDecimal generateTotalForStay(Reservation reservation) {
        // calculate total $ needed for stay at host's location for the given dates
        BigDecimal total = new BigDecimal("0.00");
        // get weekend and standard rates
        BigDecimal weekendRate = campgroundRepository.findById(reservation.getSite().getCampgroundId()).getWeekendRate();
        BigDecimal standardRate = campgroundRepository.findById(reservation.getSite().getCampgroundId()).getStandardRate();

        LocalDate current = reservation.getStartDate().plusDays(1); // exclusive start date

        while (current.compareTo(reservation.getEndDate()) <= 0){
            if (current.getDayOfWeek() == DayOfWeek.SATURDAY || current.getDayOfWeek() == DayOfWeek.SUNDAY){
                total = total.add(weekendRate);
            }
            else{
                total = total.add(standardRate);
            }
            current = current.plusDays(1);
        }
        return total;
    }
}
