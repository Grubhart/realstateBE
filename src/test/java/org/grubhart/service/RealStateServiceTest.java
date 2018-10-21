package org.grubhart.service;

import org.junit.Test;
import static org.junit.Assert.*;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class RealStateServiceTest {

    private RealStateService service;

    public RealStateServiceTest() {
        this.service = new RealStateService();
        MockitoAnnotations.initMocks(RealStateServiceTest.class);
    }

    @Test
    public void testSpecialFlagOddRowId(){
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(1);
        service.setSpecialFlag(row);
        assertEquals("Q",row.getSpecialFlag());
    }

    @Test
    public void testSpecialFlagRowIdOddAndDivisibleBy3(){
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(3);
        service.setSpecialFlag(row);
        assertEquals("G",row.getSpecialFlag());
    }

    @Test
    public void testSpecialFlagRowIdEvenAndDivisibleBy3(){
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(6);
        service.setSpecialFlag(row);
        assertEquals("G",row.getSpecialFlag());
    }

    @Test
    public void testSpecialFlagRowIdNotOddNeitherDivisibleBy3(){
        RealStateResultItem row= new RealStateResultItem();
        row.setRowId(4);
        service.setSpecialFlag(row);
        assertEquals("X",row.getSpecialFlag());
    }

    @Test
    public void testBuildSearchResult(){

        ArrayList<RealState> resultList = getRealStates(false);

        RealStateSearchResult searchResult = service.buildRealStateSearchResult(resultList);

        assertEquals(1,searchResult.size());
        assertEquals((Integer)1,searchResult.getList().get(0).getRowId());
        assertEquals("Q",searchResult.getList().get(0).getSpecialFlag());

    }

    @Test
    public void parseResultTest(){
        RealStateSearchResult result = service.buildRealStateSearchResult(getRealStates(true));

        RealStateResultItem[] realStateResultItems = service.parseResultToArray(result);

        RealStateResultItem[] array = new RealStateResultItem[1];
        RealStateResultItem item = new RealStateResultItem(getRealStates(true).get(0));
        item.setRowId(1);
        item.setSpecialFlag("Q");
        array[0]=item;

        assertEquals(array[0],realStateResultItems[0]);

    }

    private ArrayList<RealState> getRealStates(boolean specialOffer) {
        ArrayList<RealState> resultList = new ArrayList<>();
        RealState realState=new RealState();
        realState.setId(1);
        realState.setStreetAddress("55 CYRIL MAGNIN ST");
        realState.setCity("San Francisco");
        realState.setStateAbr("CA");
        realState.setStateName("California");
        realState.setZipCode("55555");
        realState.setSpecialOffer(specialOffer);
        resultList.add(realState);
        return resultList;
    }

}


