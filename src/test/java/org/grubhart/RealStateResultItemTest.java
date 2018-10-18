package org.grubhart;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RealStateResultItemTest {

    @Test
    public void testRealStateBuilder(){
// 55 CYRIL MAGNIN ST PARC 55 SAN FRANCISCO, California, CA 94102-2812
        RealState realState=new RealState();
        realState.setId(1);
        realState.setStreet_address("55 CYRIL MAGNIN ST");
        realState.setCity("San Francisco");
        realState.setState_abr("CA");
        realState.setState_name("California");
        realState.setZip_code("23451");

        realState.setSpecial_offer(false);

        RealStateResultItem item = new RealStateResultItem(realState);

        assertEquals(1,item.getRealStateId());
        assertEquals("55 CYRIL MAGNIN ST, San Francisco, California, CA, 23451",item.getAddress());
        assertEquals("No",item.getSpecialOffer());


    }
}
