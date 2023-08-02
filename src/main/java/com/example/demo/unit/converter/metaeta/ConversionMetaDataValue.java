package com.example.demo.unit.converter.metaeta;

public class ConversionMetaDataValue {
	
	private String unitType;
	private double conversionFactor;
	
	public ConversionMetaDataValue(String unitType, double conversionFactor) {
		super();
		this.unitType = unitType;
		this.conversionFactor = conversionFactor;
	}
	
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
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
		builder.append("ConversionMetaDataValue [unitType=");
		builder.append(unitType);
		builder.append(", conversionFactor=");
		builder.append(conversionFactor);
		builder.append("]");
		return builder.toString();
	}
	
	

}
