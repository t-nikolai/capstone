package files.cc.data;

import files.cc.data.mappers.CamperMapper;
import files.cc.models.Camper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

@Repository
public class CamperJdbcTemplateRepository implements CamperRepository {
    private final JdbcTemplate jdbcTemplate;

    public CamperJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    @Override
    public List<Camper> findAll() throws DataAccessException {     // ADMIN Privileges
        final String sql = "select camper_id, first_name, last_name, camping_method, phone, email, " +
            "address, city, state, zip " +
            "from camper limit 1000; ";
        return jdbcTemplate.query(sql, new CamperMapper());
    }

    @Override
    public Camper findById(int camper_id) throws DataAccessException{      // ADMIN Privileges
        final String sql = "select camper_id, first_name, last_name, camping_method, phone, " +
                "email, address, city, state, zip " +
                "from camper " +
                "where camper_id = ? ;";
        Camper camper = jdbcTemplate.query(sql, new CamperMapper(), camper_id).stream()
                .findFirst().orElse(null);

//        if (camper != null) {
//            addAgencies(agent);
//            addAliases(agent);
//        }

        return camper;
    }

    @Override
    @Transactional
    public Camper add(Camper camper) throws DataAccessException{       // USER Privileges
        final String sql = "insert into camper (first_name, last_name, camping_method, " +
                "phone, email, address, city, state, zip) " +
                "values(?,?,?,?,?,?,?,?,?); ";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, camper.getFirstName());
            ps.setString(2, camper.getLastName());
            ps.setString(3, camper.getCampingMethod());
            ps.setString(4, camper.getPhone());
            ps.setString(5, camper.getEmail());
            ps.setString(6, camper.getAddress());
            ps.setString(7, camper.getCity());
            ps.setString(8, camper.getState());
            ps.setInt(9, camper.getZip());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        camper.setCamperId(keyHolder.getKey().intValue());
        return camper;
    }

    @Override
    public boolean update(Camper camper) throws DataAccessException{       // USER Privileges
            final String sql = "update camper set "
                    + "first_name = ?, "
                    + "last_name = ?, "
                    + "camping_method = ?, "
                    + "phone = ?, "
                    + "email = ?, "
                    + "address = ?, "
                    + "city = ?, "
                    + "state = ?, "
                    + "zip = ? "
                    + "where camper_id = ?; ";

            return jdbcTemplate.update(sql,
                    camper.getFirstName(),
                    camper.getLastName(),
                    camper.getCampingMethod(),
                    camper.getPhone(),
                    camper.getEmail(),
                    camper.getAddress(),
                    camper.getCity(),
                    camper.getState(),
                    camper.getZip(),
                    camper.getCamperId()) > 0;
    }

    @Override
    public boolean deleteById(int camper_id) throws DataAccessException{
        jdbcTemplate.update("delete from camper where camper_id = ?", camper_id);
        return jdbcTemplate.update("delete from camper where camper_id = ?", camper_id) > 0;
    }
}