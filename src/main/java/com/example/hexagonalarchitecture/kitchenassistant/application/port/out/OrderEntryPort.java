package com.example.hexagonalarchitecture.kitchenassistant.application.port.out;

import com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence.OrderEntryEntity;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.domain.Order;

public interface OrderEntryPort {

    Long createOrderEntry(Long userId, StockRequest request);

    OrderEntryEntity findById(Long id);
}
