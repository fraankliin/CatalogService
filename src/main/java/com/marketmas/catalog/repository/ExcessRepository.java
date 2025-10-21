package com.marketmas.catalog.repository;

import com.marketmas.catalog.entity.Excess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcessRepository extends JpaRepository<Excess, Integer> {


}
