package com.viola.services;


public interface ConversionService {

	public int ConversionConvertToHUF(int amount, int buy);
	 
	public int ConversionConvertFromHUF(int amount, int sell);
	
	public int Conversion(int amount, int buy, int sell);
	
}
