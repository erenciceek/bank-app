package com.banking.business.concretes;

import java.util.List;

import com.banking.entities.CreditType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.business.abstracts.IndividualCreditTypeService;
import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCreditTypeResponse;
import com.banking.business.mappings.IndividualCreditTypeMapper;
import com.banking.business.rules.CreditTypeBusinessRules;
import com.banking.core.utils.results.PageDataResponse;
import com.banking.entities.IndividualCreditType;
import com.banking.repositories.abstracts.IndividualCreditTypeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCreditTypeManager implements IndividualCreditTypeService {
    private final IndividualCreditTypeRepository repository;
    private final IndividualCreditTypeMapper mapper;
    private final CreditTypeBusinessRules rules;

    @Override
    public IndividualCreditTypeResponse add(CreateIndividualCreditTypeRequest request) {
        rules.checkIfNameExists(request.getName());

        var creditType = mapper.mapToIndividualCreditType(request);
        creditType = repository.save(creditType);
        return mapper.mapToIndividualCreditTypeResponse(creditType);
    }

    @Override
    public IndividualCreditTypeResponse getById(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        return mapper.mapToIndividualCreditTypeResponse(creditType);
    }

    @Override
    public PageDataResponse<IndividualCreditTypeResponse> getAllPaged(Pageable pageable) {
        Page<IndividualCreditType> creditTypePage = repository.findAll(pageable);
        List<IndividualCreditTypeResponse> responses = creditTypePage.stream()
            .map(mapper::mapToIndividualCreditTypeResponse)
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
    public IndividualCreditTypeResponse activate(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        creditType.setActive(true);
        creditType = repository.save(creditType);
        return mapper.mapToIndividualCreditTypeResponse(creditType);
    }

    @Override
    public IndividualCreditTypeResponse deactivate(Long id) {
        rules.checkIfExists(id);
        var creditType = repository.findById(id).orElseThrow();
        creditType.setActive(false);
        creditType = repository.save(creditType);
        return mapper.mapToIndividualCreditTypeResponse(creditType);
    }

}