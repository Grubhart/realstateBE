package org.grubhart.service;

import org.grubhart.domain.RealStateSearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RealStateServiceIntegrationTest {

    @Autowired
    private RealStateService service;

    @Test
    public void testFindSpecialOffer(){

        RealStateSearchResult specialOffer = service.findSpecialOffer("55");
        assertEquals(1,specialOffer.getList().size());

    }

    @Test
    public void testFindNoSpecialOffer(){

        RealStateSearchResult specialOffer = service.findNoSPecialOffer("55");
        assertEquals(3,specialOffer.getList().size());

    }

}
