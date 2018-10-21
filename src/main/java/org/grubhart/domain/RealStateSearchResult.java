package org.grubhart.domain;

import java.util.ArrayList;
import java.util.List;

public class RealStateSearchResult {

    private List<RealStateResultItem> list;

    public RealStateSearchResult() {
        this.list = new ArrayList<>();
    }

    public int size() {
        return list.size();
    }

    public List<RealStateResultItem> getList() {
        return list;
    }

    public void add(RealStateResultItem item) {
        list.add(item);
    }

}
