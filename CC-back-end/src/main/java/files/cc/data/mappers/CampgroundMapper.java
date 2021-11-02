package files.cc.data.mappers;

import files.cc.models.Camper;
import files.cc.models.Campground;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CampgroundMapper implements RowMapper<Campground> {

    @Override
    public Campground mapRow(ResultSet resultSet, int i) throws SQLException {
        Campground campground = new Campground();
        campground.setCampgroundId(resultSet.getInt("campground_id"));
        campground.setName(resultSet.getString("name"));
        campground.setAddress(resultSet.getString("address"));
        campground.setCity(resultSet.getString("city"));
        campground.setState(resultSet.getString("state"));
        campground.setZip(resultSet.getInt("zip"));
        campground.setPhone(resultSet.getString("phone"));
        campground.setEmail(resultSet.getString("email"));
        campground.setStandardRate(resultSet.getBigDecimal("standard_rate"));
        campground.setWeekendRate(resultSet.getBigDecimal("weekend_rate"));

        return campground;
    }

}
