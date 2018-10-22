package org.grubhart.util;

import java.util.ArrayList;

public class CriteriaRequest {

    public static final String STATE_NAME = "stateName";
    public static final String STATE_ABR = "stateAbr";
    public static final String STREET_ADDRESS = "streetAddress";
    public static final String CITY = "city";
    public static final String ZIP_CODE = "zipCode";

    private String likeField;
    private ArrayList<String> stateAbr;
    private ArrayList<String> stateNames;
    private ArrayList<String> streetAddress;
    private ArrayList<String> city;
    private ArrayList<String> zipCode;

    private ArrayList<String> genericFields;

    public CriteriaRequest() {
        genericFields=new ArrayList<>();
        city=new ArrayList<>();
        stateAbr=new ArrayList<>();
        stateNames=new ArrayList<>();
        streetAddress=new ArrayList<>();
        zipCode=new ArrayList<>();
        genericFields.add(STATE_NAME);
        genericFields.add(STATE_ABR);
        genericFields.add(STREET_ADDRESS);
        genericFields.add(CITY);
        genericFields.add(ZIP_CODE);

    }

    public String getLikeField() {
        return likeField;
    }

    public void setLikeField(String likeField) {
        this.likeField = likeField;
    }

    public ArrayList<String> getStateAbr() {
        return stateAbr;
    }

    public void setStateAbr(ArrayList<String> stateAbr) {
        this.stateAbr = stateAbr;
    }

    public ArrayList<String> getGenericFields() {
        return genericFields;
    }

    public void setGenericFields(ArrayList<String> genericFields) {
        this.genericFields = genericFields;
    }

    public ArrayList<String> getCity() {
        return city;
    }

    public void setCity(ArrayList<String> city) {
        this.city = city;
    }

    public ArrayList<String> getStateNames() {
        return stateNames;
    }

    public void setStateNames(ArrayList<String> stateNames) {
        this.stateNames = stateNames;
    }

    public ArrayList<String> getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(ArrayList<String> streetAddress) {
        this.streetAddress = streetAddress;
    }

    public ArrayList<String> getZipCode() {
        return zipCode;
    }

    public void setZipCode(ArrayList<String> zipCode) {
        this.zipCode = zipCode;
    }
}
