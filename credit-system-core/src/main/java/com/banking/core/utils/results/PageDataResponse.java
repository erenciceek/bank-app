package com.banking.core.utils.results;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageDataResponse<T> {
    private List<T> items;
    private int pageNumber;
    private int pageSize;
    private int totalPages;
    private long totalItems;
    private boolean hasNextPage;
    private boolean hasPreviousPage;
    private boolean isFirstPage;
    private boolean isLastPage;
} 