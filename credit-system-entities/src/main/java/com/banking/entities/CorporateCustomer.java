package com.banking.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "corporate_customers")
@PrimaryKeyJoinColumn(name = "customer_id")
public class CorporateCustomer extends Customer {
    
    @Column(name = "company_name", nullable = false)
    private String companyName;
    
    @Column(name = "tax_number", nullable = false, unique = true)
    private String taxNumber;
    
    @Column(name = "trade_register_number")
    private String tradeRegisterNumber;
    
    @Column(name = "contact_person")
    private String contactPerson;
} 