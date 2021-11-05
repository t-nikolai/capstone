package files.cc.models;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation {
    private int reservationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private Campsite site;
    private Camper camper;
    private BigDecimal total;

    public Reservation() { }

    public Reservation(int reservation_id, LocalDate start_date, LocalDate end_date, BigDecimal total, Campsite site, Camper camper) {
        this.reservationId = reservation_id;
        this.startDate = start_date;
        this.endDate = end_date;
        this.total = total;
        this.site = site;
        this.camper = camper;
    }

    public int getReservationId() {
        return reservationId;
    }

    public void setReservationId(int reservationId) {
        this.reservationId = reservationId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
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

    public BigDecimal getTotal() {   return total;   }

    public void setTotal(BigDecimal total) {   this.total = total;   }

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
