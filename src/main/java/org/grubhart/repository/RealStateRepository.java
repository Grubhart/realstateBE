package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealStateRepository extends CrudRepository<RealState,Integer>, JpaSpecificationExecutor {

    //List<RealState> findByStateNameLikeOrStateAbrLikeOrStreetAddressLikeOrCityLikeOrZipCodeLike(String stateName, String stateAbr,String streetAddress,String city,String zipCode);

    @Query(value = "select realstate0_.id as id1_0_, \n" +
            "       realstate0_.city as city2_0_, \n" +
            "       realstate0_.special_offer as special_3_0_, \n" +
            "       realstate0_.state_abr as state_ab4_0_, \n" +
            "       realstate0_.state_name as state_na5_0_, \n" +
            "       realstate0_.street_address as street_a6_0_, \n" +
            "       realstate0_.zip_code as zip_code7_0_ \n" +
            "       \n" +
            "  from home realstate0_ \n" +
            "  where (realstate0_.state_name like %?1% \n" +
            "        or realstate0_.state_abr like %?1% \n" +
            "        or realstate0_.street_address like %?1% \n" +
            "        or realstate0_.city like %?1% \n" +
            "        or realstate0_.zip_code like %?1%) \n" +
            "        and realstate0_.special_offer is true ", nativeQuery = true)
    List<RealState> findSpecialOffer(String stateName);

    List<RealState> findByStateNameContainingOrStateAbrContainingOrStreetAddressContainingOrCityContainingOrZipCodeContaining(String stateName, String stateAbr,String streetAddress,String city,String zipCode);

}
