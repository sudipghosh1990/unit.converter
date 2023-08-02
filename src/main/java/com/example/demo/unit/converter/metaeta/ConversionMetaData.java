package com.example.demo.unit.converter.metaeta;

import java.util.Objects;

public class ConversionMetaData {
	
	private String unitType;
	private String fromUnit;
	private String toUnit;
	private double conversionFactor;
	
	public ConversionMetaData(String unitType, String fromUnit, String toUnit, double conversionFactor) {
		super();
		this.unitType = unitType;
		this.fromUnit = fromUnit;
		this.toUnit = toUnit;
		this.conversionFactor = conversionFactor;
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
		builder.append("ConversionMetaData [unitType=");
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

	@Override
	public int hashCode() {
		return Objects.hash(fromUnit.toLowerCase(), toUnit.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConversionMetaData other = (ConversionMetaData) obj;
		return Objects.equals(fromUnit.toLowerCase(), other.fromUnit.toLowerCase()) && Objects.equals(toUnit.toLowerCase(), other.toUnit.toLowerCase());
	}
	
	
	
	

}
