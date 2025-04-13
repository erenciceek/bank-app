package com.banking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "individual_credit_types")
@PrimaryKeyJoinColumn(name = "credit_type_id")
@Getter
@Setter
public class IndividualCreditType extends CreditType {
    
    @Column(name = "min_credit_score", nullable = false)
    private Integer minCreditScore;
    
    @Column(name = "requires_guarantor")
    private Boolean requiresGuarantor = false;
} 