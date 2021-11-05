package files.cc.domain;

import files.cc.data.CamperRepository;
import files.cc.data.CampsiteRepository;
import files.cc.data.ReservationRepository;
import files.cc.models.Camper;
import files.cc.models.Campsite;
import files.cc.models.Reservation;
import files.cc.models.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReservationServiceTest {

    @Autowired
    ReservationService service;

    @MockBean
    ReservationRepository repository;

    @Test
    void shouldFindAll(){
        List<Reservation> mockReservations = List.of(new Reservation(), new Reservation(), new Reservation(), new Reservation());

        when(repository.findAll()).thenReturn(mockReservations);

        List<Reservation> reservations = service.findAll();

        assertNotNull(reservations);
        assertEquals(4, reservations.size());
    }

    @Test
    void shouldFindById(){
        Reservation mockReservation = new Reservation(1, LocalDate.of(1999,9,9),
                LocalDate.of(1999,9,19), new BigDecimal(10), new Campsite(), new Camper());
        when(repository.findById(1)).thenReturn(mockReservation);

        Reservation reservation = service.findById(1);

        assertNotNull(reservation);
        assertEquals(1, reservation.getReservationId());
    }

    @Test
    void shouldNotFindById(){
        Reservation mockReservation = null;
        when(repository.findById(999)).thenReturn(mockReservation);

        Reservation reservation = service.findById(999);

        assertNull(reservation);
    }

    @Test
    void shouldAdd(){
        Reservation mockReservation = makeReservation();
        mockReservation.setReservationId(5);

        Reservation reservation = makeReservation();

        when(repository.add(reservation)).thenReturn(mockReservation);

        Result<Reservation> result = service.add(reservation);

        assertTrue(result.isSuccess());
        assertEquals(5, result.getPayload().getReservationId());
    }

    @Test
    void shouldNotAddBcId(){
        // id not being 0
        Reservation reservation = makeReservation();
        reservation.setReservationId(5);
        Result<Reservation> result = service.add(reservation);

        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddBcDates(){
        // dates are null
        Reservation reservation = makeReservation();
        reservation.setStartDate(null);
        reservation.setEndDate(null);
        Result<Reservation> result = service.add(reservation);
        assertFalse(result.isSuccess());

        // dates in the past
        reservation = makeReservation();
        reservation.setStartDate(LocalDate.of(1999,9,9));
        reservation.setEndDate(LocalDate.of(1999,9,19));
        result = service.add(reservation);
        assertFalse(result.isSuccess());

        // start date after end date
        reservation = makeReservation();
        reservation.setStartDate(LocalDate.of(2021, 11, 11));
        reservation.setEndDate(LocalDate.of(2021, 11, 1));
        result = service.add(reservation);
        assertFalse(result.isSuccess());

        // dates overlap (? with other reservations)
        Campsite campsite = makeCampsite();
        campsite.setSiteId(3);
        reservation = makeReservation();
        reservation.setSite(campsite);
        reservation.setStartDate(LocalDate.of(2023, 3, 2));
        reservation.setEndDate(LocalDate.of(2023, 3, 5));

        result = service.add(reservation);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotAddBcObjectsNull(){
        Reservation reservation = makeReservation();
        reservation.setSite(null);
        reservation.setCamper(null);

        Result<Reservation> result = service.add(reservation);

        assertFalse(result.isSuccess());
    }

    @Test
    void shouldUpdate(){
        Reservation reservation = makeReservation();
        reservation.setReservationId(3);

        when(repository.update(reservation)).thenReturn(true);

        Result<Reservation> result = service.update(reservation);

        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotUpdateBcId(){
        Reservation reservation = makeReservation();
        Result<Reservation> result = service.update(reservation);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateBcDates(){
        // dates are not valid
        Reservation reservation = makeReservation();
        reservation.setReservationId(3);
        reservation.setStartDate(null);
        reservation.setEndDate(null);
        Result<Reservation> result = service.update(reservation);
        assertFalse(result.isSuccess());

        // dates in the past
        reservation = makeReservation();
        reservation.setReservationId(3);
        reservation.setStartDate(LocalDate.of(1999,9,9));
        reservation.setEndDate(LocalDate.of(1999,9,19));
        result = service.update(reservation);
        assertFalse(result.isSuccess());

        // start date after end date
        reservation = makeReservation();
        reservation.setReservationId(3);
        reservation.setStartDate(LocalDate.of(2021, 11, 11));
        reservation.setEndDate(LocalDate.of(2021, 11, 1));
        result = service.update(reservation);
        assertFalse(result.isSuccess());

        // dates overlap (? with other reservations)
        Campsite campsite = makeCampsite();
        campsite.setSiteId(3);
        reservation = makeReservation();
        reservation.setReservationId(3);
        reservation.setSite(campsite);
        reservation.setStartDate(LocalDate.of(2023, 3, 2));
        reservation.setEndDate(LocalDate.of(2023, 3, 5));

        result = service.update(reservation);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldNotUpdateBcObjectsNull(){
        Reservation reservation = makeReservation();
        reservation.setReservationId(3);
        reservation.setSite(null);
        reservation.setCamper(null);

        Result<Reservation> result = service.update(reservation);
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldDeleteById(){
        Reservation reservation = makeReservation();
        reservation.setReservationId(4);
        when(repository.deleteById(reservation.getReservationId())).thenReturn(true);
        Result<Reservation> result = service.deleteById(reservation.getReservationId());
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDeleteById(){
        Reservation reservation = makeReservation();
        reservation.setReservationId(999);
        when(repository.deleteById(reservation.getReservationId())).thenReturn(false);
        Result<Reservation> result = service.deleteById(reservation.getReservationId());
        assertFalse(result.isSuccess());
    }

    @Test
    void shouldDeleteByCamperId()
    {
        Reservation reservation = makeReservation();
        reservation.setReservationId(4);
        when(repository.deleteByCamperId(reservation.getCamper().getCamperId())).thenReturn(true);
        Result<Reservation> result = service.deleteByCamperId(reservation.getCamper().getCamperId());
        assertTrue(result.isSuccess());
    }

    @Test
    void shouldNotDeleteByCamperId(){
        Reservation reservation = makeReservation();
        reservation.setReservationId(4);

        when(repository.deleteByCamperId(999)).thenReturn(false);

        Result<Reservation> result = service.deleteByCamperId(999);
        assertFalse(result.isSuccess());
    }

    private Camper makeCamper(){
        return new Camper(1, "user", "pw", Role.USER, "first", "last", "rv", "1111111111",
                "email@email.com", "address", "city", "ST", 11111);
    }

    private Campsite makeCampsite(){
        return new Campsite(1, "name", 1);
    }

    private Reservation makeReservation() {
        return new Reservation(0, LocalDate.of(2022,9,9),
                LocalDate.of(2022,9,19), new BigDecimal(10), makeCampsite(), makeCamper());
    }
}