package files.cc.models;

import java.util.Objects;

public class Camper {
    private int camper_id;
    private String first_name;
    private String last_name;
    private String camping_method;      //TODO: ENUM??? -> 'public enum campingMethod { TENT, CAMPER, CABIN }'
    private String camper_phone;
    private String camper_email;
    private String camper_address;
    private String camper_city;
    private String camper_state;
    private int camper_zip;

    public Camper() { }

    public Camper(int camper_id, String first_name, String last_name, String camping_method, String camper_phone,
                  String camper_email, String camper_address, String camper_city, String camper_state, int camper_zip) {
        this.camper_id = camper_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.camping_method = camping_method;
        this.camper_phone = camper_phone;
        this.camper_email = camper_email;
        this.camper_address = camper_address;
        this.camper_city = camper_city;
        this.camper_state = camper_state;
        this.camper_zip = camper_zip;
    }

    public int getCamper_id() {
        return camper_id;
    }

    public void setCamper_id(int camper_id) {
        this.camper_id = camper_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getCamping_method() {
        return camping_method;
    }

    public void setCamping_method(String camping_method) {
        this.camping_method = camping_method;
    }

    public String getCamper_phone() {
        return camper_phone;
    }

    public void setCamper_phone(String camper_phone) {
        this.camper_phone = camper_phone;
    }

    public String getCamper_email() {
        return camper_email;
    }

    public void setCamper_email(String camper_email) {
        this.camper_email = camper_email;
    }

    public String getCamper_address() {
        return camper_address;
    }

    public void setCamper_address(String camper_address) {
        this.camper_address = camper_address;
    }

    public String getCamper_city() {
        return camper_city;
    }

    public void setCamper_city(String camper_city) {
        this.camper_city = camper_city;
    }

    public String getCamper_state() {
        return camper_state;
    }

    public void setCamper_state(String camper_state) {
        this.camper_state = camper_state;
    }

    public int getCamper_zip() {
        return camper_zip;
    }

    public void setCamper_zip(int camper_zip) {
        this.camper_zip = camper_zip;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Camper)) return false;
        Camper camper = (Camper) o;
        return getCamper_id() == camper.getCamper_id() && getCamper_zip() == camper.getCamper_zip() &&
                getFirst_name().equals(camper.getFirst_name()) && getLast_name().equals(camper.getLast_name())
                && getCamping_method().equals(camper.getCamping_method()) && Objects.equals(getCamper_phone(), camper.getCamper_phone())
                && getCamper_email().equals(camper.getCamper_email()) && getCamper_address().equals(camper.getCamper_address())
                && getCamper_city().equals(camper.getCamper_city()) && getCamper_state().equals(camper.getCamper_state());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCamper_id(), getFirst_name(), getLast_name(), getCamping_method(), getCamper_phone(),
                getCamper_email(), getCamper_address(), getCamper_city(), getCamper_state(), getCamper_zip());
    }
}
