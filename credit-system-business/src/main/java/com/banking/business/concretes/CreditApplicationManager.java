package com.banking.business.concretes;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.banking.business.abstracts.CreditApplicationService;
import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.business.mappings.CreditApplicationMapper;
import com.banking.business.rules.CreditApplicationBusinessRules;
import com.banking.core.utils.results.PageDataResponse;
import com.banking.entities.CreditApplication;
import com.banking.entities.CreditType;
import com.banking.entities.Customer;
import com.banking.entities.enums.CreditApplicationStatus;
import com.banking.repositories.abstracts.CreditApplicationRepository;
import com.banking.repositories.abstracts.CreditTypeRepository;
import com.banking.repositories.abstracts.CustomerRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CreditApplicationManager implements CreditApplicationService {
    private final CreditApplicationRepository applicationRepository;
    private final CustomerRepository<Customer> customerRepository;
    private final CreditTypeRepository<CreditType> creditTypeRepository;
    private final CreditApplicationMapper mapper;
    private final CreditApplicationBusinessRules rules;

    @Override
    @Transactional
    public CreditApplicationResponse apply(CreateCreditApplicationRequest request) {

        rules.checkIfCustomerExists(request.getCustomerId());
        rules.checkIfCreditTypeExists(request.getCreditTypeId());


        Customer customer = customerRepository.findById(request.getCustomerId()).<Customer>orElseThrow();
        CreditType creditType = creditTypeRepository.findById(request.getCreditTypeId()).<CreditType>orElseThrow();

        rules.checkIfCreditTypeIsActive(creditType);
        rules.checkIfCustomerCanApplyForCreditType(customer, creditType);
        rules.checkIfAmountInRange(request.getAmount(), creditType);
        rules.checkIfTermInRange(request.getTerm(), creditType);


        var application = new CreditApplication();
        application.setCustomer(customer);
        application.setCreditType(creditType);
        application.setAmount(request.getAmount());
        application.setTerm(request.getTerm());
        application.setInterestRate(creditType.getBaseInterestRate());


        calculatePayments(application);

        application = applicationRepository.save(application);
        return mapper.mapToResponse(application);
    }

    @Override
    public CreditApplicationResponse getById(Long id) {
        rules.checkIfApplicationExists(id);
        var application = applicationRepository.findById(id).orElseThrow();
        return mapper.mapToResponse(application);
    }

    @Override
    public PageDataResponse<CreditApplicationResponse> getAllByCustomerId(Long customerId, Pageable pageable) {
        rules.checkIfCustomerExists(customerId);

        Page<CreditApplication> applicationPage = applicationRepository.findAllByCustomerId(customerId, pageable);
        List<CreditApplicationResponse> responses = applicationPage.getContent()
            .stream()
            .map(mapper::mapToResponse)
            .toList();

        return new PageDataResponse<>(
            responses,
            applicationPage.getNumber(),
            applicationPage.getSize(),
            applicationPage.getTotalPages(),
            applicationPage.getTotalElements(),
            applicationPage.hasNext(),
            applicationPage.hasPrevious(),
            applicationPage.isFirst(),
            applicationPage.isLast()
        );
    }

    @Override
    public PageDataResponse<CreditApplicationResponse> getAll(int page, int size, String status) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "createdDate"));
        Page<CreditApplication> applicationPage;

        if (status != null && !status.isBlank()) {
            CreditApplicationStatus parsedStatus = CreditApplicationStatus.valueOf(status.toUpperCase());
            applicationPage = applicationRepository.findAllByStatus(parsedStatus, pageable);
        } else {
            applicationPage = applicationRepository.findAll(pageable);
        }

        List<CreditApplicationResponse> responses = applicationPage.getContent()
                .stream()
                .map(mapper::mapToResponse)
                .toList();

        return new PageDataResponse<>(
                responses,
                applicationPage.getNumber(),
                applicationPage.getSize(),
                applicationPage.getTotalPages(),
                applicationPage.getTotalElements(),
                applicationPage.hasNext(),
                applicationPage.hasPrevious(),
                applicationPage.isFirst(),
                applicationPage.isLast()
        );
    }


    @Override
    @Transactional
    public CreditApplicationResponse cancel(Long id) {
        rules.checkIfApplicationExists(id);
        var application = applicationRepository.findById(id).orElseThrow();

        rules.checkIfApplicationCanBeCancelled(application);

        application.setStatus(CreditApplicationStatus.CANCELLED);
        application = applicationRepository.save(application);

        return mapper.mapToResponse(application);
    }

    private void calculatePayments(CreditApplication application) {
        double amount = application.getAmount();
        int term = application.getTerm();
        double monthlyInterestRate = application.getInterestRate() / 12 / 100;

        // Aylık ödeme hesaplama formülü: PMT = P * r * (1 + r)^n / ((1 + r)^n - 1)
        // P: kredi tutarı, r: aylık faiz oranı, n: vade
        double monthlyPayment = amount * 
            monthlyInterestRate * Math.pow(1 + monthlyInterestRate, term) / 
            (Math.pow(1 + monthlyInterestRate, term) - 1);

        double totalPayment = monthlyPayment * term;

        application.setMonthlyPayment(Math.round(monthlyPayment * 100.0) / 100.0);
        application.setTotalPayment(Math.round(totalPayment * 100.0) / 100.0);
    }
} 