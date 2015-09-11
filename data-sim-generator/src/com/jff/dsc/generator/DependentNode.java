package com.jff.dsc.generator;

public class DependentNode extends GeneratorItem {

	private final int dependenciesCount;
	private int notificationsCount = 0;

	public DependentNode(final String id, final String formula, final String[] variables) {
		super(id, formula, variables);
		this.dependenciesCount = variables.length;
	}

	public void notify(final String depId, final double value) {
		exp.setVariable(depId, value);
		if (dependenciesCount == ++notificationsCount) {
			notificationsCount = 0;
			generate();
		}
	}
}
