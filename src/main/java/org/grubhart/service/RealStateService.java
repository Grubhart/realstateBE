package org.grubhart.service;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.repository.RealStateRepositoryJPA;
import org.grubhart.util.CriteriaRequest;
import org.grubhart.util.CriteriaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.grubhart.repository.RealStatesSpecs.*;
import static org.grubhart.repository.RealStatesSpecs.likeZipCode;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
public class RealStateService {


    @Autowired
    RealStateRepositoryJPA repositoryJPA;

    @Autowired
    CriteriaUtil criteriaUtil;

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

        Specification specification;
        CriteriaRequest criteriaRequest = criteriaUtil.process(address);

        if(null != criteriaRequest.getLikeField()) {
            Specification genericSpec = getGenericSpecification(criteriaRequest);
            Specification specificSpecs = getSpecificSpecs(criteriaRequest);
            specification = where(genericSpec.and(specificSpecs));
        }else{
            Specification specificSpecs = getSpecificSpecs(criteriaRequest);
            specification = where(specificSpecs);
        }

        List<RealState> noSpecialOffer = repositoryJPA.findAll(specification);
        return buildRealStateSearchResult(noSpecialOffer);
    }

    private Specification getSpecificSpecs(CriteriaRequest criteriaRequest) {

        Specification result = null;
        if( !criteriaRequest.getStateAbr().isEmpty() ){
            if (null==result){
                result=inStateAbr(criteriaRequest.getStateAbr());
            }else{
                result=result.and(inStateAbr(criteriaRequest.getStateAbr()));
            }
        }
        if(!criteriaRequest.getCity().isEmpty() ){
            if (null==result){
                result=inCities(criteriaRequest.getCity());
            }else{
                result=result.and(inCities(criteriaRequest.getCity()));
            }
        }
        if(!criteriaRequest.getStateNames().isEmpty() ){
            if (null==result){
                result=inStateNames(criteriaRequest.getStateNames());
            }else{
                result=result.and(inStateNames(criteriaRequest.getStateNames()));
            }
        }
        if(!criteriaRequest.getStreetAddress().isEmpty() ){
            if (null==result){
                result=likeStreetAddress(criteriaRequest.getStreetAddress().get(0));
            }else{
                result=result.and(likeStreetAddress(criteriaRequest.getStreetAddress().get(0)));
            }
        }
        if(!criteriaRequest.getZipCode().isEmpty() ){
            if (null==result){
                result=inZipCodes(criteriaRequest.getZipCode());
            }else{
                result=result.and(inZipCodes(criteriaRequest.getZipCode()));
            }
        }

        return result;
    }

    private Specification getGenericSpecification(CriteriaRequest criteriaRequest) {

        Specification result = null;
            for (String genericField : criteriaRequest.getGenericFields()) {
                if (genericField.equalsIgnoreCase(CriteriaRequest.STATE_NAME)) {
                    if (null == result) {
                        result = likeStateName(criteriaRequest.getLikeField());
                    } else {
                        result = result.or(likeStateName(criteriaRequest.getLikeField()));
                    }
                }
                if (genericField.equalsIgnoreCase(CriteriaRequest.STATE_ABR)) {
                    if (null == result) {
                        result = likeStateAbr(criteriaRequest.getLikeField());
                    } else {
                        result = result.or(likeStateAbr(criteriaRequest.getLikeField()));
                    }
                }
                if (genericField.equalsIgnoreCase(CriteriaRequest.CITY)) {
                    if (null == result) {
                        result = likeCity(criteriaRequest.getLikeField());
                    } else {
                        result = result.or(likeCity(criteriaRequest.getLikeField()));
                    }
                }
                if (genericField.equalsIgnoreCase(CriteriaRequest.STREET_ADDRESS)) {
                    if (null == result) {
                        result = likeStreetAddress(criteriaRequest.getLikeField());
                    } else {
                        result = result.or(likeStreetAddress(criteriaRequest.getLikeField()));
                    }
                }
                if (genericField.equalsIgnoreCase(CriteriaRequest.ZIP_CODE)) {
                    if (null == result) {
                        result = likeZipCode(criteriaRequest.getLikeField());
                    } else {
                        result = result.or(likeZipCode(criteriaRequest.getLikeField()));
                    }
                }
            }

        return result;
    }

    protected RealStateSearchResult findSpecialOffer(String address) {

        Specification specification;
        CriteriaRequest criteriaRequest = criteriaUtil.process(address);

        if(null != criteriaRequest.getLikeField()) {
            Specification genericSpec = getGenericSpecification(criteriaRequest);
            Specification specificSpecs = getSpecificSpecs(criteriaRequest);
            specification = where(genericSpec.and(specificSpecs).and(isSpecialOffer(true)));
        }else{
            Specification specificSpecs = getSpecificSpecs(criteriaRequest);
            specification = where(specificSpecs.and(isSpecialOffer(true)));
        }

        List<RealState> noSpecialOffer = repositoryJPA.findAll(specification);
        return buildRealStateSearchResult(noSpecialOffer);

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
