package files.cc.domain;
import files.cc.data.CampgroundRepository;
import files.cc.models.Campground

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampgroundServiceTest {
    @Autowired
    CampgroundService service;

    @MockBean
    CampgroundRepository repository;

    @Test
    shouldNotAddWhenInvalid() {
        Campground emptyCampground = new Campground();
        Campground campground = makeCampground();

        Result<Campground> result;

        //when all fields are null
        result = service.add(emptyCampground);
        assertEquals(ResultType.INVALID, result.getType());

        // name validation
        campground.setName(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setName("Tent Place");

        // address validation
        campground.setAddress(null);
        service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setAddress("1231 Forest Hills Dr.");

        // city validation
        campground.setCity(null);
        service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setCity("Woodland");

        // state validation
        campground.setState(null);
        service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setState("WI");

        // zip validation
        campground.setZip(0);
        service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());  campground.setZip(0);


        service.666666dd(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setZip(43414);

        // phone validation

        // email validation

        // capacity validation

        // standardR validation

        // weekendR validation

        // campgroundId validation (when id == 0)
        }



    Campground makeCampground(){
        Campground campground = new Campground();
        campground.setCampgroundId(1);
        campground.setName("Tent Place");
        campground.setAddress("1231 Forest Hills Dr.");
        campground.setCity("Woodland");
        campground.setState("WI");
        campground.setZip(43414);
        campground.setEmail("tentplace120@npus.net");
        campground.setPhone("(414)222-9999");
        campground.setCapacity(12);
        campground.setStandardRate(new BigDecimal(25.00));
        campground.setWeekendRate(new BigDecimal(30.00));

        return campground;
    }
}