package org.grubhart;

public class ResourceService {

    public void setSpecialFlag(RealStateResultItem row) {
        if(isOdd(row.getRowId())){
            row.setSpecialFlag("Q");
        }
    }

    public boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
