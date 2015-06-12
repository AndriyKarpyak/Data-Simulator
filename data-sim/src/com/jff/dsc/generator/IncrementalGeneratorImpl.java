package com.jff.dsc.generator;

public class IncrementalGeneratorImpl implements Generator {

	private int value = 0;
	
	@Override
	public String generate() {
		return String.valueOf(value++);
	}

}
