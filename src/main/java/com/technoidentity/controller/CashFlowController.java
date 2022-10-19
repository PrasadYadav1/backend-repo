package com.technoidentity.controller;

import com.technoidentity.dto.CashFlowRequest;
import com.technoidentity.entity.CashFlow;
import com.technoidentity.service.CashFlowService;
import com.technoidentity.util.CommonResponse;
import com.technoidentity.util.DateFormats;
import com.technoidentity.util.Pagination;
import com.technoidentity.util.ResponseMessage;
import io.swagger.annotations.Api;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
  SimpleDateFormat sm = new DateFormats().DATE_TIME_FORMAT;

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

  @PostMapping("/create")
  public ResponseEntity<?> addCashFlow(@Valid @RequestBody CashFlowRequest cashFlowRequest) {
    CashFlow cashFlow;
    String message = "";
    try {
      //will update this code once security is enabled for this controller
      //  UserPrincipal userDetails =
      //        (UserPrincipal)
      // SecurityContextHolder.getContext().getAuthentication().getPrincipal();

      cashFlow = cashFlowService.addCashFlow(cashFlowRequest, 1L);
    } catch (Exception e) {
      message = "Could not create cash-flow: " + e + "!";
      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED)
          .body(new ResponseMessage(message));
    }
    return new ResponseEntity(
        new CommonResponse(
            cashFlow.getId(),
            sm.format(new Date()),
            HttpServletResponse.SC_OK,
            "",
            "cash-flow added successfully",
            "/api/cash-flow/create"),
        new HttpHeaders(),
        HttpStatus.OK);
  }
}
