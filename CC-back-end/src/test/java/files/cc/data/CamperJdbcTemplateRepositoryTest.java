package files.cc.data;

import files.cc.models.Camper;
import files.cc.models.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CamperJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 5;

    @Autowired
    CamperJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup(){
        knownGoodState.set();
    }

    @Test
    void shouldFindAll(){
        List<Camper> campers =repository.findAll();
        assertTrue(campers.size() >= 3 && campers.size()<=5);
    }

    @Test
    void shouldFindById(){
        Camper camperOne = repository.findById(1);
        assertEquals(1,camperOne.getCamperId());
        assertEquals("C First Name 1",camperOne.getFirstName());
    }

    @Test
    void shouldNotFindByWrongId(){
        Camper camper = repository.findById(999);

        assertNull(camper);
    }

    @Test
    void shouldAdd(){
        Camper camper = new Camper();
        camper.setUsername("user1");
        camper.setPassword("pw1");
        camper.setRole(Role.USER);
        camper.setFirstName("Doug");
        camper.setLastName("Dimmadome");
        camper.setPhone("(777)222-9101");
        camper.setEmail("jj@fishersunited.com");
        camper.setCampingMethod("Tent");
        camper.setAddress("123 Western Heights");
        camper.setCity("Portland");
        camper.setState("IL");
        camper.setZip(60053);

        camper = repository.add(camper);
        assertNotNull(camper);
        assertEquals(5, camper.getCamperId());
    }

    @Test
    void shouldUpdate(){
        Camper camper = repository.findById(2);
//        System.out.println(camper.getFirstName() + "\n" + camper.getLastName() + "\n" +
//                camper.getCampingMethod() + "\n" + camper.getFirstName() + "\n" + camper.getFirstName() + "\n" +
//                camper.getFirstName() + "\n" + camper.getFirstName() + "\n" +);
        camper.setFirstName("Thomas");
        camper.setState("AK");
        camper.setZip(99991);
        //camper.setCampingMethod("#1");
        System.out.println(camper.getFirstName() + "\n" + camper.getState() + "\n" + camper.getCampingMethod());
        assertTrue(repository.update(camper));

    }

    @Test
    void shouldNotUpdate(){
        Camper camper = repository.findById(1);
        camper.setCamperId(88);

        assertFalse(repository.update(camper));
    }

    @Test // TODO: make sure this test works (can't delete parent row, so can't delete camper currently)
    void shouldDelete(){
        assertTrue(repository.deleteById(4));
    }

    @Test
    void shouldNotDelete(){
        assertFalse(repository.deleteById(99));
    }

}