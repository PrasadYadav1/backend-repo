package com.technoidentity.entity;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cash_flows")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashFlow extends SharedModel implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "date")
  private LocalDate date;

  @Column(name = "bank_details")
  private String bankDetails;

  @Column(name = "transaction_category")
  private String transactionCategory;

  @Column(name = "capital_started")
  private String capitalStarted;

  @Column(name = "in_flow")
  private String inFlow;

  @Column(name = "out_flow")
  private String outFlow;

  @Column(name = "balance")
  private String balance;

  @Column(name = "week")
  private String week;
}
