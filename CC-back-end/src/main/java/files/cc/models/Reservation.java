package files.cc.models;

import java.sql.Date;
import java.util.Objects;

public class Reservation {
    private int reservationId;
    private Date startDate;
    private Date endDate;
    private Campsite site;
    private Camper camper;

    public Reservation() { }

    public Reservation(int reservation_id, Date start_date, Date end_date, Campsite site, Camper camper) {
        this.reservationId = reservation_id;
        this.startDate = start_date;
        this.endDate = end_date;
        this.site = site;
        this.camper = camper;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Campsite getSite() {
        return site;
    }

    public void setSite(Campsite site) {
        this.site = site;
    }

    public Camper getCamper() {
        return camper;
    }

    public void setCamper(Camper camper) {
        this.camper = camper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getReservationId() == that.getReservationId() && getStartDate().equals(that.getStartDate())
                && getEndDate().equals(that.getEndDate()) && getSite().equals(that.getSite()) && getCamper().equals(that.getCamper());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservationId(), getStartDate(), getEndDate(), getSite(), getCamper());
    }
}
