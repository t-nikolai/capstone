package files.cc.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class CampgroundRepositoryTest {

    @Autowired
    CampgroundJdbcTemplateRepository repository;

    @Autowired
    KnownGoodState knownGoodState;



}