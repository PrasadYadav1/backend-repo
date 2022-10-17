package com.technoidentity.repository;

import com.technoidentity.entity.CashFlow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = false)
public interface CashFlowRepository extends JpaRepository<CashFlow, Long> {}
