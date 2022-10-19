package com.technoidentity.entity;

import com.technoidentity.enums.Category;
import com.technoidentity.enums.TransactionType;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
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

  @Temporal(TemporalType.DATE)
  @Column(name = "date")
  private Date date;

  @Column(name = "bank_id")
  private Long bankId;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "bank_id", nullable = false, insertable = false, updatable = false)
  private Bank bank;

  @Column(name = "category")
  @NotNull
  private Category category;

  @Column(name = "capital")
  private double capital;

  @Column(name = "inflow")
  private double inFlow;

  @Column(name = "outflow")
  private double outFlow;

  @Column(name = "balance")
  private double balance;

  @Column(name = "transaction_type")
  @NotNull
  private TransactionType transactionType;
}
