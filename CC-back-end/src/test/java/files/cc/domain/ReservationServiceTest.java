package files.cc.domain;

import files.cc.data.ReservationRepository;
import files.cc.models.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

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
}