package org.grubhart;

import org.grubhart.domain.RealStateResultItem;
import org.grubhart.service.ResourceService;
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

    @Test
    public void testSpecialFlagRowIdOddAndDivisibleBy3(){
        ResourceService service = new ResourceService();
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(3);
        service.setSpecialFlag(row);
        assertEquals("G",row.getSpecialFlag());
    }

    @Test
    public void testSpecialFlagRowIdEvenAndDivisibleBy3(){
        ResourceService service = new ResourceService();
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(6);
        service.setSpecialFlag(row);
        assertEquals("G",row.getSpecialFlag());
    }

    @Test
    public void testSpecialFlagRowIdNotOddNeitherDivisibleBy3(){
        ResourceService service = new ResourceService();
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(4);
        service.setSpecialFlag(row);
        assertEquals("X",row.getSpecialFlag());
    }

}
