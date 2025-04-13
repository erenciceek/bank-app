package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateCorporateCreditTypeRequest;
import com.banking.business.dtos.responses.CorporateCreditTypeResponse;

public interface CorporateCreditTypeService extends CreditTypeService<CorporateCreditTypeResponse> {
    CorporateCreditTypeResponse add(CreateCorporateCreditTypeRequest request);
} 