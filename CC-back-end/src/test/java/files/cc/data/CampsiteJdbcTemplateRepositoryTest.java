package files.cc.data;

import files.cc.models.Campsite;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampsiteJdbcTemplateRepositoryTest {

    final static int NEXT_ID = 5;

    @Autowired
    CampsiteJdbcTemplateRepository repository;

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
        List<Campsite> campsites = repository.findAll();

        assertNotNull(campsites);
        //assertTrue()
    }
}