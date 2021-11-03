package files.cc.data;

import files.cc.data.mappers.CampsiteMapper;
import files.cc.models.Campsite;
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
    public List<Campsite> findAll(){
        final String sql = "select site_id, cs.`name` as cs_name, cs.campground_id, " +
                "from campsite cs " +
                "inner join campground cg on cs.campground_id = cg.campground_id;";
        return jdbcTemplate.query(sql, new CampsiteMapper());
    }

    @Override
    public Campsite findById(int id){
        final String sql = "select site_id, `name`, campground_id" +
                "from campsite cs " +
                "" +
                "where site_id = ?;";
        return jdbcTemplate.query(sql, new CampsiteMapper(), id).stream().findFirst().orElse(null);
    }
}
