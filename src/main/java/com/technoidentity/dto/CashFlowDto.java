package com.technoidentity.dto;

import com.technoidentity.enums.Category;
import com.technoidentity.enums.TransactionType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashFlowDto {

  private Long id;

  private Date date;

  private String bankId;

  private Category category;

  private TransactionType transactionType;

  private String capital;

  private double inFlow;

  private double outFlow;

  private double balance;
}
