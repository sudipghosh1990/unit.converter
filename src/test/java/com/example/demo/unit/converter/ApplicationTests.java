package com.example.demo.unit.converter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationRequest;
import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationResponse;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingRequest;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingResponse;
import com.example.demo.unit.converter.service.UnitConversionUtility;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	UnitConversionUtility unitConversionUtility;
	
	@Test
	public void testConversionMetaDataAddition() {
		ConversionMetaDataModificationRequest request = new ConversionMetaDataModificationRequest();
		request.setFromUnit("SquareMeter");
		request.setToUnit("SquareFoot");
		request.setConversionFactor(10.7639);
		request.setUnitType("Area");
		request.setUsername("");
		request.setPassword("");
		ConversionMetaDataModificationResponse response = new ConversionMetaDataModificationResponse();
		unitConversionUtility.addNewConversionMetaData(request, response);
		assertEquals("Unit conversion metadata added successfully", response.getResponseStatus());
	}
	
	@Test
	public void testUnitConversion() {
		UnitConversionProcessingRequest request = new UnitConversionProcessingRequest();
		request.setInputConversionUnit("Meter");
		request.setInputConversionValue(15);
		request.setOutputConversionUnit("Foot");
		request.setUsername("");
		request.setPassword("");
		UnitConversionProcessingResponse response = new UnitConversionProcessingResponse();
		unitConversionUtility.convertBetweenUnits(request, response);
		assertEquals(492120, unitConversionUtility.convertToLongWithFourDecimalPlaces(response.getOutputConvertedValue()));
	}
	
	@Test
	public void testUnitConversionForTemperature() {
		UnitConversionProcessingRequest request = new UnitConversionProcessingRequest();
		request.setInputConversionUnit("Celsius");
		request.setInputConversionValue(46.93);
		request.setOutputConversionUnit("Farenheit");
		request.setUsername("");
		request.setPassword("");
		UnitConversionProcessingResponse response = new UnitConversionProcessingResponse();
		unitConversionUtility.convertBetweenUnits(request, response);
		assertEquals(1164740, unitConversionUtility.convertToLongWithFourDecimalPlaces(response.getOutputConvertedValue()));
	}

}
