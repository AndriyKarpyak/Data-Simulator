package com.jff.dsc.provider;

public class PassedValueProviderImpl implements Provider {

	private final String transferValue;

	public PassedValueProviderImpl(String transferValue) {
		super();
		this.transferValue = transferValue;
	}

	@Override
	public String getValue() {
		return transferValue;
	}

}
