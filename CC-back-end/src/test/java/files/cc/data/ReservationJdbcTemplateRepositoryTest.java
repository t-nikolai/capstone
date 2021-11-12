package files.cc.data;

import files.cc.models.Camper;
import files.cc.models.Campsite;
import files.cc.models.Reservation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReservationJdbcTemplateRepositoryTest {

    private static final int NEXT_ID = 5;

    @Autowired
    ReservationJdbcTemplateRepository repository;

    @Autowired
    CampsiteJdbcTemplateRepository campsiteRepository;

    @Autowired
    CamperJdbcTemplateRepository camperRepository;

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
        List<Reservation> reservations = repository.findAll();
        assertTrue(reservations.size()>=4);
    }

    @Test
    void shouldFindById(){
        Reservation reservation = repository.findById(2);
        assertNotNull(reservation);
        assertEquals(2, reservation.getReservationId());
    }

    @Test
    void shouldNotFindMissingById(){
        Reservation reservation = repository.findById(99);
        assertNull(reservation);
    }

//  ADD TESTS
    @Test
    void shouldAdd(){
        Reservation reservation = new Reservation();
        Campsite cs1 = campsiteRepository.findById(1);
        Camper cr1 = camperRepository.findById(2);
        reservation.setTotal(new BigDecimal(10));

        assertNull(repository.findById(5));

        reservation.setCampsite(cs1);
        reservation.setCamper(cr1);
        reservation.setStartDate(LocalDate.of(2022,01,01));
        reservation.setEndDate(LocalDate.of(2022,02,01));

        repository.add(reservation);
        assertNotNull(repository.findById(5));
    }

    @Test
    void shouldUpdate(){
        Reservation reservation = repository.findById(3);
        reservation.setCamper(camperRepository.findById(2));

        assertTrue(repository.update(reservation));
    }

    @Test
    void shouldNotUpdate(){
        Reservation reservation = new Reservation();
        Campsite cs1 = campsiteRepository.findById(1);
        Camper cr1 = camperRepository.findById(2);
        reservation.setTotal(new BigDecimal(10));

        reservation.setCampsite(cs1);
        reservation.setCamper(cr1);
        reservation.setStartDate(LocalDate.of(2022,01,01));
        reservation.setEndDate(LocalDate.of(2022,02,01));

        reservation.setReservationId(222);
        assertFalse(repository.update(reservation));
    }

    @Test
    void shouldDeleteById(){
        assertTrue(repository.deleteById(4));
    }





}