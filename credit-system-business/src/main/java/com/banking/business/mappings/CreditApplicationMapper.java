package com.banking.business.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.entities.CreditApplication;
import com.banking.entities.IndividualCustomer;

@Mapper(componentModel = "spring")
public interface CreditApplicationMapper {
    @Mapping(target = "customerId", source = "customer.id")
    @Mapping(target = "creditTypeId", source = "creditType.id")
    CreditApplicationResponse mapToResponse(CreditApplication application);

    default String getCustomerFullName(CreditApplication application) {
        if (application.getCustomer() instanceof IndividualCustomer) {
            IndividualCustomer customer = (IndividualCustomer) application.getCustomer();
            return customer.getFirstName() + " " + customer.getLastName();
        }
        return application.getCustomer().getCustomerNumber();
    }

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "customer", ignore = true)
    @Mapping(target = "creditType", ignore = true)
    @Mapping(target = "status", ignore = true)
    @Mapping(target = "rejectionReason", ignore = true)
    @Mapping(target = "interestRate", ignore = true)
    @Mapping(target = "monthlyPayment", ignore = true)
    @Mapping(target = "totalPayment", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    CreditApplication mapToCreditApplication(CreateCreditApplicationRequest request);
} 