package com.example.demo.unit.converter.metaeta;

import java.util.Objects;

public class ConversionMetaDataKey {
	
	private String unitType;
	private String fromUnit;
	
	public ConversionMetaDataKey(String unitType, String fromUnit) {
		super();
		this.unitType = unitType;
		this.fromUnit = fromUnit;
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

	@Override
	public int hashCode() {
		return Objects.hash(fromUnit.toLowerCase(), unitType.toLowerCase());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConversionMetaDataKey other = (ConversionMetaDataKey) obj;
		return Objects.equals(fromUnit.toLowerCase(), other.fromUnit.toLowerCase()) && Objects.equals(unitType.toLowerCase(), other.unitType.toLowerCase());
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ConversionMetaDataKey [unitType=");
		builder.append(unitType);
		builder.append(", fromUnit=");
		builder.append(fromUnit);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
