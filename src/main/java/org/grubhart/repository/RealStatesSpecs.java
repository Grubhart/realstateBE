package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealState_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.List;

public class RealStatesSpecs {

    public static Specification<RealState> inStates(List<String> states){
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return root.get(RealState_.stateName).in(states);
            }
        };
    }

    public static Specification<RealState> likeState(String stateName){
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.stateName),stateName);
            }
        };
    }

}
