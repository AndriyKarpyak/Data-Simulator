package com.jff.dsc;

import java.io.IOException;

import com.jff.dsc.generator.Generator;

public class DataSim {

	public static void main(String[] args) throws IOException {
		Generator gen = new Generator();
		gen.addNode("ind", "step", null);
		gen.addNode("dep", "ind * 2", new String[] { "ind" });
		gen.addNode("dobdep", "ind * dep * 2", new String[] { "ind", "dep" });
			gen.generate(10);
	}
}
