package org.grubhart;

import org.junit.Test;

import static org.junit.Assert.*;


public class ResourceServiceTest {

    @Test
    public void testSpecialFlagOddRowId(){
        ResourceService service = new ResourceService();
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(1);
        service.setSpecialFlag(row);
        assertEquals("Q",row.getSpecialFlag());
    }

}
