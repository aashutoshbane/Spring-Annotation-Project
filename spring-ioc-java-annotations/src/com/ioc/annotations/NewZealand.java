package com.ioc.annotations;

import org.springframework.stereotype.Component;

@Component
public class NewZealand implements ICountry {

	/* (non-Javadoc)
	 * @see com.ioc.annotations.ICity#getCapital()
	 */
	@Override
	public String getCapital() {
		return "New Zealand's capital is Wellington";
	}

}
