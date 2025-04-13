package com.banking.repositories.abstracts;

import com.banking.entities.CreditType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseCreditTypeRepository extends JpaRepository<CreditType,Long>{
    boolean existsByName(String name);
}
