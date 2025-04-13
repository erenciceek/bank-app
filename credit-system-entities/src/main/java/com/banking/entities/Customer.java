package com.banking.entities;

import java.util.Random;

import com.banking.core.entities.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "customers")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Customer extends BaseEntity<Long> {
    
    @Column(name = "customer_number", nullable = false, unique = true)
    private String customerNumber;
    
    @Column(name = "phone_number")
    private String phoneNumber;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "address")
    private String address;

    @PrePersist
    protected void onCreateCustomer() {
        if (customerNumber == null) {
            // Generate a random 8-digit number
            Random random = new Random();
            customerNumber = String.format("%08d", random.nextInt(100000000));
        }
    }
} 