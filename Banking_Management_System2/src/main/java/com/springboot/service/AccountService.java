package com.springboot.service;

import java.util.List;

import com.springboot.dto.AccountDto;


public interface AccountService {
	
	
	AccountDto createAccount(AccountDto accountDto);
	
	AccountDto getAccountById(Long id);

	AccountDto deposit(Long id, double amount);
	
	AccountDto withdraw(Long id, double amount);
	
	List<AccountDto> getAllAccounts();

	void deleteUser(Long Id); 
}
