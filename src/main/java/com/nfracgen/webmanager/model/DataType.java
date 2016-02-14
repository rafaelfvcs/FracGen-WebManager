package com.nfracgen.webmanager.model;

public enum DataType {
	
	SCL("Scanline data"), 
	GPR("GPR data");

	
	private String data;

	DataType(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}

}
