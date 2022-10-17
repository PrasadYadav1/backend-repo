package com.technoidentity.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashFlowDto {

  private Long id;

  private String date;

  private String bankDetails;

  private String transactionCategory;

  private String capitalStarted;

  private String inFlow;

  private String outFlow;

  private String balance;

  private String week;
}
