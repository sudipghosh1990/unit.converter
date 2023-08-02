package com.example.demo.unit.converter.request.response;

public class UnitConversionProcessingResponse {
	
	private String inputConversionUnit;
	private double inputConversionValue;
	private String outputConversionUnit;
	private double outputConvertedValue;
	private String responseStatus;
	
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
	public double getOutputConvertedValue() {
		return outputConvertedValue;
	}
	public void setOutputConvertedValue(double outputConvertedValue) {
		this.outputConvertedValue = outputConvertedValue;
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
		builder.append("UnitConversionResponse [inputConversionUnit=");
		builder.append(inputConversionUnit);
		builder.append(", inputConversionValue=");
		builder.append(inputConversionValue);
		builder.append(", outputConversionUnit=");
		builder.append(outputConversionUnit);
		builder.append(", outputConvertedValue=");
		builder.append(outputConvertedValue);
		builder.append(", responseStatus=");
		builder.append(responseStatus);
		builder.append("]");
		return builder.toString();
	}
	
	

}
