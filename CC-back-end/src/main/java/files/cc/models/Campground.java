package files.cc.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Campground {

    private int campground_id;
    private String campground_name;

    private String campground_address;
    private String campground_city;
    private String campground_state;
    private int campground_zip;

    private String campground_phone;
    private String campground_email;

    private int campground_capacity;

    private BigDecimal standard_rate;
    private BigDecimal weekend_rate;

    public Campground() {}

    public Campground(int campground_id, String campground_name, String campground_address, String campground_city,
                      String campground_state, int campground_zip, String campground_phone, String campground_email,
                      int campground_capacity, BigDecimal standard_rate, BigDecimal weekend_rate) {
        this.campground_id = campground_id;
        this.campground_name = campground_name;
        this.campground_address = campground_address;
        this.campground_city = campground_city;
        this.campground_state = campground_state;
        this.campground_zip = campground_zip;
        this.campground_phone = campground_phone;
        this.campground_email = campground_email;
        this.campground_capacity = campground_capacity;
        this.standard_rate = standard_rate;
        this.weekend_rate = weekend_rate;
    }

    public int getCampground_id() {
        return campground_id;
    }

    public void setCampground_id(int campground_id) {
        this.campground_id = campground_id;
    }

    public String getCampground_name() {
        return campground_name;
    }

    public void setCampground_name(String campground_name) {
        this.campground_name = campground_name;
    }

    public String getCampground_address() {
        return campground_address;
    }

    public void setCampground_address(String campground_address) {
        this.campground_address = campground_address;
    }

    public String getCampground_city() {
        return campground_city;
    }

    public void setCampground_city(String campground_city) {
        this.campground_city = campground_city;
    }

    public String getCampground_state() {
        return campground_state;
    }

    public void setCampground_state(String campground_state) {
        this.campground_state = campground_state;
    }

    public int getCampground_zip() {
        return campground_zip;
    }

    public void setCampground_zip(int campground_zip) {
        this.campground_zip = campground_zip;
    }

    public String getCampground_phone() {
        return campground_phone;
    }

    public void setCampground_phone(String campground_phone) {
        this.campground_phone = campground_phone;
    }

    public String getCampground_email() {
        return campground_email;
    }

    public void setCampground_email(String campground_email) {
        this.campground_email = campground_email;
    }

    public int getCampground_capacity() {
        return campground_capacity;
    }

    public void setCampground_capacity(int campground_capacity) {
        this.campground_capacity = campground_capacity;
    }

    public BigDecimal getStandard_rate() {
        return standard_rate;
    }

    public void setStandard_rate(BigDecimal standard_rate) {
        this.standard_rate = standard_rate;
    }

    public BigDecimal getWeekend_rate() {
        return weekend_rate;
    }

    public void setWeekend_rate(BigDecimal weekend_rate) {
        this.weekend_rate = weekend_rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campground)) return false;
        Campground that = (Campground) o;
        return getCampground_id() == that.getCampground_id() && getCampground_zip() == that.getCampground_zip() &&
                getCampground_capacity() == that.getCampground_capacity() && getCampground_name().equals(that.getCampground_name())
                && getCampground_address().equals(that.getCampground_address()) && getCampground_city().equals(that.getCampground_city())
                && getCampground_state().equals(that.getCampground_state()) && getCampground_phone().equals(that.getCampground_phone())
                && getCampground_email().equals(that.getCampground_email()) && getStandard_rate().equals(that.getStandard_rate())
                && getWeekend_rate().equals(that.getWeekend_rate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCampground_id(), getCampground_name(), getCampground_address(), getCampground_city(), getCampground_state(),
                getCampground_zip(), getCampground_phone(), getCampground_email(), getCampground_capacity(), getStandard_rate(), getWeekend_rate());
    }
}
