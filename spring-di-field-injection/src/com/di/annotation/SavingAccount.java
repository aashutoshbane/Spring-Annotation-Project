/**
 * 
 */
package com.di.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author Ashutosh Bane
 *
 */
@Component
public class SavingAccount implements IAccount {
	
	/**
	 * Java reflection is used behind the scene for
	 * field annotation
	 */
	@Autowired
	@Qualifier("accountInterest")
	private InterestService interestService;
	
	@Override
	public String createAccount() {
		return "Savings account created...!";
	}
	
	@Override
	public Integer getInterestRate(String type) {
		return this.interestService.getInterestRate(type);
	}

}
