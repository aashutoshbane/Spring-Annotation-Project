/**
 * 
 */
package com.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Ashutosh Bane
 *
 */
@Component
public class SavingAccount implements IAccount {
	
	private InterestService interestService;
	
	@Autowired
	public SavingAccount(InterestService theInterestService) {
		this.interestService = theInterestService;
	}
	
	@Override
	public String createAccount() {
		return "Savings account created...!";
	}
	
	@Override
	public Integer getInterestRate() {
		return this.interestService.getInterestRate("savings");
	}

}
