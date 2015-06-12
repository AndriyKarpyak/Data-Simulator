package com.jff.dsc.provider;

import com.jff.dsc.generator.Generator;

public class GeneratedValueProviderImpl implements Provider {

	private final Generator generator;

	public GeneratedValueProviderImpl(Generator generator) {
		this.generator = generator;
	}

	@Override
	public String getValue() {
		return generator.generate();
	}
	
	
}
