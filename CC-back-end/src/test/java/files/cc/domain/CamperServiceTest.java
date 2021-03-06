package files.cc.domain;

import files.cc.data.CamperRepository;
import files.cc.models.Camper;

import files.cc.models.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CamperServiceTest {

    @Autowired
    CamperService service;

    @MockBean
    CamperRepository repository;

    //TODO: review tests
    //   - specifically:
    //      - Address testing below
    //      - Delete testing (once implemented)

//  FIND TESTS
    @Test
    void shouldFindAllCampers(){
        List<Camper> mockCampers = List.of(new Camper(), new Camper(), new Camper(), new Camper());

        when(repository.findAll()).thenReturn(mockCampers);

        List<Camper> campers = service.findAll();

        assertNotNull(campers);
        assertEquals(4, campers.size());
    }

    @Test
    void shouldNotFindNonexistentCamper(){
        when(repository.findById(1)).thenReturn(new Camper());

        Camper camper = service.findById(2);

        assertNull(camper);
    }

    @Test
    void shouldFindCamperId1(){
        Camper camper = makeCamper();
        camper.setCamperId(1);
        Camper mockCamper = camper;

        when(repository.findById(1)).thenReturn(mockCamper);

        Camper result = service.findById(1);

        assertEquals(1, result.getCamperId());
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
        Camper camper = makeCamper();
        Result<Camper> result;
        camper.setAddress(null);
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());
        
        camper =makeCamper();
        camper.setCity(null);
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());

        camper =makeCamper();
        camper.setState("ABCD");
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());
        
        camper = makeCamper();
        camper.setZip("888888");
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddInvalidZip(){
        Camper camper = makeCamper();
        Result<Camper> result = new Result<>();

        camper.setZip("a7d92");
        result = service.add(camper);
        assertFalse(result.isSuccess());

        camper.setZip("123456");
        result = service.add(camper);
        assertFalse(result.isSuccess());

        camper.setZip("a7992");
        result = service.add(camper);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddInvalidPhone(){
        Camper camper = makeCamper();
        Result<Camper> result = new Result<>();

        camper.setPhone("4200271");
        result = service.add(camper);
        assertFalse(result.isSuccess());

        camper.setPhone("641420jdbc");
        result = service.add(camper);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddInvalidEmail(){
        Camper camper = makeCamper();
        Result<Camper> result;

        camper.setEmail(null);
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());

        camper.setEmail("hereIsAnEmailAddress.com");
        result = service.add(camper);
        assertEquals(ResultType.INVALID, result.getType());
    }

//  UPDATE TESTS
    @Test
    void shouldUpdate(){
        Camper camper = makeCamper();
        Result<Camper> result;
        when(repository.update(camper)).thenReturn(true);
        
        camper.setCamperId(1);
        result=service.update(camper);
        assertEquals(ResultType.SUCCESS,result.getType());
    }

    @Test
    void shouldNotUpdateIfNull(){
        Camper emptyCamper = new Camper();
        Result<Camper> result;

        result = service.update(null);
        assertEquals(ResultType.INVALID, result.getType());

        result = service.update(emptyCamper);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateIfNameIsInvalid(){
        Camper camper = makeCamper();
        Result<Camper> result;

        camper.setFirstName("Billiam");
        result = service.update(camper);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateIfAddressIsInvalid(){
        Camper camper = makeCamper();
        Result<Camper> result;

        camper.setAddress(null);
        result = service.update(camper);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateIfEmailIsInvalid(){
        Camper camper = makeCamper();
        Result<Camper> result;

        camper.setAddress("Billy.com");
        result = service.update(camper);
        assertEquals(ResultType.INVALID, result.getType());
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
        camper.setUsername("user1");
        camper.setPassword("pw1");
        camper.setRole(Role.USER);
        camper.setFirstName("Doug");
        camper.setLastName("Dimmadome");
        camper.setPhone("(777)222-9101");
        camper.setEmail("DD@fishersunited.com");
        camper.setCampingMethod("Tent");
        camper.setAddress("123 Western Heights");
        camper.setCity("Portland");
        camper.setState("IL");
        camper.setZip("60053");

        return camper;
    }
}