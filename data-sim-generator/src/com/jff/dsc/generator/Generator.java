package com.jff.dsc.generator;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class Generator {

	Logger LOG = Logger.getLogger(Generator.class.getName());

	private Map<String, GeneratorItem> independentNodes = new HashMap<String, GeneratorItem>();
	private Map<String, GeneratorItem> dependentNodes = new HashMap<String, GeneratorItem>();

	public void addNode(String id, String formula, String[] variables) {
		LOG.entering(Generator.class.getName(), "addNode", "(id:" + id + ", formula:" + formula + ", variables:" + variables + ")");
		if (variables == null) {
			independentNodes.put(id, new IndependentNode(id, formula, "step"));
		} else {
			GeneratorItem node = new DependentNode(id, formula, variables);
			for (String rel : variables) {
				if (independentNodes.containsKey(rel)) {
					independentNodes.get(rel).addSubscriber(node);
				} else if (dependentNodes.containsKey(rel)) {
					dependentNodes.get(rel).addSubscriber(node);
				}
			}
			dependentNodes.put(id, node);
		}
		LOG.exiting(Generator.class.getName(), "addNode");
	}

	public void generate(int lenght) {
		LOG.entering(Generator.class.getName(), "generate", "[lenght: " + lenght + "]");
		for (int i = 0; i < lenght; i++) {
			for (GeneratorItem node : independentNodes.values()) {
				node.notify("step", i);
			}
		}
		LOG.exiting(Generator.class.getName(), "generate");
	}
}
