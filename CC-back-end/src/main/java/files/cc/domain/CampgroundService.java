package files.cc.domain;

import files.cc.data.CampgroundRepository;
import files.cc.models.Campground;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.valueOf;

@Service
public class CampgroundService {

    private final CampgroundRepository repository;

    public CampgroundService(CampgroundRepository repository){
        this.repository = repository;
    }

    public List<Campground> findAll() throws DataAccessException {
        return repository.findAll();
    }

    // todo: find by prefix or something referencing findAll in repo

    public Campground findById(int campgroundId){
        return repository.findById(campgroundId);
    }

    public Result<Campground> add(Campground campground) throws DataAccessException{
        Result<Campground> result = addValidate(campground);

        if (!result.isSuccess()){
            return result;
        }
        campground = repository.add(campground);

        if (campground == null){
            result.addMessage("campground could not be added", ResultType.FAIL);
            return result;
        }

        result.setPayload(campground);
        return result;
    }

    public Result<Campground> update(Campground campground) {
        Result<Campground> result = updateValidate(campground);
        if (!result.isSuccess()) {
            return result;
        }

        if (!repository.update(campground)) {
            String msg = String.format("campgroundId: %s, not found or could not be updated", campground.getCampgroundId());
            result.addMessage(msg, ResultType.NOT_FOUND);
            return result;
        }

        result.setPayload(campground);
        return result;
    }

    public boolean deleteById(int campgroundId) {
        Result<Campground> result = deleteValidate(campgroundId);
        return repository.deleteById(campgroundId);
    }

    //validation
    //  TODO: findById/State/etc Validation?
    //  add: id == zero, name required, address/city/state/zip required, phone/email required, capacity & rates required
    //  update: id > 0, name required, address/city/state/zip required, phone/email required, capacity & rates required
    //  delete: id >0

    private Result<Campground> addValidate(Campground campground){
        Result<Campground> result = new Result<>();

        if (campground == null) {
            result.addMessage("campground cannot be null", ResultType.INVALID);
            return result;
        }

        if (campground.getCampgroundId() != 0){
            result.addMessage("campground id should be 0 before being added to the DB", ResultType.INVALID);
            return result;
        }

        result = validateRequiredInfo(campground);
        return result;
    }

    private Result<Campground> updateValidate(Campground campground){
        Result<Campground> result = new Result<>();

        if (campground == null) {
            result.addMessage("campground cannot be null", ResultType.INVALID);
            return result;
        }

        if (!validatePosNumber(campground.getCampgroundId())){
            result.addMessage("campground ID should be a positive number", ResultType.INVALID);
            return result;
        }

        result = validateRequiredInfo(campground);
        return result;
    }

    private Result<Campground> deleteValidate(int campgroundId){
        Result<Campground> result = new Result<>();

        if (!validatePosNumber(campgroundId)){
            result.addMessage("campground ID should be a positive number", ResultType.INVALID);
        }
        return result;
    }

    private Result<Campground> validateRequiredInfo(Campground campground){
        Result<Campground> result = new Result<>();

        if (campground == null) {
            result.addMessage("campground cannot be null", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(campground.getName())) {
            result.addMessage("campground's name cannot be blank", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(campground.getAddress()) || isNullOrBlank(campground.getCity()) || isNullOrBlank(campground.getState())
                || !valueOf(campground.getZip()).matches("[0-9]{5}") ){          // zip code validation - might be funky
            result.addMessage("campground's full address is required, with a valid 5-digit zip code", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(campground.getPhone()) /*|| !campground.getPhone().matches("[0-9]")*/){
            result.addMessage("campground's phone number is required, w/ no non-numbers", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(campground.getEmail()) || !campground.getEmail().contains("@")){
            result.addMessage("campground's email address is requried and must be valid", ResultType.INVALID);
            return result;
        }

        if (!validatePosNumber(campground.getCapacity())){
            result.addMessage("campground's capacity must be a positive integer", ResultType.INVALID);
            return result;
        }

        if  (!validatePosNumber(campground.getStandardRate().doubleValue())){
            result.addMessage("campground's standard rate must be positive", ResultType.INVALID);
            return result;
        }

        if  (!validatePosNumber(campground.getWeekendRate().doubleValue())){
            result.addMessage("campground's weekend rate must be positive", ResultType.INVALID);
            return result;
        }

        return result;
    }

    private boolean isNullOrBlank(String s){
        return s == null || s.isBlank() || s.isEmpty();
    }

    private boolean validatePosNumber(double id){
        return id > 0;
    }
}
