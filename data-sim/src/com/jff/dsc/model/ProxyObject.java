package com.jff.dsc.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import com.jff.dsc.provider.Provider;

public class ProxyObject {

	private final String id;
	private final Map<String, Provider> signature = new LinkedHashMap<String, Provider>();

	public ProxyObject(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}
	
	public void addField(String name, Provider dataProvider) {
		signature.put(name, dataProvider);
	}

	public Set<String> getSignature() {
		return signature.keySet();
	}
	
	public String getFieldValue(String name) {
		return signature.get(name).getValue();
	}
}
