package files.cc.data;

import files.cc.data.mappers.CampsiteMapper;
import files.cc.models.Campsite;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CampsiteJdbcTemplateRepository implements CampsiteRepository {

    private final JdbcTemplate jdbcTemplate;

    public CampsiteJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Campsite> findAll() throws DataAccessException {
        final String sql = "select site_id, cs.`name` as cs_name, cs.campground_id as cs_cg_id, " +
                "cg.campground_id as campground_id, cg.`name` as `name`, address, city, `state`, zip, phone, email, capacity, standard_rate, weekend_rate " +
                "from campsite cs " +
                "inner join campground cg on cs.campground_id = cg.campground_id;";
        return jdbcTemplate.query(sql, new CampsiteMapper());
    }

    @Override
    public Campsite findById(int id) throws DataAccessException{
        final String sql = "select site_id, cs.`name` as cs_name, cs.campground_id as cs_cg_id, " +
                "cg.campground_id as campground_id, cg.`name` as `name`, address, city, `state`, zip, phone, email, capacity, standard_rate, weekend_rate " +
                "from campsite cs " +
                "inner join campground cg on cs.campground_id = cg.campground_id " +
                "where site_id = ?;";
        return jdbcTemplate.query(sql, new CampsiteMapper(), id).stream().findFirst().orElse(null);
    }
}
