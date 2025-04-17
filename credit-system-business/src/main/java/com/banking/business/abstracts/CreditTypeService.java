package com.banking.business.abstracts;

import com.banking.entities.CreditType;
import org.springframework.data.domain.Pageable;

import com.banking.business.dtos.responses.CreditTypeResponse;
import com.banking.core.utils.results.PageDataResponse;

public interface CreditTypeService<T extends CreditTypeResponse> {
    T getById(Long id);
    PageDataResponse<T> getAllPaged(Pageable pageable);
    T deactivate(Long id);
    T activate(Long id);
} 