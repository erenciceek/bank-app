package com.banking.business.mappings;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCreditTypeResponse;
import com.banking.entities.CorporateCreditType;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CorporateCreditTypeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    CorporateCreditType mapToCorporateCreditType(CreateCorporateCreditTypeRequest request);

    CorporateCreditTypeResponse mapToCorporateCreditTypeResponse(CorporateCreditType creditType);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "deletedDate", ignore = true)
    void updateCorporateCreditType(CreateCorporateCreditTypeRequest request, @MappingTarget CorporateCreditType creditType);
} 