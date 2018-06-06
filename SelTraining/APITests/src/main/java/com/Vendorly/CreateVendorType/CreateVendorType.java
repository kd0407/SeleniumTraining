package com.Vendorly.CreateVendorType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateVendorType {
	private String type;
	private String description;
	private String inactive;
	private List<InclusiveVendorType> inclusiveVendorTypes;
	

	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInactive() {
		return inactive;
	}
	public void setInactive(String inactive) {
		this.inactive = inactive;
	}
	public List<InclusiveVendorType> getInclusiveVendorTypes() {
		return inclusiveVendorTypes;
	}
	public void setInclusiveVendorTypes(List<InclusiveVendorType> inclusiveVendorTypes) {
		this.inclusiveVendorTypes = inclusiveVendorTypes;
	}
	


}
