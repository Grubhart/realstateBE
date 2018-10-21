package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RealStateRepositoryIntegrationTest {

    @Autowired
    private RealStateRepository repository;

    @Test
    public void testSelect(){

        assertEquals(1,repository.findSpecialOffer("55").size());

    }

    @Test
    public void testqueryByCriteriaLikeStates(){

        ArrayList<String> states = new ArrayList<>();
        states.add("FLORIDA");
        states.add("NEW YORK");

        List all = repository.findAll(RealStatesSpecs.inStates(states));

        assertEquals(2,all.size());

    }

    @Test
    public void testqueryByCriteriaEqualStates(){

        ArrayList<String> states = new ArrayList<>();
        states.add("FLORIDA");
        states.add("NEW YORK");

        List all = repository.findAll(RealStatesSpecs.likeState("FLORIDA"));

        assertEquals(1,all.size());

    }

}
