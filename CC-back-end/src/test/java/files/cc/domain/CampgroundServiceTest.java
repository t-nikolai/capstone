package files.cc.domain;
import files.cc.data.CampgroundRepository;
import files.cc.models.Campground;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampgroundServiceTest {

    @Autowired
    CampgroundService service;

    @MockBean
    CampgroundRepository repository;


    //TODO: go over all the tests - mockito requirements, nothing going through to repo functions, all positive and negaitve cases,
    // correct (valid/invalid) inputs, etc.

    @Test
    void shouldNotAddIfNull() {
        Campground emptyCampground = new Campground();
        Result<Campground> result;

        result = service.add(null);
        assertEquals(ResultType.INVALID, result.getType());

        result = service.add(emptyCampground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfNameIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setName(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfAddressIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setAddress(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfCityIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setCity(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfStateIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setState(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfZipIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setZip(0);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
        campground.setZip(0);

        campground.setZip(666666);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setZip(-4 / 6 * 4);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfPhoneIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setPhone(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setPhone(null);
        result = service.add(campground);
        System.out.println(result.getMessages());
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfEmailIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setEmail(null);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setEmail("hereIsAnEmailAddress.com");
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfCapacityIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setCapacity(-7);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfStandardRateIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setStandardRate(BigDecimal.valueOf(-5.00));
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfWeekendRateIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setWeekendRate(BigDecimal.valueOf(-5.00));
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotAddIfCampgroundIdIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground> result;

        campground.setCampgroundId(1);
        result = service.add(campground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldAddWhenValid() {
        Campground campground = makeCampground();
        Result<Campground> result;
        when(repository.add(campground)).thenReturn(campground);

        result = service.add(campground);
        assertEquals(ResultType.SUCCESS, result.getType());
    }

    @Test
    void shouldNotUpdateIfNull() {
        Campground emptyCampground = new Campground();
        Result<Campground> result;

        result = service.update(null);
        assertEquals(ResultType.INVALID, result.getType());

        result = service.update(emptyCampground);
        assertEquals(ResultType.INVALID, result.getType());
    }

    @Test
    void shouldNotUpdateIfNameIsInvalid() {
        Campground campground = makeCampground();
        Result<Campground>

        // name validation (null)
        campground.setName(null);
        result = service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setName("Tent Place");

        // address validation (null)
        campground.setAddress(null);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setAddress("1231 Forest Hills Dr.");

        // city validation (null)
        campground.setCity(null);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setCity("Woodland");

        // state validation (null)
        campground.setState(null);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setState("WI");

        // zip validation (under 6 numbers, over 6 numbers, not all numbers)
        campground.setZip(0);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());
        campground.setZip(0);

        campground.setZip(666666);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setZip(-4 / 6 * 4);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setZip(43414);

        // phone validation (null, doesn't just contain numbers)
        campground.setPhone(null);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setPhone("abcde"); // TODO : check it!
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setPhone("4142229999");

        // email validation (null, doesn't contain '@')
        campground.setEmail(null);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setEmail("hereIsAnEmailAddress.com");
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setEmail("tentplace120@npus.net");

        // capacity validation (under 0)
        campground.setCapacity(-7);
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setCapacity(12);

        // standardR validation (under 0)
        campground.setStandardRate(BigDecimal.valueOf(-5.00));
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setStandardRate(new BigDecimal(25.00));

        // weekendR validation (under 0)
        campground.setWeekendRate(BigDecimal.valueOf(-5.00));
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setWeekendRate(new BigDecimal(30.00));

        // campgroundId validation (not 0)
        service.update(campground);
        assertEquals(ResultType.INVALID, result.getType());

        campground.setCampgroundId(1);
    }

    @Test
    void shouldUpdateWhenValid() {
        Campground campground = makeCampground();
        Result<Campground> result;
        when(repository.update(campground)).thenReturn(true);

        campground.setCampgroundId(1);

        result = service.update(campground);
        assertEquals(ResultType.SUCCESS, result.getType());
    }

    Campground makeCampground(){
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