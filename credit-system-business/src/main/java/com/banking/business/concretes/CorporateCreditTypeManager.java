package com.banking.business.concretes;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.business.abstracts.CorporateCreditTypeService;
import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCreditTypeResponse;
import com.banking.business.mappings.CorporateCreditTypeMapper;
import com.banking.business.rules.CreditTypeBusinessRules;
import com.banking.core.utils.results.PageDataResponse;
import com.banking.entities.CorporateCreditType;
import com.banking.repositories.abstracts.CorporateCreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CorporateCreditTypeManager implements CorporateCreditTypeService {
    private final CorporateCreditTypeRepository repository;
    private final CorporateCreditTypeMapper mapper;
    private final CreditTypeBusinessRules rules;

    @Override
    public CorporateCreditTypeResponse add(CreateCorporateCreditTypeRequest request) {
        rules.checkIfNameExists(request.getName());

        var creditType = mapper.mapToCorporateCreditType(request);
        creditType = repository.save(creditType);
        return mapper.mapToCorporateCreditTypeResponse(creditType);
    }

    @Override
    public CorporateCreditTypeResponse getById(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        return mapper.mapToCorporateCreditTypeResponse(creditType);
    }

    @Override
    public PageDataResponse<CorporateCreditTypeResponse> getAllPaged(Pageable pageable) {
        Page<CorporateCreditType> creditTypePage = repository.findAll(pageable);
        List<CorporateCreditTypeResponse> responses = creditTypePage.stream()
            .map(mapper::mapToCorporateCreditTypeResponse)
            .toList();

        return new PageDataResponse<>(
            responses,
            creditTypePage.getNumber(),
            creditTypePage.getSize(),
            (int) creditTypePage.getTotalElements(),
            creditTypePage.getTotalPages(),
            creditTypePage.hasNext(),
            creditTypePage.hasPrevious(),
            creditTypePage.isFirst(),
            creditTypePage.isLast()
        );
    }

    @Override
    public CorporateCreditTypeResponse activate(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        creditType.setActive(true);
        creditType = repository.save(creditType);
        return mapper.mapToCorporateCreditTypeResponse(creditType);
    }

    @Override
    public CorporateCreditTypeResponse deactivate(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        creditType.setActive(false);
        creditType = repository.save(creditType);
        return mapper.mapToCorporateCreditTypeResponse(creditType);
    }

} 