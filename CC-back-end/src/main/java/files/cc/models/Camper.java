package files.cc.models;

import java.util.Objects;

public class Camper {
    private int camperId;
    private String firstName;
    private String lastName;
    private String campingMethod;      //TODO: ENUM??? -> 'public enum campingMethod { TENT, CAMPER, CABIN }'
    private String phone;
    private String email;
    private String address;
    private String city;
    private String state;
    private int zip;

    public Camper() { }

    public Camper(int camper_id, String first_name, String last_name, String camping_method, String camper_phone,
                  String camper_email, String camper_address, String camper_city, String camper_state, int camper_zip) {
        this.camperId = camper_id;
        this.firstName = first_name;
        this.lastName = last_name;
        this.campingMethod = camping_method;
        this.phone = camper_phone;
        this.email = camper_email;
        this.address = camper_address;
        this.city = camper_city;
        this.state = camper_state;
        this.zip = camper_zip;
    }

    public int getCamperId() {
        return camperId;
    }

    public void setCamperId(int camper_id) {
        this.camperId = camper_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String first_name) {
        this.firstName = first_name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String last_name) {
        this.lastName = last_name;
    }

    public String getCampingMethod() {
        return campingMethod;
    }

    public void setCamping_method(String camping_method) {
        this.campingMethod = camping_method;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String camper_phone) {
        this.phone = camper_phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String camper_email) {
        this.email = camper_email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String camper_address) {
        this.address = camper_address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String camper_city) {
        this.city = camper_city;
    }

    public String getState() {
        return state;
    }

    public void setState(String camper_state) {
        this.state = camper_state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int camper_zip) {
        this.zip = camper_zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camper)) return false;
        Camper camper = (Camper) o;
        return getCamperId() == camper.getCamperId() && getZip() == camper.getZip() &&
                getFirstName().equals(camper.getFirstName()) && getLastName().equals(camper.getLastName())
                && getCampingMethod().equals(camper.getCampingMethod()) && Objects.equals(getPhone(), camper.getPhone())
                && getEmail().equals(camper.getEmail()) && getAddress().equals(camper.getAddress())
                && getCity().equals(camper.getCity()) && getState().equals(camper.getState());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCamperId(), getFirstName(), getLastName(), getCampingMethod(), getPhone(),
                getEmail(), getAddress(), getCity(), getState(), getZip());
    }
}
