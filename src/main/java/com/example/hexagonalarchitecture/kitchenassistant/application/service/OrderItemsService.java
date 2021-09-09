package com.example.hexagonalarchitecture.kitchenassistant.application.service;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.OrderItems;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.LoadUserPort;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.OrderEntryPort;
import com.example.hexagonalarchitecture.kitchenassistant.domain.User;
import com.example.hexagonalarchitecture.kitchenassistant.domain.Wallet;
import com.example.hexagonalarchitecture.utility.UseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@UseCase
public class OrderItemsService implements OrderItems {

    private final LoadUserPort userPort;

    private final OrderEntryPort orderEntryPort;


    @Override
    public Long order(StockRequest request) {
        User user = userPort.loadSystemUser(request.getUserId());
        checkHasSufficientBalance(user.getWallet(), request);
        return orderEntryPort.createOrderEntry(user.getId(), request);
    }

    void checkHasSufficientBalance(Wallet wallet, StockRequest request) {
        if (!wallet.balanceCanBuy(request.getCost())) {
            throw new InsufficientFundsException();
        }
    }
}