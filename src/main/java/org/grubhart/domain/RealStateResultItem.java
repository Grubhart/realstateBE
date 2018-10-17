package org.grubhart.domain;

public class RealStateResultItem {

    private Integer rowId;
    private String specialFlag;

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
}
