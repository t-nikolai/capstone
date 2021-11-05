package files.cc.data.mappers;

import files.cc.models.Camper;

import java.sql.ResultSet;
import java.sql.SQLException;

import files.cc.models.Role;
import org.springframework.jdbc.core.RowMapper;

public class CamperMapper implements RowMapper<Camper> {
    @Override
    public Camper mapRow(ResultSet resultSet, int i) throws SQLException {
        Camper camper = new Camper();
        camper.setCamperId(resultSet.getInt("camper_id"));
        camper.setUsername(resultSet.getString("username"));
        camper.setPassword(resultSet.getString("password"));
        camper.setRole(Role.valueOf(resultSet.getString("role")));
        camper.setFirstName(resultSet.getString("first_name"));
        camper.setLastName(resultSet.getString("last_name"));
        camper.setCampingMethod(resultSet.getString("camping_method"));
        camper.setPhone(resultSet.getString("cr_phone"));
        camper.setEmail(resultSet.getString("cr_email"));
        camper.setAddress(resultSet.getString("cr_address"));
        camper.setCity(resultSet.getString("cr_city"));
        camper.setState(resultSet.getString("cr_state"));
        camper.setZip(resultSet.getInt("cr_zip"));

        return camper;
    }
}
