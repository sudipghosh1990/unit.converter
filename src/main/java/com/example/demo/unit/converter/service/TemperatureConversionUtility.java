package com.example.demo.unit.converter.service;

import com.example.demo.unit.converter.constants.TemperatureConstants;

public class TemperatureConversionUtility implements TemperatureConstants {
	
	public double convertTemperature(String fromUnit, String toUnit, double inputValue) {
		
		try {
			
			if(CELSIUS.equalsIgnoreCase(fromUnit) && FARENHEIT.equalsIgnoreCase(toUnit)) {
				return convertFromCelsiusToFarenheit(inputValue);
			} else if(FARENHEIT.equalsIgnoreCase(fromUnit) && CELSIUS.equalsIgnoreCase(toUnit)) {
				return convertFromFarenheitToCelsius(inputValue);
			} else if(CELSIUS.equalsIgnoreCase(fromUnit) && KELVIN.equalsIgnoreCase(toUnit)) {
				return convertFromCelsiusToKelvin(inputValue);
			} else if(KELVIN.equalsIgnoreCase(fromUnit) && CELSIUS.equalsIgnoreCase(toUnit)) {
				return convertFromKelvinToCelsius(inputValue);
			} else if(FARENHEIT.equalsIgnoreCase(fromUnit) && KELVIN.equalsIgnoreCase(toUnit)) {
				return convertFromFarenheitToKelvin(inputValue);
			} else if(KELVIN.equalsIgnoreCase(fromUnit) && FARENHEIT.equalsIgnoreCase(toUnit)) {
				return convertFromKelvinToFarenheit(inputValue);
			} else {
				return 0.0;
			}
			
		} catch(Throwable e) {
			e.printStackTrace();
			return 0.0;
		}
		
		
		
	}
	
	private double convertFromCelsiusToFarenheit(double celsius) {
		return ((celsius * 9)/5) + 32;
	}
	
	private double convertFromFarenheitToCelsius(double farenhite) {
		return ((farenhite - 32)*5)/9;
	}
	
	private double convertFromCelsiusToKelvin(double celsius) {
		return celsius + 273.15;
	}
	
	private double convertFromKelvinToCelsius(double kelvin) {
		return kelvin - 273.15;
	}
	
	private double convertFromFarenheitToKelvin(double farenhite) {
		return convertFromCelsiusToKelvin(convertFromFarenheitToCelsius(farenhite));
	}
	
	private double convertFromKelvinToFarenheit(double kelvin) {
		return convertFromCelsiusToFarenheit(convertFromKelvinToCelsius(kelvin));
	}

}
