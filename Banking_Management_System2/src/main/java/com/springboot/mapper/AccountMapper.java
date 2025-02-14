package com.springboot.mapper;

import com.springboot.dto.AccountDto;
import com.springboot.entity.Account;

//Mapper Class to Map Dto into entity and ViseVersa.
public class AccountMapper {
	//passed AccountDto as a parameter
	// Converts AccountDto into Accounts JPa entity   
	public static Account mapToAccount(AccountDto accountDto) {
		// Create the Object
		Account account = new Account(accountDto.getId(), accountDto.getAccountHolderName(), 
				//passing values to the constructor
				accountDto.getBalance());
		return account;
	}
	
	// Converts Accounts JPa entity into AccountDto  
	public static AccountDto mapToAccountDto(Account account) {
		AccountDto accountDto = new AccountDto(account.getId(),
				//passing values to the constructor
				account.getAccountHolderName(), account.getBalance());
		return accountDto;
	}
} 
