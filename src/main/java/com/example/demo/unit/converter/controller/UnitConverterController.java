package com.example.demo.unit.converter.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.unit.converter.constants.ResponseMessageConstants;
import com.example.demo.unit.converter.metaeta.ConversionMetaDataKey;
import com.example.demo.unit.converter.metaeta.ConversionMetaDataValue;
import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationRequest;
import com.example.demo.unit.converter.request.response.ConversionMetaDataModificationResponse;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingRequest;
import com.example.demo.unit.converter.request.response.UnitConversionProcessingResponse;
import com.example.demo.unit.converter.service.UnitConversionUtility;

@RestController
public class UnitConverterController implements ResponseMessageConstants {
	
	@Autowired
	UnitConversionUtility unitConversionUtility;
	
	// List all conversion metadata information
	@GetMapping("/UnitConversion/ListAllConversionMetaData")
	public Map<ConversionMetaDataKey, ConversionMetaDataValue> getAllConversionMetaData(){
		return unitConversionUtility.getAllConversionMetaData();
				
	}
	
	// add new conversion metadata info
	@PostMapping("/UnitConversion/AddNewConversionMetaData")
	public @ResponseBody ConversionMetaDataModificationResponse addNewConverisonMetaData(@RequestBody ConversionMetaDataModificationRequest request) {
		
		ConversionMetaDataModificationResponse response = new ConversionMetaDataModificationResponse();
		System.out.println(request);
		
		try {
			
			if(request != null) {
				unitConversionUtility.addNewConversionMetaData(request,response);	
			} else {
				response.setResponseStatus(REQUEST_CAN_NOT_BE_NULL);
			}
			
		} catch(Throwable e) {
			response.setResponseStatus(ERROR_WHILE_PROCESSING_REQUEST);
			e.printStackTrace();
		}
		
		System.out.println(response);
		return response;
	}
	
	// Convert between units using metadata
	@PostMapping("/UnitConversion/convertBetweenUnits")
	public @ResponseBody UnitConversionProcessingResponse convertBetweenUnits(@RequestBody UnitConversionProcessingRequest request) {
		
		UnitConversionProcessingResponse response = new UnitConversionProcessingResponse();
		System.out.println(request);
		
		try {
			
			if(request != null) {
				unitConversionUtility.convertBetweenUnits(request, response);
			} else {
				response.setResponseStatus(REQUEST_CAN_NOT_BE_NULL);
			}
			
		} catch(Throwable e) {
			response.setResponseStatus(ERROR_WHILE_PROCESSING_REQUEST);
			e.printStackTrace();
		}
		
		System.out.println(response);
		return response;
		
	}

}
