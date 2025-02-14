package com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
