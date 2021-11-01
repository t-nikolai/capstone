package files.cc.models;

import java.util.Objects;

public class Campsite {

    private int site_id;
    private String site_name;
    private Campground campground;

    public Campsite() {}

    public Campsite(int site_id, String site_name, Campground campground) {
        this.site_id = site_id;
        this.site_name = site_name;
        this.campground = campground;
    }

    public int getSite_id() {
        return site_id;
    }

    public void setSite_id(int site_id) {
        this.site_id = site_id;
    }

    public String getSite_name() {
        return site_name;
    }

    public void setSite_name(String site_name) {
        this.site_name = site_name;
    }

    public Campground getCampground() {
        return campground;
    }

    public void setCampground(Campground campground) {
        this.campground = campground;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campsite)) return false;
        Campsite campsite = (Campsite) o;
        return getSite_id() == campsite.getSite_id() && getSite_name().equals(campsite.getSite_name())
                && getCampground().equals(campsite.getCampground());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSite_id(), getSite_name(), getCampground());
    }
}
