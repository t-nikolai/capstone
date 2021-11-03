package files.cc.data.mappers;

import files.cc.models.Campground;
import files.cc.models.Campsite;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CampsiteMapper implements RowMapper<Campsite> {
    @Override
    public Campsite mapRow(ResultSet resultSet, int i) throws SQLException {
        Campsite campsite = new Campsite();
        campsite.setSiteId(resultSet.getInt("site_id"));
        campsite.setName(resultSet.getString("name"));

        CampgroundMapper campgroundMapper = new CampgroundMapper();
        campsite.setCampground(campgroundMapper.mapRow(resultSet, i));

        return campsite;
    }
}
