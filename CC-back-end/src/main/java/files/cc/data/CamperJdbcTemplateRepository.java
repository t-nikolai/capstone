package files.cc.data;

import files.cc.data.mappers.CamperMapper;
import files.cc.models.Camper;
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
<<<<<<< HEAD
    public List<Camper> findAll() {
        final String sql = "select camper_id, first_name, last_name, camping_method, phone, email, " +
            "address, city, state, zip " +
=======
    public List<Camper> findAll() {     // ADMIN Privileges
        final String sql = "select camper_id, first_name, last_name, camping_method, camper_phone, camper_email, " +
            "camper_address, camper_city, camper_state, camper_zip " +
>>>>>>> 98c37b47df56814d33ee66f3db6e30ae6c10b5dc
            "from camper limit 1000; ";
        return jdbcTemplate.query(sql, new CamperMapper());
    }

    @Override
<<<<<<< HEAD
    public Camper findById(int camper_id){
        final String sql = "select camper_id, first_name, last_name, method, phone, " +
                "email, address, city, state, zip " +
=======
    public Camper findById(int camper_id){      // ADMIN Privileges
        final String sql = "select camper_id, first_name, last_name, camping_method, camper_phone, " +
                "camper_email, camper_address, camper_city, camper_state, camper_zip " +
>>>>>>> 98c37b47df56814d33ee66f3db6e30ae6c10b5dc
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
    public Camper add(Camper camper){       // USER Privileges
        final String sql = "insert into camper (first_name, last_name, camping_method, " +
                "camper_phone, camper_email, camper_address, camper_city, camper_state, camper_zip) " +
                "values(?,?,?,?,?,?,?,?,?); ";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, camper.getFirst_name());
            ps.setString(2, camper.getLast_name());
            ps.setString(3, camper.getCamping_method());
            ps.setString(4, camper.getCamper_phone());
            ps.setString(5, camper.getCamper_email());
            ps.setString(6, camper.getCamper_address());
            ps.setString(7, camper.getCamper_city());
            ps.setString(8, camper.getCamper_state());
            ps.setInt(9, camper.getCamper_zip());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        camper.setCamper_id(keyHolder.getKey().intValue());
        return camper;
    }

    @Override
    public boolean update(Camper camper){       // USER Privileges
            final String sql = "update camper set "
                    + "first_name = ?, "
                    + "last_name = ?, "
                    + "camping_method = ?, "
                    + "phone = ?, "
                    + "email = ?, "
                    + "address = ?, "
                    + "city = ?, "
                    + "state = ?, "
                    + "zip = ? ;";

            return jdbcTemplate.update(sql,
                    camper.getFirst_name(),
                    camper.getLast_name(),
                    camper.getCamping_method(),
                    camper.getCamper_phone(),
                    camper.getCamper_email(),
                    camper.getCamper_address(),
                    camper.getCamper_city(),
                    camper.getCamper_state(),
                    camper.getCamper_zip(),
                    camper.getCamper_id()) > 0;
    }

    @Override
    public boolean deleteById(int camper_id){
        jdbcTemplate.update("delete from camper where camper_id = ?", camper_id);
        return jdbcTemplate.update("delete from camper where camper_id = ?", camper_id) > 0;
    }
}