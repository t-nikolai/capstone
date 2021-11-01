package files.cc.models;

import java.sql.Date;
import java.util.Objects;

public class Reservation {
    private int reservation_id;
    private Date start_date;
    private Date end_date;
    private Campsite site;
    private Camper camper;

    public Reservation() { }

    public Reservation(int reservation_id, Date start_date, Date end_date, Campsite site, Camper camper) {
        this.reservation_id = reservation_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.site = site;
        this.camper = camper;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
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
        return getReservation_id() == that.getReservation_id() && getStart_date().equals(that.getStart_date())
                && getEnd_date().equals(that.getEnd_date()) && getSite().equals(that.getSite()) && getCamper().equals(that.getCamper());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getReservation_id(), getStart_date(), getEnd_date(), getSite(), getCamper());
    }
}
