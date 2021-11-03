package files.cc.data;

import files.cc.models.Camper;
import files.cc.models.Campground;
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
        assertTrue(campers.size() >= 4);
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
    void shouldUpdate(){
        Camper camper
    }



    Camper makeCamper(){
        
    }

}