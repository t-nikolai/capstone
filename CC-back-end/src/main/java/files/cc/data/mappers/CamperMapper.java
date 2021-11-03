package files.cc.data.mappers;

import files.cc.models.Camper;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class CamperMapper implements RowMapper<Camper> {
    @Override
    public Camper mapRow(ResultSet resultSet, int i) throws SQLException {
        Camper camper = new Camper();
        camper.setCamperId(resultSet.getInt("camper_id"));
        camper.setFirstName(resultSet.getString("first_name"));
        camper.setLastName(resultSet.getString("last_name"));
        camper.setPhone(resultSet.getString("phone"));
        camper.setEmail(resultSet.getString("email"));
        camper.setAddress(resultSet.getString("address"));
        camper.setCity(resultSet.getString("city"));
        camper.setState(resultSet.getString("state"));
        camper.setZip(resultSet.getInt("zip"));

        return camper;
    }
}
