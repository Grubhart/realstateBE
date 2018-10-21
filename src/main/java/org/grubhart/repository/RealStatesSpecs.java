package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.grubhart.domain.RealState_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class RealStatesSpecs {

    public static Specification<RealState> inStateNames(List<String> nameList){
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<String> stateNames = new ArrayList<>();
                for (String stateName: nameList) {
                    stateNames.add(stateName.toLowerCase());
                }
                return root.get(RealState_.stateName).in(stateNames);
            }
        };
    }

    public static Specification<RealState> likeStateName(String stateName){
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.stateName),"%"+stateName.toLowerCase()+"%");
            }
        };
    }

    public static Specification likeStateAbr(String stateAbr) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.stateAbr), "%" + stateAbr.toUpperCase() + "%");
            }
        };
    }

    public static Specification inStateAbr(ArrayList<String> abrList) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<String> stateAbrs = new ArrayList<>();
                for (String stateAbr: abrList) {
                    stateAbrs.add(stateAbr.toUpperCase());
                }
                return root.get(RealState_.stateAbr).in(stateAbrs);
            }
        };
    }

    public static Specification likeStreetAddress(String streetAddress) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.streetAddress), "%" + streetAddress.toLowerCase() + "%");
            }
        };
    }

    public static Specification likeCity(String cityName) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.city), "%" + cityName.toLowerCase() + "%");
            }
        };
    }

    public static Specification inCities(ArrayList<String> cities) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<String> citiesNames = new ArrayList<>();
                for (String cityName: cities) {
                    citiesNames.add(cityName.toLowerCase());
                }
                return root.get(RealState_.city).in(citiesNames);
            }
        };
    }

    public static Specification likeZipCode(String zipCode) {
        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get(RealState_.zipCode), "%" + zipCode.trim().toLowerCase() + "%");
            }
        };
    }

    public static Specification inZipCodes(ArrayList<String> zipCodes) {

        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                ArrayList<String> codes
                        = new ArrayList<>();
                for (String code: zipCodes) {
                    codes.add(code.trim().toLowerCase());
                }
                return root.get(RealState_.zipCode).in(codes);
            }
        };
    }

    public static Specification isSpecialOffer(Boolean specialOffer) {

        return new Specification<RealState>() {
            @Override
            public Predicate toPredicate(Root<RealState> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

                return criteriaBuilder.equal(root.get(RealState_.specialOffer),specialOffer);

            }
        };
    }


}
