package files.cc.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ReservationJdbcTemplateRepositoryTest {

    private static final int NEXT_ID = 5;

    @Autowired
    ReservationJdbcTemplateRepository repository;

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
        
    }

}