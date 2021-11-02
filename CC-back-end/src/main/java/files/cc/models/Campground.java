package files.cc.models;

import java.math.BigDecimal;
import java.util.Objects;

public class Campground {

    private int campground_id;
    private String name;

    private String address;
    private String city;
    private String state;
    private int zip;

    private String phone;
    private String email;

    private int capacity;

    private BigDecimal standard_rate;
    private BigDecimal weekend_rate;

    public Campground() {}

    public Campground(int campground_id, String campground_name, String campground_address, String campground_city,
                      String campground_state, int campground_zip, String campground_phone, String campground_email,
                      int campground_capacity, BigDecimal standard_rate, BigDecimal weekend_rate) {
        this.campground_id = campground_id;
        this.name = campground_name;
        this.address = campground_address;
        this.city = campground_city;
        this.state = campground_state;
        this.zip = campground_zip;
        this.phone = campground_phone;
        this.email = campground_email;
        this.capacity = campground_capacity;
        this.standard_rate = standard_rate;
        this.weekend_rate = weekend_rate;
    }

    public int getCampground_id() {
        return campground_id;
    }

    public void setCampground_id(int campground_id) {
        this.campground_id = campground_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String campground_name) {
        this.name = campground_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String campground_address) {
        this.address = campground_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String campground_city) {
        this.city = campground_city;
    }

    public String getState() {
        return state;
    }

    public void setState(String campground_state) {
        this.state = campground_state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int campground_zip) {
        this.zip = campground_zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String campground_phone) {
        this.phone = campground_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String campground_email) {
        this.email = campground_email;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int campground_capacity) {
        this.capacity = campground_capacity;
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
        return getCampground_id() == that.getCampground_id() && getZip() == that.getZip() &&
                getCapacity() == that.getCapacity() && getName().equals(that.getName())
                && getAddress().equals(that.getAddress()) && getCity().equals(that.getCity())
                && getState().equals(that.getState()) && getPhone().equals(that.getPhone())
                && getEmail().equals(that.getEmail()) && getStandard_rate().equals(that.getStandard_rate())
                && getWeekend_rate().equals(that.getWeekend_rate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCampground_id(), getName(), getAddress(), getCity(), getState(),
                getZip(), getPhone(), getEmail(), getCapacity(), getStandard_rate(), getWeekend_rate());
    }
}
