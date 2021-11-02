package files.cc.data;

import files.cc.data.mappers.CampgroundMapper;
import files.cc.models.Campground;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CampgroundJdbcTemplateRepository implements CampgroundRepository {
    private final JdbcTemplate jdbcTemplate;

    public CampgroundJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Campground> findAll(){
        final String sql = "select campground_id, name, address, city, state, zip, phone, email, capacity, " +
                "standard_rate, weekend_rate " +
                "from campground limit 1000; ";
        return jdbcTemplate.query(sql, new CampgroundMapper());
    }

    // TODO: find by prefix (state, city, name, etc.)  using lambdas/anon functions

    @Override
    public Campground add(Campground campground) {
        final String sql = "insert into campground (campground_id, name, address, city, state, zip,\n" +
                "phone, email, capacity, standard_rate, weekend_rate) values "
                + "(?,?,?,?,?,?,?,?,?,?,?);";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, campground.getName());
            ps.setString(2, campground.getAddress());
            ps.setString(3, campground.getCity());
            ps.setString(4, campground.getState());
            ps.setInt(5, campground.getZip());
            ps.setString(6, campground.getPhone());
            ps.setString(7, campground.getEmail());
            ps.setInt(8, campground.getCapacity());
            ps.setBigDecimal(9, campground.getStandardRate());
            ps.setBigDecimal(10, campground.getWeekendRate());

            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        campground.setCampgroundId(keyHolder.getKey().intValue());
        return campground;
    }

    @Override
    public boolean update (Campground campground){
        final String sql = "update campground set "
                + "`name` = ?, "
                + "address = ?, "
                + "city = ?, "
                + "`state` = ?, "
                + "zip = ?, "
                + "phone = ?, "
                + "email = ?, "
                + "standard_rate = ? "
                + "weekend_rate = ? "
                + "where campground_id = ?;";

        return jdbcTemplate.update(sql,
                campground.getName(),
                campground.getAddress(),
                campground.getCity(),
                campground.getState(),
                campground.getZip(),
                campground.getPhone(),
                campground.getEmail(),
                campground.getStandardRate(),
                campground.getWeekendRate(),
                campground.getCampgroundId()) > 0;
    }

    @Override
    public boolean deleteById (int campgroundId) {
        jdbcTemplate.update("delete from campground where campground_id = ?;", campgroundId);
        return jdbcTemplate.update("delete from campground where campground_id = ?;", campgroundId) > 0;
    }
}
