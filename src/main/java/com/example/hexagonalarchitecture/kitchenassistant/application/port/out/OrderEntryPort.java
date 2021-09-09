package com.example.hexagonalarchitecture.kitchenassistant.application.port.out;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.StockRequest;

public interface OrderEntryPort {

    Long createOrderEntry(Long userId, StockRequest request);
}
