package com.pkr.blogic;

import com.pkr.exceptions.*;

public interface Bank {
	void deposit(double amount) throws InvalidAmountException;

	double withdraw(double amount) throws InsufficientFundsException;

	void balanceEnquiry();
}
