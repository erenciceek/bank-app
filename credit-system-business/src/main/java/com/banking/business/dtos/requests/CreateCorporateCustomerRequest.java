package com.banking.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateCorporateCustomerRequest {
    @NotBlank
    private String companyName;
    
    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$", message = "Tax number must be 10 digits")
    private String taxNumber;
    
    private String tradeRegisterNumber;
    
    private String contactPerson;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @Email
    private String email;
    
    private String address;
} 