package files.cc.data;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CampsiteJdbcTemplateRepository {

    private final JdbcTemplate jdbcTemplate;

    public CampsiteJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
