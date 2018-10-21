package org.grubhart.repository;

import org.grubhart.domain.RealState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RealStateRepositoryJPA extends CrudRepository<RealState,Integer>, JpaSpecificationExecutor {
}
