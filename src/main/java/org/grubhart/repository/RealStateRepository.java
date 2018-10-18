package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RealStateRepository extends CrudRepository<RealState,Integer> {
}
