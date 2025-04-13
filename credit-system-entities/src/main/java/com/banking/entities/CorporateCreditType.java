package com.banking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "corporate_credit_types")
@PrimaryKeyJoinColumn(name = "credit_type_id")
@Getter
@Setter
public class CorporateCreditType extends CreditType {
    
    @Column(name = "min_revenue", nullable = false)
    private Double minRevenue;
    
    @Column(name = "min_company_age", nullable = false)
    private Integer minCompanyAge; // ay cinsinden
    
    @Column(name = "requires_collateral")
    private Boolean requiresCollateral = false;
} 