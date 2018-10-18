package org.grubhart.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity(name = "HOME")
public class RealState {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String streetAddress;
    private boolean specialOffer;
    private String city;
    private String stateAbr;
    private String stateName;
    private String zipCode;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public void setStreetAddress(String street_address) {
        this.streetAddress = street_address;
    }
    public String getStreetAddress() {
        return streetAddress;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer = specialOffer;
    }
    public boolean isSpecialOffer() {
        return specialOffer;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public String getCity() {
        return city;
    }

    public void setStateAbr(String stateAbr) {
        this.stateAbr = stateAbr;
    }
    public String getStateAbr() {
        return stateAbr;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateName() {
        return stateName;
    }

    public void setZipCode(String zip_code) {
        this.zipCode = zip_code;
    }
    public String getZipCode() {
        return zipCode;
    }
}
