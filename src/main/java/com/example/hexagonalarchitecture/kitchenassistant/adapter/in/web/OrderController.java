package com.example.hexagonalarchitecture.kitchenassistant.adapter.in.web;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.OrderItems;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
class OrderController {

    private final OrderItems orderItems;

    @PostMapping(path = "/order/send")
    ResponseEntity<Long> orderFoodItems(@RequestBody StockRequest request) {
        return new ResponseEntity<>(orderItems.order(request), HttpStatus.OK);
    }

}