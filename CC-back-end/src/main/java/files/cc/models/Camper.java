package files.cc.models;

public class Camper {
    private int camper_id;
    private String first_name;
    private String last_name;
    private String camping_method;
    private String camper_phone;
    private String camper_email;
    private String camper_address;
    private String camper_city;
    private String camper_state;
    private int camper_zip;

    public Camper(){

    }

    public Camper(int camper_id, String first_name, String last_name, String camping_method, String camper_phone, String camper_email,
                  String camper_address, String camper_city, String camper_state, int camper_zip){
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

    public int getCamperId(){

    }
}
