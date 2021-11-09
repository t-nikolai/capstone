package files.cc.domain;

import files.cc.data.CamperRepository;
import files.cc.models.Camper;
import files.cc.models.Role;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.valueOf;

@Service
public class CamperService {
    private final CamperRepository repository;

    public CamperService(CamperRepository repository){
        this.repository = repository;
    }
    
    public List<Camper> findAll() {
        return repository.findAll();
    }
    
    public Camper findById(int camperId) {
        return repository.findById(camperId);
    }
    
    public Result<Camper> add(Camper camper) throws DataAccessException{
        Result<Camper> result = addValidate(camper);

        if (!result.isSuccess()){
            return result;
        }
        camper = repository.add(camper);

        if (camper == null){
            result.addMessage("camper could not be added", ResultType.FAIL);
            return result;
        }

        result.setPayload(camper);
        return result;
    }

    public Result<Camper> update(Camper camper) throws DataAccessException{
        Result<Camper> result = updateValidate(camper);
        if (!result.isSuccess()) {
            return result;
        }

        if (!repository.update(camper)) {
            String msg = String.format("camperId: %s, not found or could not be updated", camper.getCamperId());
            result.addMessage(msg, ResultType.NOT_FOUND);
            return result;
        }

        result.setPayload(camper);
        return result;
    }

    public Result<Camper> deleteById(int camperId) throws DataAccessException{
        Result<Camper> result = deleteValidate(camperId);
        boolean isDeleted = repository.deleteById(camperId);

        if (!isDeleted){
            result.addMessage("This camper could not be deleted.", ResultType.FAIL);
        }
        return result;
    }





//////////////////////////////////////////////////
    private Result<Camper> addValidate(Camper camper){
        Result<Camper> result = new Result<>();

        if (camper == null) {
            result.addMessage("camper cannot be null", ResultType.INVALID);
            return result;
        }

        if (camper.getCamperId() != 0){
            result.addMessage("camper id should be 0 before being added to the DB", ResultType.INVALID);
            return result;
        }

        List<Camper> camperList = repository.findAll();
        for(Camper c: camperList){
            if (camper.getUsername().equalsIgnoreCase(c.getUsername())){
                result.addMessage("username should be unique; the selected username has already been used", ResultType.INVALID);
                return result;
            }
        }

        if (camper.getRole() == null || camper.getRole().toString().isBlank() || camper.getRole().toString().isEmpty()){
            camper.setRole(Role.USER);
        }

        result = validateRequiredInfo(camper);
        return result;
    }

    private Result<Camper> updateValidate(Camper camper){
        Result<Camper> result = new Result<>();

        if (camper == null) {
            result.addMessage("camper cannot be null", ResultType.INVALID);
            return result;
        }

        if (!validatePosNumber(camper.getCamperId())){
            result.addMessage("camper ID should be a positive number", ResultType.INVALID);
            return result;
        }

        result = validateRequiredInfo(camper);
        return result;
    }

    private Result<Camper> deleteValidate(int camperId){
        Result<Camper> result = new Result<>();

        // TODO: add checks to make see if camper Id has been used in any reservations.
        //      If so, delete all reservations with the same camper Id before deleting the camper.

        if (!validatePosNumber(camperId)){
            result.addMessage("camper ID should be a positive number", ResultType.INVALID);
        }
        return result;
    }

    private Result<Camper> validateRequiredInfo(Camper camper){
        Result<Camper> result = new Result<>();

        if (camper == null) {
            result.addMessage("camper cannot be null", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(camper.getFirstName()) || isNullOrBlank(camper.getLastName())) {
            result.addMessage("camper's first and last name are both required fields and cannot be blank", ResultType.INVALID);
            return result;
        }

        camper.setPhone(camper.getPhone().replaceAll("[^0-9]", ""));     // replace anything that isn't a number 0-9 with ""

        if (isNullOrBlank(camper.getPhone()) || !camper.getPhone().matches("[0-9]{10}")){       // make sure phone matches exactly 10 digits
            result.addMessage("camper's phone number is required, with a valid phone number containing only 10 digits", ResultType.INVALID);
        }

        if (isNullOrBlank(camper.getEmail()) || !camper.getEmail().contains("@")){
            result.addMessage("camper's email address is required and must be valid", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(camper.getAddress()) || isNullOrBlank(camper.getCity()) || isNullOrBlank(camper.getState()) || camper.getState().length() != 2
                || !camper.getZip().matches("^[0-9]{5}(?:-[0-9]{4})?$") ){
            result.addMessage("camper's full address is required, with a valid 5-digit zip code", ResultType.INVALID);
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
