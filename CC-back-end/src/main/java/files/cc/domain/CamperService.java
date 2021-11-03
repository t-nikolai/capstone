package files.cc.domain;

import files.cc.data.CamperRepository;
import files.cc.models.Camper;
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
    
    public Result<Camper> add(Camper camper) throws DataAccessException {
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

//    public boolean deleteById(int camperId) throws DataAccessException{
//        Result<Camper> result = deleteValidate(camperId);
//        return repository.deleteById(camperId);
//    }


    
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

        if (camper.getPhone() == null){
            camper.setPhone(" ");
        }

        if (isNullOrBlank(camper.getEmail()) || !camper.getEmail().contains("@")){
            result.addMessage("camper's email address is requried and must be valid", ResultType.INVALID);
            return result;
        }

        if (isNullOrBlank(camper.getAddress()) || isNullOrBlank(camper.getCity()) || isNullOrBlank(camper.getState())
                || !valueOf(camper.getZip()).matches("[0-9]{5}") ){          // zip code validation - might be funky
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
