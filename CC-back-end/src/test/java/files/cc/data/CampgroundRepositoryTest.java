package files.cc.data;

import files.cc.models.Campground;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampgroundRepositoryTest {

    final static int NEXT_ID = 5;

    @Autowired
    CampgroundJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;

    @BeforeEach
    void setup(){
        knownGoodState.set();
    }

    //---------testing rules: -----------
    //  leave first campground entry (id of 1) alone
    //  when add the id will be 5
    //  update id of 3 only
    //  delete id of 4 only

    @Test
    void shouldFindAll(){
        List<Campground> campgrounds = repository.findAll();

        assertNotNull(campgrounds);
        assertTrue(campgrounds.size() >= 3 && campgrounds.size() <= 5);
    }

    @Test
    void shouldFindById(){
        Campground campground = repository.findById(1);

        assertNotNull(campground);
        assertEquals(1, campground.getCampgroundId());
    }

    @Test
    void shouldNotFindByWrongId(){
        Campground campground = repository.findById(999);

        assertNull(campground);
    }

    @Test
    void shouldAdd(){
        Campground campground = makeCampground();

        campground = repository.add(campground);

        assertNotNull(campground);
        assertEquals(NEXT_ID, campground.getCampgroundId());
    }

    @Test
    void shouldUpdate(){
        Campground campground = makeCampground();
        campground.setCampgroundId(3);

        assertTrue(repository.update(campground));
    }

    @Test
    void shouldNotUpdate(){
        Campground campground = makeCampground();
        campground.setCampgroundId(999);

        assertFalse(repository.update(campground));
    }

    // TODO: need to fix deleteById in repo before writing tests
    @Test
    void shouldDelete(){
        assertTrue(repository.deleteById(4));
    }

    @Test
    void shouldNotDelete(){

    }

    private Campground makeCampground(){
        Campground campground = new Campground();
        campground.setCampgroundId(0);
        campground.setName("Tent Place");
        campground.setAddress("1231 Forest Hills Dr.");
        campground.setCity("Woodland");
        campground.setState("WI");
        campground.setZip(43414);
        campground.setEmail("tentplace120@npus.net");
        campground.setPhone("4142229999");
        campground.setCapacity(12);
        campground.setStandardRate(new BigDecimal(25.00));
        campground.setWeekendRate(new BigDecimal(30.00));

        return campground;
    }
}