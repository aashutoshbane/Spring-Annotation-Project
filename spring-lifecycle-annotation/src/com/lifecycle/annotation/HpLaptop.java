package com.lifecycle.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope
public class HpLaptop implements ILaptop {

	@Override
	public String getConfiguration() {
		return "This is 4GB RAM, i5 intel processor, 1TB Hard Disk";
	}

}
