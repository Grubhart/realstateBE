package org.grubhart;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.service.ResourceService;
import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void testBuildSearchResult(){
            ResourceService service = new ResourceService();
            ArrayList<RealState> resultList = new ArrayList<>();
            RealState realState=new RealState();
            realState.setId(1);
            realState.setStreetAddress("55 CYRIL MAGNIN ST");
            realState.setCity("San Francisco");
            realState.setStateAbr("CA");
            realState.setStateName("California");

            resultList.add(realState);

            RealStateSearchResult searchResult = service.buildRealStateSearchResult(resultList);

            assertEquals(1,searchResult.size());
            assertEquals((Integer)1,searchResult.getList().get(0).getRowId());
            assertEquals("Q",searchResult.getList().get(0).getSpecialFlag());



        }
    }


