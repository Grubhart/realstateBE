package org.grubhart.domain;

public class RealStateResultItem {

    public String specialOffer;
    private Integer rowId;
    private String specialFlag;
    private String address;
    private int realStateId;

    public RealStateResultItem(){}

    public RealStateResultItem(RealState realState) {
            this.realStateId=realState.getId();
            this.address=buildAdress(realState);
            if(realState.isSpecialOffer()){
                this.specialOffer="Yes";
            }else{
                this.specialOffer="No";
            }
    }

    private String buildAdress(RealState realState) {
        StringBuffer address= new StringBuffer();
        address.append(realState.getStreetAddress())
                .append(", ")
                .append(realState.getCity())
                .append(", ")
                .append(realState.getStateName())
                .append(", ")
                .append(realState.getStateAbr())
                .append(", ")
                .append(realState.getZipCode());

        return address.toString();
    }

    public void setRowId(int rowId) {
        this.rowId=rowId;
    }

    public String getSpecialFlag() {

        return specialFlag;
    }

    public Integer getRowId() {
        return rowId;
    }

    public void setSpecialFlag(String specialFlag) {
        this.specialFlag=specialFlag;
    }

    public int getRealStateId() {
        return realStateId;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialOffer() {
        return specialOffer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RealStateResultItem)) return false;

        RealStateResultItem that = (RealStateResultItem) o;

        if (getRealStateId() != that.getRealStateId()) return false;
        if (!getSpecialOffer().equals(that.getSpecialOffer())) return false;
        if (!getRowId().equals(that.getRowId())) return false;
        if (!getSpecialFlag().equals(that.getSpecialFlag())) return false;
        return getAddress().equals(that.getAddress());
    }

    @Override
    public int hashCode() {
        int result = getSpecialOffer().hashCode();
        result = 31 * result + getRowId().hashCode();
        result = 31 * result + getSpecialFlag().hashCode();
        result = 31 * result + getAddress().hashCode();
        result = 31 * result + getRealStateId();
        return result;
    }

    @Override
    public String toString() {
        return "RealStateResultItem{" +
                "specialOffer='" + specialOffer + '\'' +
                ", rowId=" + rowId +
                ", specialFlag='" + specialFlag + '\'' +
                ", address='" + address + '\'' +
                ", realStateId=" + realStateId +
                '}';
    }
}
