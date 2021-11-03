package files.cc.domain;

import files.cc.data.CamperRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CamperServiceTest {

    @Autowired
    CamperService service;

    @MockBean
    CamperRepository repository;

//  FIND TESTS
    @Test
    void shouldFindAllCampers(){

    }

    @Test
    void shouldNotFindNonexistentCamper(){

    }

    @Test
    void shouldFindCamperId3(){

    }

//  ADD TESTS
    @Test
    void shouldAdd(){

    }

    @Test
    void shouldNotAddIfNull(){

    }

    @Test
    void shouldNotAddIfNameIsInvalid(){

    }

    @Test
    void shouldNotAddIfAddressIsInvalid(){

    }

    @Test
    void shouldNotAddInvalidEmail(){

    }

//  UPDATE TESTS
    @Test
    void shouldUpdate(){

    }

    @Test
    void shouldNotUpdateIfNull(){

    }

    @Test
    void shouldNotUpdateIfNameIsInvalid(){

    }

    @Test
    void shouldNotUpdateIfAddressIsInvalid(){

    }

    @Test
    void shouldNotUpdateIfEmailIsInvalid(){

    }

//  DELETE TESTS
    // TODO: CAMPER SERVICE DELETE TESTING
    @Test
    void shouldDelete(){

    }

    @Test
    void shouldNotDeleteIfInvalid(){

    }
}