package files.cc.models;

import java.util.Objects;

public class Campsite {

    private int siteId;
    private String name;
    private Campground campground;

    public Campsite() {}

    public Campsite(int site_id, String site_name, Campground campground) {
        this.siteId = site_id;
        this.name = site_name;
        this.campground = campground;
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        return getSiteId() == campsite.getSiteId() && getName().equals(campsite.getName())
                && getCampground().equals(campsite.getCampground());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSiteId(), getName(), getCampground());
    }
}
