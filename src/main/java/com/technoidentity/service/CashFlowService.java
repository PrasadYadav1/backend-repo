package com.technoidentity.service;

import com.technoidentity.dto.CashFlowDto;
import com.technoidentity.entity.CashFlow;
import com.technoidentity.repository.CashFlowRepository;
import com.technoidentity.util.Pagination;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CashFlowService {

  @Autowired final Mapper mapper;

  @Autowired private final CashFlowRepository cashFlowRepository;

  public Pagination getAllCashFlow(Pageable pageable) {
    Page<CashFlow> cashFlow = cashFlowRepository.findAll(pageable);

    Long total = cashFlow.getTotalElements();
    List<CashFlowDto> cashFlowDtoList =
        cashFlow.stream().map(c -> mapper.map(c, CashFlowDto.class)).collect(Collectors.toList());

    return new Pagination(cashFlowDtoList, total.intValue());
  }
}
