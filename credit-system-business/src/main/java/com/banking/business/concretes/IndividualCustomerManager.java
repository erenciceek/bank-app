package com.banking.business.concretes;

import java.util.List;

import com.banking.core.crosscuttingconcerns.exceptions.types.BusinessException;
import com.banking.entities.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.banking.business.abstracts.IndividualCustomerService;
import com.banking.business.dtos.requests.CreateIndividualCustomerRequest;
import com.banking.business.dtos.responses.IndividualCustomerResponse;
import com.banking.business.mappings.IndividualCustomerMapper;
import com.banking.business.rules.IndividualCustomerBusinessRules;
import com.banking.core.utils.results.PageDataResponse;
import com.banking.entities.IndividualCustomer;
import com.banking.repositories.abstracts.IndividualCustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class IndividualCustomerManager implements IndividualCustomerService {
    private final IndividualCustomerRepository repository;
    private final IndividualCustomerMapper mapper;
    private final IndividualCustomerBusinessRules rules;

    @Override
    public IndividualCustomerResponse add(CreateIndividualCustomerRequest request) {
        rules.checkIfNationalIdentityExists(request.getNationalIdentity());
        rules.validateNationalIdentity(request.getNationalIdentity());
        var customer = mapper.mapToIndividualCustomer(request);
        customer = repository.save(customer);
        return mapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public IndividualCustomerResponse getByCustomerNumber(String customerNumber) {
        var customer = repository.findByCustomerNumber(customerNumber);
        return mapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public IndividualCustomerResponse getByNationalIdentity(String nationalIdentity) {
        var customer = repository.findByNationalIdentity(nationalIdentity);
        return mapper.mapToIndividualCustomerResponse(customer);
    }

    @Override
    public PageDataResponse<IndividualCustomerResponse> getAllPaged(Pageable pageable) {
        Page<IndividualCustomer> customerPage = repository.findAll(pageable);
        
        List<IndividualCustomerResponse> responses = customerPage.getContent()
            .stream()
            .map(mapper::mapToIndividualCustomerResponse)
            .toList();

        return new PageDataResponse<>(
            responses,
            customerPage.getNumber(),
            customerPage.getSize(),
            customerPage.getTotalPages(),
            customerPage.getTotalElements(),
            customerPage.hasNext(),
            customerPage.hasPrevious(),
            customerPage.isFirst(),
            customerPage.isLast()
        );
    }

}