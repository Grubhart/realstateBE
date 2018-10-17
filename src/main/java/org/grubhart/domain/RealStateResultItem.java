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
            this.address=realState.getAddress();
            if(realState.isSpecialOffer()){
                this.specialOffer="Yes";
            }else{
                this.specialOffer="No";
            }
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
}
