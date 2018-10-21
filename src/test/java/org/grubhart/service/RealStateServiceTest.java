package org.grubhart.service;

import org.grubhart.repository.RealStateRepository;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

@RunWith(MockitoJUnitRunner.class)
public class RealStateServiceTest {

    @Mock
    private RealStateRepository repository;

    @InjectMocks
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

    @Test
    public void testSearchArraySpecialOffer(){

        ArrayList<RealState> resultList = getRealStates(true);
        when(repository.findSpecialOffer(anyString())).thenReturn(resultList);

        RealStateResultItem item = new RealStateResultItem(resultList.get(0));
        item.setRowId(1);
        item.setSpecialFlag("Q");

        RealStateResultItem[] array = service.searchArray("55","true");
        assertEquals(item,array[0]);

    }
}


