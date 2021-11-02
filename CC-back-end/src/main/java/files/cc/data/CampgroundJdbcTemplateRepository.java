package files.cc.data;

import files.cc.data.mappers.CampgroundMapper;
import files.cc.models.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampgroundJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public CampgroundJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

<<<<<<< HEAD
    public List<Campground> findAll(){
        final String sql = "select campground_id, name, address, city, state, zip, phone, email, capacity, " +
                "standard_rate, weekend_rate " +
                "from campground limit 1000; ";
        return jdbcTemplate.query(sql, new CampgroundMapper());
    }
=======

>>>>>>> 98c37b47df56814d33ee66f3db6e30ae6c10b5dc
}
