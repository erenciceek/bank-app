package com.banking.business.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.entities.IndividualCustomer;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndividualCustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    IndividualCustomer mapToIndividualCustomer(CreateIndividualCustomerRequest request);

    IndividualCustomerResponse mapToIndividualCustomerResponse(IndividualCustomer customer);
} 