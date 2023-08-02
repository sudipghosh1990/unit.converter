package com.example.demo.unit.converter.request.response;

public class ConversionMetaDataModificationRequest {
	
	private String username;
	private String password;
	private String unitType;
	private String fromUnit;
	private String toUnit;
	private double conversionFactor;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
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
	public double getConversionFactor() {
		return conversionFactor;
	}
	public void setConversionFactor(double conversionFactor) {
		this.conversionFactor = conversionFactor;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConversionMetaDataModificationRequest [username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", unitType=");
		builder.append(unitType);
		builder.append(", fromUnit=");
		builder.append(fromUnit);
		builder.append(", toUnit=");
		builder.append(toUnit);
		builder.append(", conversionFactor=");
		builder.append(conversionFactor);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
