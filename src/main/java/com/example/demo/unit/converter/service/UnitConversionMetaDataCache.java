package com.example.demo.unit.converter.service;

import java.util.HashMap;
import java.util.Map;

import com.example.demo.unit.converter.metaeta.ConversionMetaDataKey;
import com.example.demo.unit.converter.metaeta.ConversionMetaDataValue;

// Cache for holding metadata at run time
public class UnitConversionMetaDataCache {
	
	private Map<ConversionMetaDataKey, ConversionMetaDataValue> conversionMetadataMap = new HashMap<ConversionMetaDataKey, ConversionMetaDataValue>();
	
	private static UnitConversionMetaDataCache unitConversionMetaDataCache = null;
	
	private UnitConversionMetaDataCache() {
		
		// hard coded predefined metadata inside code
		loadInitialConversionMetaData();
		
		// TO DO
//		loadInitialConversionMetaDataFromDatabase();
		
	}
	
	public static UnitConversionMetaDataCache getInstance() {
		if(unitConversionMetaDataCache == null) {
			synchronized(UnitConversionMetaDataCache.class) {
				if(unitConversionMetaDataCache == null) {
					unitConversionMetaDataCache = new UnitConversionMetaDataCache();
				}
			}
		}
		return unitConversionMetaDataCache;
	}
	
	public Map<ConversionMetaDataKey, ConversionMetaDataValue> getConversionMetaDataMap(){
		return this.conversionMetadataMap;
	}
	
	public void loadInitialConversionMetaData() {
		
		conversionMetadataMap.put(new ConversionMetaDataKey("Meter", "Foot"), new ConversionMetaDataValue("Length", 3.2808));
		conversionMetadataMap.put(new ConversionMetaDataKey("Foot", "Meter"), new ConversionMetaDataValue("Length", 0.3048));
		
		conversionMetadataMap.put(new ConversionMetaDataKey("Centimeter", "Inch"), new ConversionMetaDataValue("Length", .3937));
		conversionMetadataMap.put(new ConversionMetaDataKey("Inch", "Centimeter"), new ConversionMetaDataValue("Length", 2.54));
		
		conversionMetadataMap.put(new ConversionMetaDataKey("Kg", "Pound"), new ConversionMetaDataValue("Mass", 2.2046));
		conversionMetadataMap.put(new ConversionMetaDataKey("Pound", "Kg"), new ConversionMetaDataValue("Mass", .4535));
	}
	
	// TO DO
	public void loadInitialConversionMetaDataFromDatabase() {
		
	}
	

}
