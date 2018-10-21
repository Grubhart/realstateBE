package org.grubhart.service;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.repository.RealStateRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.grubhart.repository.RealStatesSpecs.*;
import static org.grubhart.repository.RealStatesSpecs.likeZipCode;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class RealStateService {


    @Autowired
    RealStateRepositoryJPA repositoryJPA;

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

    public RealStateResultItem[] searchArray(String address, String specialOffer) {
        RealStateSearchResult result =search(address,specialOffer);
        RealStateResultItem[] resultArray = parseResultToArray(result);
        return resultArray;
    }

    protected RealStateResultItem[] parseResultToArray(RealStateSearchResult result) {
        RealStateResultItem[] resultArray = new RealStateResultItem[result.size()];
        resultArray = result.getList().toArray(resultArray);
        return resultArray;
    }

    private RealStateSearchResult search(String address, String specialOffer) {
        boolean isSpecialOffer= Boolean.parseBoolean(specialOffer);

        if(isSpecialOffer) {
            return findSpecialOffer(address);
        }
        else {
            return findNoSPecialOffer(address);
        }
    }

    protected RealStateSearchResult findNoSPecialOffer(String address) {

        RealState criteria = new RealState();
        criteria.setStateAbr("FL");

        List<RealState> noSpecialOffer = repositoryJPA.findAll(
                where(likeStateName(address)
                        .or(likeStateAbr(address))
                        .or(likeStreetAddress(address))
                        .or(likeCity(address))
                        .or(likeZipCode(address))));

        return buildRealStateSearchResult(noSpecialOffer);
    }

    protected RealStateSearchResult findSpecialOffer(String address) {

        List<RealState> specialOffer = repositoryJPA.findAll(
                (where(likeStateName(address)
                        .or(likeStateAbr(address))
                        .or(likeStreetAddress(address))
                        .or(likeCity(address))
                        .or(likeZipCode(address))
                        ).and(isSpecialOffer(true))
                )
        );
        return buildRealStateSearchResult(specialOffer);
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
