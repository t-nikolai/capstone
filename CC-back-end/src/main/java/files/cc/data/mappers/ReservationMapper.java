package files.cc.data.mappers;

import files.cc.models.Campsite;
import files.cc.models.Reservation;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReservationMapper implements RowMapper<Reservation> {
    @Override
    public Reservation mapRow(ResultSet resultSet, int i) throws SQLException {
        Reservation reservation = new Reservation();

        reservation.setReservationId(resultSet.getInt("reservation_id"));
        reservation.setStartDate(resultSet.getDate("start_date").toLocalDate());
        reservation.setEndDate(resultSet.getDate("end_date").toLocalDate());

        CampsiteMapper campsiteMapper = new CampsiteMapper();
        reservation.setSite(campsiteMapper.mapRow(resultSet, i));

        CamperMapper camperMapper = new CamperMapper();
        reservation.setCamper(camperMapper.mapRow(resultSet, i));

        return reservation;
    }
}
