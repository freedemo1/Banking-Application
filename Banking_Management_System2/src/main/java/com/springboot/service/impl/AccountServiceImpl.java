package com.springboot.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.springboot.dto.AccountDto;
import com.springboot.entity.Account;
import com.springboot.mapper.AccountMapper;
import com.springboot.repository.AccountRepository;
import com.springboot.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	//Injecting the dependency
	private AccountRepository accountRepository;
//--------------------------------------------------------------------------
	//Constructor based Injecting the dependency
	public AccountServiceImpl(AccountRepository accountRepository) {
	
		this.accountRepository = accountRepository;
	}
//--------------------------------------------------------------------------
	
	//Convert AccountDto into Account JPa Entity and 
	//then save Account JPa Entity into Database 
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account = AccountMapper.mapToAccount(accountDto);
		Account saveAccount = accountRepository.save(account);
		
		return AccountMapper.mapToAccountDto(saveAccount);
	}
//--------------------------------------------------------------------------

	@Override
public AccountDto getAccountById(Long id) {
	Account account = accountRepository.findById(id).
			orElseThrow(() -> new RuntimeException("Account does not Exixts"));
	return AccountMapper.mapToAccountDto(account) ;
}

//--------------------------------------------------------------------------
	@Override
	public AccountDto deposit(Long id, double amount) {
		Account account = accountRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not Exixts"));
		
			double total = account.getBalance() + amount;
			account.setBalance(total);
			Account savedAccount = accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}

//-------------------------------------------------------------------------	
	
	@Override
	public AccountDto withdraw(Long id, double amount) {
		Account account = accountRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not Exixts"));
		if(account.getBalance() <  amount) {
			throw new RuntimeException("Insufficient amount");
		}
		double total  = account.getBalance() - amount;
		account.setBalance(total);
		Account savedAccount =  accountRepository.save(account);
		return AccountMapper.mapToAccountDto(savedAccount);
	}
//-------------------------------------------------------------------------	

	@Override
	public List<AccountDto> getAllAccounts() {
		List<Account> accounts = accountRepository.findAll();
		return  accounts.stream().map((account) -> AccountMapper.mapToAccountDto(account)).
		collect(Collectors.toList());
		
	}
//-------------------------------------------------------------------------
	
	@Override
	public void deleteUser(Long id) {
		Account account = accountRepository.findById(id).
				orElseThrow(() -> new RuntimeException("Account does not Exixts"));
		
		accountRepository.deleteById(id);
	}
	
//--------------------------------------------------------------------------

	
	
}
