package files.cc.data.mappers;

import files.cc.models.Camper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CamperMapper implements RowMapper<Camper> {
    @Override
    public Camper mapRow(ResultSet resultSet, int i) throws SQLException {
        Camper camper = new Camper();
        camper.setCamper_id(resultSet.getInt("camper_id"));
        camper.setFirst_name(resultSet.getString("first_name"));
        camper.setLast_name(resultSet.getString("last_name"));
        camper.setCamper_address(resultSet.getString("address"));
        camper.setCamper_city(resultSet.getString("city"));
        camper.setCamper_state(resultSet.getString("state"));
        camper.setCamper_zip(resultSet.getInt("zip_code"));
        camper.setCamper_email(resultSet.getString("email"));
        camper.setCamper_phone(resultSet.getString("phone"));

        return camper;
    }
}
