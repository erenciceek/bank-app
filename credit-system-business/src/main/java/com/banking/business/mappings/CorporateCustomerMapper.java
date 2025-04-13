package com.banking.business.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.entities.CorporateCustomer;



@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorporateCustomerMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    @Mapping(target = "customerNumber", ignore = true)
    CorporateCustomer mapToCorporateCustomer(CreateCorporateCustomerRequest request);

    CorporateCustomerResponse mapToCorporateCustomerResponse(CorporateCustomer customer);
} 