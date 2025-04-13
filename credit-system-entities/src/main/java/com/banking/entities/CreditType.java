package com.banking.entities;

import com.banking.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "credit_types")
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class CreditType extends BaseEntity<Long> {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "min_amount", nullable = false)
    private Double minAmount;

    @Column(name = "max_amount", nullable = false)
    private Double maxAmount;

    @Column(name = "min_term", nullable = false)
    private Integer minTerm;

    @Column(name = "max_term", nullable = false)
    private Integer maxTerm; 

    @Column(name = "base_interest_rate", nullable = false)
    private Double baseInterestRate;

    @Column(nullable = false)
    private boolean active = true;

} 