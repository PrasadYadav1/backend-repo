package com.technoidentity.controller;

import com.technoidentity.service.CashFlowService;
import com.technoidentity.util.Pagination;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cash-flow")
@CrossOrigin
@Api(tags = "CashFlow")
public class CashFlowController {

  @Autowired private CashFlowService cashFlowService;

  @GetMapping("/all")
  public ResponseEntity<Pagination> showAllCashFlows(
      @RequestParam(value = "pageIndex", defaultValue = "0") int pageIndex,
      @RequestParam(value = "pageSize", defaultValue = "20") int pageSize,
      @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
      @RequestParam(value = "sortOrder", defaultValue = "DESC") String sortOrder) {
    Sort sortOrderData =
        sortOrder.equals("ASC") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
    Pageable paging = PageRequest.of(pageIndex, pageSize, sortOrderData);
    Pagination data = cashFlowService.getAllCashFlow(paging);

    return new ResponseEntity<>(data, new HttpHeaders(), HttpStatus.OK);
  }
}
