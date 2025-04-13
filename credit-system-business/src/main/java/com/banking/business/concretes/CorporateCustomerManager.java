package com.banking.business.concretes;

import com.banking.business.abstracts.CorporateCustomerService;
import com.banking.business.dtos.requests.CreateCorporateCustomerRequest;
import com.banking.business.dtos.responses.CorporateCustomerResponse;
import com.banking.business.mappings.CorporateCustomerMapper;
import com.banking.business.rules.CorporateCustomerBusinessRules;
import com.banking.repositories.abstracts.CorporateCustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CorporateCustomerManager implements CorporateCustomerService {
    private final CorporateCustomerRepository repository;
    private final CorporateCustomerMapper mapper;
    private final CorporateCustomerBusinessRules rules;

    @Override
    public CorporateCustomerResponse add(CreateCorporateCustomerRequest request) {
        rules.checkIfTaxNumberExists(request.getTaxNumber());
        rules.validateTaxNumber(request.getTaxNumber());
        rules.checkIfTradeRegisterNumberExists(request.getTradeRegisterNumber());
        var customer = mapper.mapToCorporateCustomer(request);
        customer = repository.save(customer);
        return mapper.mapToCorporateCustomerResponse(customer);
    }

    @Override
    public CorporateCustomerResponse getByCustomerNumber(String customerNumber) {
        var customer = repository.findByCustomerNumber(customerNumber);
        return mapper.mapToCorporateCustomerResponse(customer);
    }

    @Override
    public CorporateCustomerResponse getByTaxNumber(String taxNumber) {
        var customer = repository.findByTaxNumber(taxNumber);
        return mapper.mapToCorporateCustomerResponse(customer);
    }
} 