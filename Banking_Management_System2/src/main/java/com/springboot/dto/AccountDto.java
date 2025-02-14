package com.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {	//DTOs are often used to transfer data between the server and the client. 
	
	private Long id;
	private String accountHolderName;
	private double balance;
}
