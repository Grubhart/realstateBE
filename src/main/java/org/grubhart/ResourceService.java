package org.grubhart;

public class ResourceService {

    public void setSpecialFlag(RealStateResultItem row) {
        if(isOdd(row.getRowId()) && !isMultiple3(row.getRowId())){
            row.setSpecialFlag("Q");
        }
        if(isMultiple3(row.getRowId())){
            row.setSpecialFlag("G");
        }
    }

    private boolean isMultiple3(Integer rowId) {
        return rowId % 3 == 0;  //rowId never is 0
    }

    public boolean isOdd(int i) {
        return i % 2 == 1;
    }
}
