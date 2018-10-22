package org.grubhart.util;

import org.hibernate.Criteria;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CriteriaUtilTest {

    CriteriaUtil util;

    public CriteriaUtilTest() {
        this.util = new CriteriaUtil();
    }


    @Test
    public void testProcess(){
        String request="55;stateAbr=FL,CA;city=orlando,new yoRk";

        CriteriaRequest expectedCriteriaRequest = new CriteriaRequest();
        expectedCriteriaRequest.setLikeField("55");
        ArrayList<String>stateAbrList = new ArrayList<>();
        stateAbrList.add("FL");
        stateAbrList.add("CA");
        expectedCriteriaRequest.setStateAbr(stateAbrList);
        ArrayList<String>cityList = new ArrayList<>();
        cityList.add("orlando");
        cityList.add("new yoRk");
        expectedCriteriaRequest.setCity(cityList);


        CriteriaRequest obtainedCriteriaRequest = util.process(request);

        assertEquals(expectedCriteriaRequest.getLikeField(),obtainedCriteriaRequest.getLikeField());
        assertEquals(expectedCriteriaRequest.getStateAbr(),obtainedCriteriaRequest.getStateAbr());
        assertEquals(expectedCriteriaRequest.getCity(),obtainedCriteriaRequest.getCity());
        assertEquals(3,obtainedCriteriaRequest.getGenericFields().size());
    }


}
