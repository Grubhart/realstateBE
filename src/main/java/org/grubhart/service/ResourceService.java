package org.grubhart.service;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.repository.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    @Autowired
    private RealStateRepository realStateRepository;

    public void setSpecialFlag(RealStateResultItem row) {
        if(isOdd(row.getRowId()) && !isMultiple3(row.getRowId())){
            row.setSpecialFlag("Q");
        }else if(isMultiple3(row.getRowId())){
            row.setSpecialFlag("G");
        }else{
            row.setSpecialFlag("X");
        }
    }

    private boolean isMultiple3(Integer rowId) {
        return rowId % 3 == 0;  //rowId never is 0
    }

    private boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public RealStateSearchResult search(String address, String specialOffer) {


        boolean offer= Boolean.parseBoolean(specialOffer);

        if(offer)
            return buildRealStateSearchResult(realStateRepository.findSpecialOffer(address.trim()));
        else
            return buildRealStateSearchResult(realStateRepository.findByStateNameContainingOrStateAbrContainingOrStreetAddressContainingOrCityContainingOrZipCodeContaining(address.trim(),address.trim(),address.trim(),address.trim(),address.trim()));


    }

    public RealStateResultItem[] searchArray(String address, String specialOffer) {
        RealStateSearchResult result =search(address,specialOffer);
        RealStateResultItem[] resultArray = new RealStateResultItem[result.size()];
        resultArray = result.getList().toArray(resultArray);
        return resultArray;
    }

    public RealStateSearchResult buildRealStateSearchResult (List<RealState> resultList) {

        RealStateSearchResult result = new RealStateSearchResult();

        for (RealState resulItem:   resultList) {
            RealStateResultItem item = new RealStateResultItem(resulItem);
            item.setRowId(result.size()+1);
            setSpecialFlag(item);
            result.add(item);
        }


        return result;

    }
}
