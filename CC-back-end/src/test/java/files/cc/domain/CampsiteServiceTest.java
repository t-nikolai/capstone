package files.cc.domain;

import files.cc.data.CampsiteRepository;
import files.cc.models.Campground;
import files.cc.models.Campsite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampsiteServiceTest {

    @Autowired
    CampsiteService service;

    @MockBean
    CampsiteRepository repository;

    @Test
    void shouldFindAll(){
        List<Campsite> mockCampsites = List.of(new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(),
                new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(),
                new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(),
                new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(), new Campsite(),
                new Campsite(), new Campsite(), new Campsite(), new Campsite());
        when(repository.findAll()).thenReturn(mockCampsites);
        List<Campsite> campsites = service.findAll();

        assertNotNull(campsites);
        assertEquals(44, campsites.size());
    }

    @Test
    void shouldFindById(){
        when(repository.findById(1)).thenReturn(new Campsite(1, "campsite 1", new Campground()));

        Campsite campsite = service.findById(1);

        assertNotNull(campsite);
        assertEquals(1, campsite.getSiteId());
    }

    @Test
    void shouldNotFindByBadId(){
        when(repository.findById(999)).thenReturn(null);

        Campsite campsite = service.findById(999);

        assertNull(campsite);
    }

}