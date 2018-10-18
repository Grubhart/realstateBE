package org.grubhart.service;

import org.grubhart.domain.RealStateResultItem;
import org.grubhart.domain.RealStateSearchResult;
import org.grubhart.repository.RealStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public boolean isOdd(int i) {
        return i % 2 == 1;
    }

    public RealStateSearchResult search(String address, String specialOffer) {
        RealStateSearchResult realStateSearchResult = new RealStateSearchResult(realStateRepository.findAll());
        return realStateSearchResult;
    }
}
