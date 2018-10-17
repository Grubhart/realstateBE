package org.grubhart.domain;

public class RealState {

    private int id;
    private String address;
    private boolean specialOffer;


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
}
