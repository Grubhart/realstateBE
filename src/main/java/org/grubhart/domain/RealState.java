package org.grubhart.domain;

public class RealState {

    private int id;
    private String address;
    private boolean specialOffer;
    private String city;
    private String estadoAbr;
    private String state;
    private String zipCode;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id=id;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public void setSpecialOffer(boolean specialOffer) {
        this.specialOffer=specialOffer;
    }


    public String getAddress() {
        return address;
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

    public void setEstadoAbr(String estadoAbr) {
        this.estadoAbr = estadoAbr;
    }

    public String getEstadoAbr() {
        return estadoAbr;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getZipCode() {
        return zipCode;
    }
}
