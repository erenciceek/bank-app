package com.banking.business.abstracts;

import org.springframework.data.domain.Pageable;

import com.banking.business.dtos.requests.CreateCreditApplicationRequest;
import com.banking.business.dtos.responses.CreditApplicationResponse;
import com.banking.core.utils.results.PageDataResponse;


public interface CreditApplicationService {
    CreditApplicationResponse apply(CreateCreditApplicationRequest request);
    CreditApplicationResponse getById(Long id);
    PageDataResponse<CreditApplicationResponse> getAllByCustomerId(Long customerId, Pageable pageable);
    CreditApplicationResponse cancel(Long id);
    PageDataResponse<CreditApplicationResponse> getAll(int page, int size, String status);

} 