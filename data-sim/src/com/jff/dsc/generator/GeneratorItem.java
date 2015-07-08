package com.jff.dsc.generator;

import java.util.ArrayList;
import java.util.List;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public abstract class GeneratorItem {

	protected final String id;
	protected final Expression exp;
	protected final List<GeneratorItem> subscribers = new ArrayList<GeneratorItem>();

	protected GeneratorItem(final String id, final String formula, final String[] variables) {
		this.id = id;
		this.exp = new ExpressionBuilder(formula).variables(variables).build();
	}

	public abstract void notify(final String depId, final double value);

	protected void generate() {
		double evaluate = exp.evaluate();
		System.out.println(id + "= " + evaluate);

		if (!subscribers.isEmpty()) {
			for (GeneratorItem sbsr : subscribers) {
				sbsr.notify(id, evaluate);
			}
		}
	}

	public void addSubscriber(final GeneratorItem subscriber) {
		subscribers.add(subscriber);
	}
}
