package com.technoidentity.service;

import com.technoidentity.dto.CashFlowDto;
import com.technoidentity.dto.CashFlowRequest;
import com.technoidentity.entity.CashFlow;
import com.technoidentity.enums.Category;
import com.technoidentity.enums.TransactionType;
import com.technoidentity.repository.CashFlowRepository;
import com.technoidentity.util.Pagination;
import java.util.Date;
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
        cashFlow
            .stream()
            .map(
                c -> {
                  CashFlowDto cashFlowDto = mapper.map(c, CashFlowDto.class);
                  return cashFlowDto;
                })
            .collect(Collectors.toList());

    return new Pagination(cashFlowDtoList, total.intValue());
  }

  public CashFlow addCashFlow(CashFlowRequest cashFlowRequest, Long userId) {

    CashFlow cashFlow = new CashFlow();

    TransactionType transactionType =
        cashFlowRequest.getCategory() == Category.Expense
            ? TransactionType.Debit
            : TransactionType.Credit;

    cashFlow.setBankId(cashFlowRequest.getBankId());
    cashFlow.setBalance(cashFlowRequest.getBalance());
    cashFlow.setCapital(cashFlowRequest.getCapital());
    cashFlow.setInFlow(cashFlowRequest.getInFlow());
    cashFlow.setOutFlow(cashFlowRequest.getOutFlow());
    cashFlow.setCategory(cashFlowRequest.getCategory());
    cashFlow.setTransactionType(transactionType);
    cashFlow.setDate(cashFlowRequest.getDate());
    cashFlow.setCreatedBy(userId);
    cashFlow.setCreatedAt(new Date());
    cashFlow.setUpdatedBy(userId);
    cashFlow.setUpdatedAt(new Date());
    cashFlow.setStatus(1);

    return cashFlowRepository.save(cashFlow);
  }

  public CashFlowDto getCashFlowById(Long id) {
    try {
      CashFlow cashFlow = cashFlowRepository.getOne(id);
      return mapper.map(cashFlow, CashFlowDto.class);
    } catch (Exception e) {
      log.error("Could not find cash-flow error is {} ", e.getMessage());
      return null;
    }
  }

  public CashFlow updateCashFlowById(Long id, CashFlowRequest cashFlowRequest) {
    CashFlow cashFlow;
    TransactionType transactionType =
        cashFlowRequest.getCategory() == Category.Expense
            ? TransactionType.Debit
            : TransactionType.Credit;
    try {
      cashFlow = cashFlowRepository.getOne(id);
      cashFlow.setDate(cashFlowRequest.getDate());
      cashFlow.setBalance(cashFlowRequest.getBalance());
      cashFlow.setBankId(cashFlowRequest.getBankId());
      cashFlow.setInFlow(cashFlowRequest.getInFlow());
      cashFlow.setOutFlow(cashFlowRequest.getOutFlow());
      cashFlow.setCategory(cashFlowRequest.getCategory());
      cashFlow.setCapital(cashFlowRequest.getCapital());
      cashFlow.setTransactionType(transactionType);
      return cashFlowRepository.save(cashFlow);
    } catch (Exception e) {
      log.error("unable to update cash-flow error is {} ", e.getMessage());
      return null;
    }
  }
}
