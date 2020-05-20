package com.di.annotation;

import org.springframework.stereotype.Component;

@Component
public class LoanInterest implements InterestService {

	private int homeLoanRate;
	private int carLoanRate;

	public LoanInterest() {
		this.homeLoanRate = 8;
		this.carLoanRate = 12;
	}

	@Override
	public Integer getInterestRate(String accountType) {
		int rate;

		switch (accountType) {
		case "homeloan":
			rate = this.homeLoanRate;
			break;
		case "carloan":
			rate = this.carLoanRate;
			break;
		default:
			throw new Error("Unknown type passed");
		}

		return rate;
	}

}
