package com.ioc.annotations;

import org.springframework.stereotype.Component;

/**
 * @author Ashutosh Bane
 *
 */
@Component("theIndia")
public class India implements ICountry {

	/* (non-Javadoc)
	 * @see com.ioc.annotations.ICity#getCapital()
	 */
	@Override
	public String getCapital() {
		return "India's capital is New Delhi";
	}

}
