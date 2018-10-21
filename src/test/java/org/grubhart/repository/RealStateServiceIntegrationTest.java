package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class RealStateServiceIntegrationTest {

    @Autowired
    private RealStateRepository repository;

    @Test
    public void testSelect(){

        System.out.println(repository.findSpecialOffer("55").size());

        assertEquals(1,repository.findSpecialOffer("55").size());

    }

}
