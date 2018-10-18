package org.grubhart.domain;

import java.util.ArrayList;
import java.util.List;

public class RealStateSearchResult {

    private List<RealStateResultItem> list;

    public RealStateSearchResult(Iterable<RealState> resultList) {

        list = new ArrayList<>();
        for (RealState resulItem:   resultList) {
            list.add(new RealStateResultItem(resulItem));
        }

    }

    public int size() {
        return list.size();
    }

    public List<RealStateResultItem> getList() {
        return list;
    }

    public void setList(List<RealStateResultItem> list) {
        this.list = list;
    }
}
