package files.cc.models;

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

    private double standard_rate;
    private double weekend_rate;

    public Campground(int campground_id, String campground_name, String campground_address, String campground_city,
                      String campground_state, int campground_zip, String campground_phone, String campground_email,
                      int campground_capacity, double standard_rate, double weekend_rate) { }
    public Campground() {
    }
}
