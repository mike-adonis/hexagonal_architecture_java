package com.example.hexagonalarchitecture.kitchenassistant.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
class UserEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;

	@OneToOne
	private AddressJpaEntity addressJpaEntity;

	@OneToOne(fetch = FetchType.EAGER)
	private WalletJpaEntity walletJpaEntity;

}