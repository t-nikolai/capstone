package files.cc.domain;

import files.cc.data.CamperRepository;
import files.cc.models.Camper;
import files.cc.models.Campground;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CamperServiceTest {

    @Autowired
    CamperService service;

    @MockBean
    CamperRepository repository;

//  FIND TESTS
    @Test
    void shouldFindAllCampers(){

    }

    @Test
    void shouldNotFindNonexistentCamper(){

    }

    @Test
    void shouldFindCamperId3(){

    }

//  ADD TESTS
    @Test
    void shouldAdd(){
        Camper camper = makeCamper();
        Result<Camper> result;

        when(repository.add(camper)).thenReturn(camper);
        result=service.add(camper);
        assertEquals(ResultType.SUCCESS,result.getType());
    }

    @Test
    void shouldNotAddIfNull(){
        Camper emptyCamper = new Camper();

        Result<Camper> result = service.add(null);
        assertEquals(ResultType.INVALID, result.getType());

        result = service.add(emptyCamper);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfNameIsInvalid(){
        Camper camper = new Camper();
        Result<Camper> result;
        camper.setFirstName(null);
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());

        camper.setFirstName("Doug");
        camper.setLastName("");
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());

    }

    @Test
    void shouldNotAddIfAddressIsInvalid(){

    }

    @Test
    void shouldNotAddInvalidEmail(){

    }

//  UPDATE TESTS
    @Test
    void shouldUpdate(){

    }

    @Test
    void shouldNotUpdateIfNull(){

    }

    @Test
    void shouldNotUpdateIfNameIsInvalid(){

    }

    @Test
    void shouldNotUpdateIfAddressIsInvalid(){

    }

    @Test
    void shouldNotUpdateIfEmailIsInvalid(){

    }

//  DELETE TESTS
    // TODO: CAMPER SERVICE DELETE TESTING
    @Test
    void shouldDelete(){

    }

    @Test
    void shouldNotDeleteIfInvalid(){

    }

    private Camper makeCamper(){
        Camper camper = new Camper();
        camper.setFirstName("Doug");
        camper.setLastName("Dimmadome");
        camper.setPhone("(777)222-9101");
        camper.setEmail("DD@fishersunited.com");
        camper.setCampingMethod("Tent");
        camper.setAddress("123 Western Heights");
        camper.setCity("Portland");
        camper.setState("IL");
        camper.setZip(60053);

        return camper;
    }
}