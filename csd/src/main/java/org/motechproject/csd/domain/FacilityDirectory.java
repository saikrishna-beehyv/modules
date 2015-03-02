package org.motechproject.csd.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import javax.jdo.annotations.Order;
import java.util.List;

@Entity
public class FacilityDirectory {

    @Order(column = "service_directory_services_idx")
    @Field(name = "facility_directory_facilities")
    private List<Facility> facilities;

    public FacilityDirectory() {
    }

    public FacilityDirectory(List<Facility> facilities) {
        this.facilities = facilities;
    }

    public List<Facility> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<Facility> facilities) {
        this.facilities = facilities;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        FacilityDirectory that = (FacilityDirectory) o;

        if (facilities != null ? !facilities.equals(that.facilities) : that.facilities != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return facilities != null ? facilities.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "FacilityDirectory{" +
                "facilities=" + facilities +
                '}';
    }
}