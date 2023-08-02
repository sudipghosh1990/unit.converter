package com.example.demo.unit.converter.request.response;

public class UnitConversionProcessingRequest {
	
	private String inputConversionUnit;
	private double inputConversionValue;
	private String outputConversionUnit;
	private String username;
	private String password;
	
	public String getInputConversionUnit() {
		return inputConversionUnit;
	}
	public void setInputConversionUnit(String inputConversionUnit) {
		this.inputConversionUnit = inputConversionUnit;
	}
	public double getInputConversionValue() {
		return inputConversionValue;
	}
	public void setInputConversionValue(double inputConversionValue) {
		this.inputConversionValue = inputConversionValue;
	}
	public String getOutputConversionUnit() {
		return outputConversionUnit;
	}
	public void setOutputConversionUnit(String outputConversionUnit) {
		this.outputConversionUnit = outputConversionUnit;
	}
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UnitConversionProcessingRequest [inputConversionUnit=");
		builder.append(inputConversionUnit);
		builder.append(", inputConversionValue=");
		builder.append(inputConversionValue);
		builder.append(", outputConversionUnit=");
		builder.append(outputConversionUnit);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}
	
	

}
