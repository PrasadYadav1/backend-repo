package com.technoidentity.dto;

import com.technoidentity.enums.Category;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CashFlowRequest {

  private Date date;

  @NotNull(message = "bankId is mandatory")
  private Long bankId;

  @NotNull(message = "category is mandatory")
  private Category category;

  @NotNull(message = "capital is mandatory")
  private Double capital;

  @NotNull(message = "inFlow is mandatory")
  private Double inFlow;

  @NotNull(message = "outFlow is mandatory")
  private Double outFlow;

  @NotNull(message = "balance is mandatory")
  private Double balance;
}
