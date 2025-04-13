package com.banking.business.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCreditTypeResponse;
import com.banking.entities.IndividualCreditType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IndividualCreditTypeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    IndividualCreditType mapToIndividualCreditType(CreateIndividualCreditTypeRequest request);

    IndividualCreditTypeResponse mapToIndividualCreditTypeResponse(IndividualCreditType creditType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    void updateIndividualCreditType(CreateIndividualCreditTypeRequest request, @MappingTarget IndividualCreditType creditType);
} 