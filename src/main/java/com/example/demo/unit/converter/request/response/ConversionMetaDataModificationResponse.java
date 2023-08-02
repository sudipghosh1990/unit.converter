package com.example.demo.unit.converter.request.response;

public class ConversionMetaDataModificationResponse {
	
	private String unitType;
	private String fromUnit;
	private String toUnit;
	private String responseStatus;
	
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getFromUnit() {
		return fromUnit;
	}
	public void setFromUnit(String fromUnit) {
		this.fromUnit = fromUnit;
	}
	public String getToUnit() {
		return toUnit;
	}
	public void setToUnit(String toUnit) {
		this.toUnit = toUnit;
	}
	public String getResponseStatus() {
		return responseStatus;
	}
	public void setResponseStatus(String responseStatus) {
		this.responseStatus = responseStatus;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConversionMetaDataModificationResponse [unitType=");
		builder.append(unitType);
		builder.append(", fromUnit=");
		builder.append(fromUnit);
		builder.append(", toUnit=");
		builder.append(toUnit);
		builder.append(", responseStatus=");
		builder.append(responseStatus);
		builder.append("]");
		return builder.toString();
	}
	
	

}
