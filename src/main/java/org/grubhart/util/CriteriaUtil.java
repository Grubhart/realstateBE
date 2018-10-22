package org.grubhart.util;


import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CriteriaUtil {
    public CriteriaRequest process(String request) {
        CriteriaRequest result = new CriteriaRequest();
        String[] strings = request.split(";");

        for (int i=0;i<strings.length;i++) {
            String parameter = strings[i];

            if(parameter.toLowerCase().contains(CriteriaRequest.STATE_ABR.toLowerCase())){
                result.setStateAbr(getOpciones(parameter));
                result.getGenericFields().remove(CriteriaRequest.STATE_ABR);
            }else if(parameter.toLowerCase().contains(CriteriaRequest.CITY.toLowerCase())){
                result.setCity(getOpciones(parameter));
                result.getGenericFields().remove(CriteriaRequest.CITY);
            }else if(parameter.toLowerCase().contains(CriteriaRequest.STATE_NAME.toLowerCase())) {
                result.setStateNames(getOpciones(parameter));
                result.getGenericFields().remove(CriteriaRequest.STATE_NAME);
            }else if(parameter.toLowerCase().contains(CriteriaRequest.ZIP_CODE.toLowerCase())) {
                result.setZipCode(getOpciones(parameter));
                result.getGenericFields().remove(CriteriaRequest.ZIP_CODE);
            }else if(parameter.toLowerCase().contains(CriteriaRequest.STREET_ADDRESS.toLowerCase())) {
                result.setStreetAddress(getOpciones(parameter));
                result.getGenericFields().remove(CriteriaRequest.STREET_ADDRESS);
            }else{
                result.setLikeField(parameter);
            }
        }

        return result;
    }

    private ArrayList<String> getOpciones(String parameter) {
        ArrayList<String> stateAbrList = new ArrayList<>();
        String[] stateAbrArray = parameter.split("=");
        String[] stateAbrs = stateAbrArray[1].trim().split(",");
        for (int j = 0; j < stateAbrs.length ; j++) {
            stateAbrList.add(stateAbrs[j].trim());
        }
        return stateAbrList;
    }


}
