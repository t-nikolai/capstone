package files.cc.data;

import files.cc.data.mappers.ReservationMapper;
import files.cc.models.Reservation;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ReservationJdbcTemplateRepository implements ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    public ReservationJdbcTemplateRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Reservation> findAll() throws DataAccessException {
        final String sql = "select r.reservation_id as reservation_id, r.start_date as start_date, r.end_date as end_date, r.total as total " +
                "cs.site_id as site_id, cs.`name` as cs_name, cs.campground_id as cs_cg_id, " +
                "cr.camper_id as camper_id, cr.first_name as first_name, cr.last_name as last_name, cr.camping_method as camping_method, cr.phone as cr_phone, cr.email as cr_email, cr.address as cr_address, cr.city as cr_city, cr.`state` as cr_state, cr.zip as cr_zip " +
                "from reservation r " +
                "inner join campsite cs on r.site_id = cs.site_id " +
                "inner join camper cr on r.camper_id = cr.camper_id;";
        return jdbcTemplate.query(sql, new ReservationMapper());
    }

    @Override
    public Reservation findById(int reservationId) throws DataAccessException{
        final String sql = "select r.reservation_id as reservation_id, r.start_date as start_date, r.end_date as end_date, r.total as total " +
                "cs.site_id as site_id, cs.`name` as cs_name, cs.campground_id as cs_cg_id, " +
                "cr.camper_id as camper_id, cr.first_name as first_name, cr.last_name as last_name, cr.camping_method as camping_method, cr.phone as cr_phone, cr.email as cr_email, cr.address as cr_address, cr.city as cr_city, cr.`state` as cr_state, cr.zip as cr_zip " +
                "from reservation r " +
                "inner join campsite cs on r.site_id = cs.site_id " +
                "inner join camper cr on r.camper_id = cr.camper_id " +
                "where reservation_id = ?;";
        return jdbcTemplate.query(sql, new ReservationMapper(), reservationId).stream().findFirst().orElse(null);
    }

    @Override
    public List<Reservation> findByCampsiteId(int siteId){
        return findAll().stream().filter(i -> i.getSite().getSiteId() == siteId).collect(Collectors.toList());
    }

    @Override
    public List<Reservation> findByCampgroundId(int campgroundId){
        return findAll().stream().filter(i -> i.getSite().getCampgroundId() == campgroundId).collect(Collectors.toList());
    }

    @Override
    public Reservation add(Reservation reservation) throws DataAccessException{
        final String sql = "insert into reservation (start_date, end_date, total, site_id, camper_id) " +
                "values(?,?,?,?,?);";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        int rowsAffected = jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDate(1, Date.valueOf(reservation.getStartDate()));
            ps.setDate(2, Date.valueOf(reservation.getEndDate()));
            ps.setDouble(3, reservation.getTotal().doubleValue());
            ps.setInt(4, reservation.getSite().getSiteId());
            ps.setInt(5, reservation.getCamper().getCamperId());
            return ps;
        }, keyHolder);

        if (rowsAffected <= 0) {
            return null;
        }

        reservation.setReservationId(keyHolder.getKey().intValue());
        return reservation;
    }

    @Override
    public boolean update(Reservation reservation) throws DataAccessException{
        final String sql = "update reservation set " +
                "start_date = ?, " +
                "end_date = ?, " +
                "total = ?, " +
                "site_id = ?, " +
                "camper_id = ? " +
                "where reservation_id = ?; ";
        return jdbcTemplate.update(sql,
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getTotal().doubleValue(),
                reservation.getSite().getSiteId(),
                reservation.getCamper().getCamperId(),
                reservation.getReservationId()) > 0;
    }

    @Override
    public boolean deleteById(int reservationId) throws DataAccessException{
        return jdbcTemplate.update("delete from reservation where reservation_id = ?; ", reservationId) > 0;
    }

    @Override
    public boolean deleteByCamperId(int camperId) throws DataAccessException{
        return jdbcTemplate.update("delete from reservation where camper_id = ?; ", camperId) > 0;
    }
}
