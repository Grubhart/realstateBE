package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.grubhart.repository.RealStatesSpecs.*;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RealStateRepositoryJPAIntegrationTest {

    @Autowired
    private RealStateRepositoryJPA repository;

    @Test
    public void testqueryByCriteriaInStates(){

        ArrayList<String> states = new ArrayList<>();
        states.add("FLORIDA");
        states.add("NEW YORK");

        List all = repository.findAll(RealStatesSpecs.inStateNames(states));

        assertEquals(4,all.size());

    }

    @Test
    public void testqueryByCriteriaLikeStates(){

        ArrayList<String> states = new ArrayList<>();
        states.add("FLORIDA");
        states.add("NEW YORK");

        List all = repository.findAll(RealStatesSpecs.likeStateName("%ori%"));
        assertEquals(3,all.size());

    }

    @Test
    public void testqueryByCriteriaLikeStatesAbr(){

        List<RealState> all = repository.findAll(RealStatesSpecs.likeStateAbr("N"));
        assertEquals(1,all.size());
        assertEquals("NY",all.get(0).getStateAbr());
    }

    @Test
    public void testqueryByCriteriaEqualStatesAbr(){

        ArrayList<String> states = new ArrayList<>();
        states.add("Fl");
        states.add("nY");

        List all = repository.findAll(RealStatesSpecs.inStateAbr(states));

        assertEquals(4,all.size());

    }

    @Test
    public void testqueryByCriteriaLikeSteetAddress(){

        String streetAddress ="55";
        List<RealState> all = repository.findAll(RealStatesSpecs.likeStreetAddress(streetAddress));
        assertEquals(4,all.size());

    }

    @Test
    public void testqueryByCriteriaLikeCity(){

        List<RealState> all = repository.findAll(likeCity("aN fR"));
        assertEquals(1,all.size());
        assertEquals("CA",all.get(0).getStateAbr());

    }

    @Test
    public void testqueryByCriteriaInCities(){

        ArrayList<String> cities = new ArrayList<>();
        cities.add("NeW YORK");
        cities.add("miAmI");

        List all = repository.findAll(RealStatesSpecs.inCities(cities));

        assertEquals(3,all.size());

    }

    @Test
    public void testqueryByCriteriaLikeZipCode(){

        List<RealState> all = repository.findAll(RealStatesSpecs.likeZipCode("  55"));
        assertEquals(5,all.size());

    }

    @Test
    public void testqueryByCriteriaInZipCodes(){

        ArrayList<String> zipCodes = new ArrayList<>();
        zipCodes.add("553235");
        zipCodes.add("555555");

        List all = repository.findAll(RealStatesSpecs.inZipCodes(zipCodes));

        assertEquals(3,all.size());

    }

    @Test
    public void testqueryByCriteriaIsSpecialOffer(){
        List all = repository.findAll(RealStatesSpecs.isSpecialOffer(true));
        assertEquals(3,all.size());
    }

}
