package org.grubhart;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateSearchResult;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class RealStateResultSearchTest {

    @Test
    public void testBuildSearchResult(){
        ArrayList<RealState> resultList = new ArrayList<>();
        RealState realState=new RealState();
        realState.setId(1);
        realState.setStreet_address("55 CYRIL MAGNIN ST");
        realState.setCity("San Francisco");
        realState.setState_abr("CA");
        realState.setState_name("California");

        resultList.add(realState);

        RealStateSearchResult searchResult = new RealStateSearchResult(resultList);

        assertEquals(1,searchResult.size());


    }
}
