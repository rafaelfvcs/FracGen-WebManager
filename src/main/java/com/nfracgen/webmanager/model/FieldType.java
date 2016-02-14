package com.nfracgen.webmanager.model;

public enum FieldType {
	/**
	 * Field types
	 */
	COLDATA("Data Collect"), 
	MON("Monitoring"),
	RECGNI("Field Recognition"),
	DIDA("Didatic");
	
	private String description;

	FieldType(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
}
