package com.banking.entities;

import com.banking.core.entities.BaseEntity;
import com.banking.entities.enums.CreditApplicationStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "credit_applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class CreditApplication extends BaseEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "credit_type_id", nullable = false)
    private CreditType creditType;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Integer term;

    @Column(nullable = false)
    private Double interestRate;

    @Column(nullable = false)
    private Double monthlyPayment;

    @Column(nullable = false)
    private Double totalPayment;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private CreditApplicationStatus status = CreditApplicationStatus.PENDING;

    private String rejectionReason;

} 