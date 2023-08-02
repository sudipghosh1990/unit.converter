package com.example.demo.unit.converter.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.unit.converter.constants.ResponseMessageConstants;
import com.example.demo.unit.converter.constants.TemperatureConstants;
import com.example.demo.unit.converter.metaeta.ConversionMetaData;
import com.example.demo.unit.converter.metaeta.ConversionMetaDataKey;
import com.example.demo.unit.converter.metaeta.ConversionMetaDataValue;
import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationRequest;
import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationResponse;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingRequest;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingResponse;

@Service
public class UnitConversionUtility implements TemperatureConstants, ResponseMessageConstants {
	
	// TO DO
	// Input validation logic to be added
	private boolean valdiateInput(ConversionMetaData conversionMetaData) {
		return true;
	}
	
	// This method reads the "From" and "To" Unit and the value of "From" unit to be converted from request and do the required conversion.
	public void addNewConversionMetaData(ConversionMetaDataModificationRequest request, ConversionMetaDataModificationResponse response) {
		
		try {
			
			ConversionMetaData conversionMetaData = new ConversionMetaData(request.getUnitType(), request.getFromUnit(), request.getToUnit(), request.getConversionFactor());
			
			if(valdiateInput(conversionMetaData)) {
				
				if(!isConversionMetaDataModificationRelatedToTemperature(request)) {
					
					Map<ConversionMetaDataKey, ConversionMetaDataValue> conversionMetadataMap = UnitConversionMetaDataCache.getInstance().getConversionMetaDataMap();
					
					if(conversionMetadataMap.containsKey(new ConversionMetaDataKey(conversionMetaData.getFromUnit(), conversionMetaData.getToUnit()))) {
						response.setResponseStatus(META_DATA_EXISTS);
					} else {
						
						if((long)(conversionMetaData.getConversionFactor() * 10000000) != 0) {
							conversionMetadataMap.put(new ConversionMetaDataKey(conversionMetaData.getFromUnit(), conversionMetaData.getToUnit()), new ConversionMetaDataValue(conversionMetaData.getUnitType(), conversionMetaData.getConversionFactor()));
							conversionMetadataMap.put(new ConversionMetaDataKey(conversionMetaData.getToUnit(), conversionMetaData.getFromUnit()), new ConversionMetaDataValue(conversionMetaData.getUnitType(), 1 /conversionMetaData.getConversionFactor()));
							// TO DO
							// When using database, this is to be also added in the database table to persist it
							response.setUnitType(request.getUnitType());
							response.setFromUnit(request.getFromUnit());
							response.setToUnit(request.getToUnit());
							response.setResponseStatus(META_DATA_ADDED);
						} else {
							response.setResponseStatus(CONVERSION_FACTOR_ZERO);
						}
						
					}
					
				} else {
					response.setResponseStatus(META_DATA_ADDITION_TEMPERATURE);
				}		
				
			} else {
				response.setResponseStatus(INVALID_INPUT);			
			}		
			
		} catch(Throwable e) {
			response.setResponseStatus(META_DATA_ADDITION_FAILED);
			e.printStackTrace();
		}
		
		
		
		

	}
	
	// TO DO
	// Input validation logic to be added
	private boolean validateInputforUnitConversionProcessing(UnitConversionProcessingRequest request) {
		return true;
	}
	
	//This method does the unit conversion using conversion meta data
	public void convertBetweenUnits(UnitConversionProcessingRequest request, UnitConversionProcessingResponse response) {
		try {
			
			if(validateInputforUnitConversionProcessing(request)) {
				
				if(isConversionTypeTemperature(request)) {
					TemperatureConversionUtility temperatureConversionUtility = new TemperatureConversionUtility();
					response.setInputConversionUnit(request.getInputConversionUnit());
					response.setInputConversionValue(request.getInputConversionValue());
					response.setOutputConversionUnit(request.getOutputConversionUnit());
					response.setOutputConvertedValue(temperatureConversionUtility.convertTemperature(request.getInputConversionUnit(), request.getOutputConversionUnit(), request.getInputConversionValue()));
					response.setResponseStatus(UNIT_CONVERSION_SUCCESS);
					
				} else {
					
					Map<ConversionMetaDataKey, ConversionMetaDataValue> conversionMetadataMap = UnitConversionMetaDataCache.getInstance().getConversionMetaDataMap();
					ConversionMetaDataKey inputKey = new ConversionMetaDataKey(request.getInputConversionUnit(), request.getOutputConversionUnit());
					
					if(conversionMetadataMap.containsKey(inputKey)) {
						double convertedValue = 0.0;
						convertedValue = request.getInputConversionValue() * conversionMetadataMap.get(inputKey).getConversionFactor();
						response.setInputConversionUnit(request.getInputConversionUnit());
						response.setInputConversionValue(request.getInputConversionValue());
						response.setOutputConversionUnit(request.getOutputConversionUnit());
						response.setOutputConvertedValue(convertedValue);
						response.setResponseStatus(UNIT_CONVERSION_SUCCESS);
					} else {
						response.setResponseStatus(META_DATA_NOT_FOUND);
					}
					
				}
				
				
				
			} else {
				response.setResponseStatus(INVALID_INPUT);
			}
			
		} catch(Throwable e) {
			response.setResponseStatus(UNIT_CONVERSION_FAILED);
			e.printStackTrace();
		}
		
	}
	
	public Map<ConversionMetaDataKey, ConversionMetaDataValue> getAllConversionMetaData(){
		return UnitConversionMetaDataCache.getInstance().getConversionMetaDataMap();
	}
	
	private boolean isConversionTypeTemperature(UnitConversionProcessingRequest request) {
		if( (KELVIN.equalsIgnoreCase(request.getInputConversionUnit()) || CELSIUS.equalsIgnoreCase(request.getInputConversionUnit()) || FARENHEIT.equalsIgnoreCase(request.getInputConversionUnit()))
				&&  (KELVIN.equalsIgnoreCase(request.getOutputConversionUnit()) || CELSIUS.equalsIgnoreCase(request.getOutputConversionUnit()) || FARENHEIT.equalsIgnoreCase(request.getOutputConversionUnit()))
				&& (!request.getInputConversionUnit().equalsIgnoreCase(request.getOutputConversionUnit()))) {
			return true;
		} else{
			return false;
		} 
	}
	
	private boolean isConversionMetaDataModificationRelatedToTemperature(ConversionMetaDataModificationRequest request) {
		if( (KELVIN.equalsIgnoreCase(request.getFromUnit()) || CELSIUS.equalsIgnoreCase(request.getFromUnit()) || FARENHEIT.equalsIgnoreCase(request.getFromUnit()))
				||  (KELVIN.equalsIgnoreCase(request.getToUnit()) || CELSIUS.equalsIgnoreCase(request.getToUnit()) || FARENHEIT.equalsIgnoreCase(request.getToUnit()))
				|| (TEMPERATURE.equalsIgnoreCase(request.getUnitType()))) {
			return true;
		} else{
			return false;
		} 

	}
	
	public long convertToLongWithFourDecimalPlaces(double value) {
		
		value = value * 10000;
		return (long) value;
		
	}

}
