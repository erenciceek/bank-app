package com.banking.business.abstracts;

import com.banking.business.dtos.requests.CreateIndividualCreditTypeRequest;
import com.banking.business.dtos.responses.IndividualCreditTypeResponse;

public interface IndividualCreditTypeService extends CreditTypeService<IndividualCreditTypeResponse> {
    IndividualCreditTypeResponse add(CreateIndividualCreditTypeRequest request);
} 