package files.cc.data;

import files.cc.data.mappers.CamperMapper;
import files.cc.models.Camper;
import files.cc.models.Role;
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
    private final ReservationRepository reservationRepo;

    public CamperJdbcTemplateRepository(JdbcTemplate jdbcTemplate, ReservationRepository reservationRepo) {
        this.jdbcTemplate = jdbcTemplate;
        this.reservationRepo = reservationRepo;
    }

    @Override
    public List<Camper> findAll() throws DataAccessException {     // ADMIN Privileges
        final String sql = "select camper_id, `username`, `password`, `role`, first_name, last_name, camping_method, phone as cr_phone, email as cr_email, " +
            "address as cr_address, city as cr_city, `state` as cr_state, zip as cr_zip " +
            "from camper limit 1000; ";
        return jdbcTemplate.query(sql, new CamperMapper());
    }

    @Override
    public Camper findById(int camper_id) throws DataAccessException{      // ADMIN Privileges
        final String sql = "select camper_id, `username`, `password`, `role`, first_name, last_name, camping_method, phone as cr_phone, " +
                "email as cr_email, address as cr_address, city as cr_city, `state` as cr_state, zip as cr_zip " +
                "from camper " +
                "where camper_id = ? ;";
        Camper camper = jdbcTemplate.query(sql, new CamperMapper(), camper_id).stream()
                .findFirst().orElse(null);

        return camper;
    }

    @Override
    @Transactional
    public Camper add(Camper camper) throws DataAccessException{       // USER Privileges
        final String sql = "insert into camper (`username`, `password`, `role`, first_name, last_name, camping_method, " +
                "phone, email, address, city, `state`, zip) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?); ";

        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, camper.getUsername());
            ps.setString(2, camper.getPassword());
            ps.setString(3, String.valueOf(camper.getRole()));
            ps.setString(4, camper.getFirstName());
            ps.setString(5, camper.getLastName());
            ps.setString(6, camper.getCampingMethod());
            ps.setString(7, camper.getPhone());
            ps.setString(8, camper.getEmail());
            ps.setString(9, camper.getAddress());
            ps.setString(10, camper.getCity());
            ps.setString(11, camper.getState());
            ps.setString(12, camper.getZip());
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
                    + "username = ?, "
                    + "`password` = ?, "
                    + "`role` = ?, "
                    + "first_name = ?, "
                    + "last_name = ?, "
                    + "camping_method = ?, "
                    + "phone = ?, "
                    + "email = ?, "
                    + "address = ?, "
                    + "city = ?, "
                    + "`state` = ?, "
                    + "zip = ? "
                    + "where camper_id = ?; ";

            return jdbcTemplate.update(sql,
                    camper.getUsername(),
                    camper.getPassword(),
                    String.valueOf(camper.getRole()),
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
        reservationRepo.deleteByCamperId(camper_id);
        return jdbcTemplate.update("delete from camper where camper_id = ?", camper_id) > 0;
    }
}