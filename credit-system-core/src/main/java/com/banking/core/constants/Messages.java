package com.banking.core.constants;

public class Messages {
    public static class Logging {
        public static final String EXECUTION_POINTCUT = "execution(* com.banking..*.*(..))";
        public static final String EXCEPTION_MESSAGE = "Exception in {}.{}() with cause = {}";
        public static final String NULL_CAUSE = "NULL";
    }

    public static class Customer {
        public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    }

    public static class Credit {
        public static final String CREDIT_TYPE_NOT_FOUND = "Credit type not found";
        public static final String CREDIT_TYPE_NAME_EXISTS = "A credit type with this name already exists";
        public static final String INVALID_AMOUNT_RANGE = "Minimum amount cannot be greater than maximum amount";
        public static final String INVALID_TERM_RANGE = "Minimum term cannot be greater than maximum term";
        public static final String APPLICATION_NOT_FOUND = "Credit application not found";
        public static final String INVALID_CREDIT_TYPE_FOR_CUSTOMER = "Invalid credit type for customer";
        public static final String AMOUNT_OUT_OF_RANGE = "Credit amount is out of allowed range";
        public static final String TERM_OUT_OF_RANGE = "Credit term is out of allowed range";
        public static final String APPLICATION_CANNOT_BE_CANCELLED = "Credit application cannot be cancelled";
    }
} 