package com.banking.business.constants;

public class Messages {
    public static class IndividualCustomer {
        public static final String NATIONAL_IDENTITY_EXISTS = "National identity already exists";
        public static final String INVALID_NATIONAL_IDENTITY_FORMAT = "National identity must be 11 digits";
    }
    
    public static class CorporateCustomer {
        public static final String TAX_NUMBER_EXISTS = "Tax number already exists";
        public static final String INVALID_TAX_NUMBER_FORMAT = "Tax number must be 10 digits";
        public static final String TRADE_REGISTER_NUMBER_EXISTS = "Trade register number already exists";
    }
    
    public static class Customer {
        public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    }

    public static class Credit {
        public static final String CREDIT_TYPE_NOT_FOUND = "Credit type not found";
        public static final String APPLICATION_NOT_FOUND = "Credit application not found";
        public static final String INVALID_CREDIT_TYPE_FOR_CUSTOMER = "Invalid credit type for customer";
        public static final String AMOUNT_OUT_OF_RANGE = "Credit amount is out of allowed range";
        public static final String TERM_OUT_OF_RANGE = "Credit term is out of allowed range";
        public static final String APPLICATION_CANNOT_BE_CANCELLED = "Credit application cannot be cancelled";
    }
} 