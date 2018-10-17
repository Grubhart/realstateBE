package org.grubhart;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealStateResultItemTest {

    @Test
    public void testRealStateBuilder(){

        RealState realState=new RealState();
        realState.setId(1);
        realState.setAddress("55 CYRIL MAGNIN ST");
        realState.setSpecialOffer(false);

        RealStateResultItem item = new RealStateResultItem(realState);

        assertEquals(1,item.getRealStateId());
        assertEquals("55 CYRIL MAGNIN ST",item.getAddress());
        assertEquals("No",item.getSpecialOffer());


    }
}
