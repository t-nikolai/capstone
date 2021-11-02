package files.cc.data;

import files.cc.data.mappers.CamperMapper;
import files.cc.models.Camper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CamperJdbcTemplateRepository {
    private final JdbcTemplate jdbcTemplate;

    public CamperJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {this.jdbcTemplate = jdbcTemplate;}

    public List<Camper> findAll() {
        final String sql = "select camper_id, first_name, last_name, camping_method, camper_phone, camper_email, " +
            "camper_address, camper_city, camper_state, camper_zip " +
            "from camper limit 1000; ";
        return jdbcTemplate.query(sql, new CamperMapper());
    }

    public Camper findById(int camper_id){
        final String sql = "select camper_id, first_name, last_name, camping_method, camper_phone, " +
                "camper_email, camper_address, camper_city, camper_state, camper_zip " +
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

}