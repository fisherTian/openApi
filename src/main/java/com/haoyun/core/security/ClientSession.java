package com.haoyun.core.security;

import java.io.Serializable;
import java.util.HashMap;

public class ClientSession implements Serializable {

	private static final long serialVersionUID = 1L;

	private HashMap<String, Object> attributes = new HashMap<String, Object>();

	public void addAttribute(String key, Object value) {
		attributes.put(key, value);
	}

	public void removeAttribute(String key) {
		attributes.remove(key);
	}

	public Object getAttribute(String key) {
		return attributes.get(key);
	}

	public HashMap<String, Object> getAttributes() {
		return attributes;
	}

	public void setAttributes(HashMap<String, Object> attributes) {
		this.attributes = attributes;
	}

}
