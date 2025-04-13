package com.banking.business.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CreateIndividualCustomerRequest {
    @NotBlank
    private String firstName;
    
    @NotBlank
    private String lastName;
    
    @NotBlank
    @Pattern(regexp = "^[0-9]{11}$", message = "National Identity must be 11 digits")
    private String nationalIdentity;
    
    private String birthDate;
    
    @Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
    private String phoneNumber;
    
    @Email
    private String email;
    
    private String address;
} 