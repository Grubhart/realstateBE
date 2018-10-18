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

    private String street_address;
    private boolean special_offer;
    private String city;
    private String state_abr;
    private String state_name;
    private String zip_code;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public void setStreet_address(String street_address) {
        this.street_address = street_address;
    }

    public void setSpecial_offer(boolean special_offer) {
        this.special_offer = special_offer;
    }


    public String getStreet_address() {
        return street_address;
    }

    public boolean isSpecial_offer() {
        return special_offer;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setState_abr(String state_abr) {
        this.state_abr = state_abr;
    }

    public String getState_abr() {
        return state_abr;
    }

    public void setState_name(String state_name) {
        this.state_name = state_name;
    }

    public String getState_name() {
        return state_name;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public String getZip_code() {
        return zip_code;
    }
}
