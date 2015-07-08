package com.jff.dsc.generator;


public class IndependentNode extends GeneratorItem {

	public IndependentNode(final String id, final String formula, final String variable) {
		super(id, formula, new String[] { variable });
	}

	public void notify(final String depId, final double value) {
		exp.setVariable(depId, value);
		generate();
	}
}
