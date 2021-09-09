package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import com.example.hexagonalarchitecture.kitchenassistant.application.port.in.StockRequest;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.LoadUserPort;
import com.example.hexagonalarchitecture.kitchenassistant.application.port.out.OrderEntryPort;
import com.example.hexagonalarchitecture.kitchenassistant.domain.User;
import com.example.hexagonalarchitecture.utility.PersistenceAdapter;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityNotFoundException;

@PersistenceAdapter
@RequiredArgsConstructor
public class UserPersistenceAdapter implements LoadUserPort, OrderEntryPort {

    private final UserRepository userRepository;

    private final OrderEntryRepository orderEntryRepository;

    private final UserMapper userMapper;

    @Override
    public User loadSystemUser(Long id) {
        UserEntity user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return userMapper.mapToDomainEntity(user);
    }

    @Override
    public Long createOrderEntry(Long userId, StockRequest request) {
        UserEntity user = userRepository.findById(userId).orElseThrow(EntityNotFoundException::new);
        OrderEntryEntity response = orderEntryRepository.save(new OrderEntryEntity(user, request.getFoodItems()));
        return response.getId();
    }
}
