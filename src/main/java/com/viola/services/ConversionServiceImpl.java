package com.viola.services;

import org.springframework.stereotype.Service;

// logic of conversion

@Service
public class ConversionServiceImpl implements ConversionService {
	
	@Override
	public int ConversionConvertToHUF(int amount, int buy) {
		return amount * buy;
	}
	 @Override
	 public int ConversionConvertFromHUF(int amount, int sell) {
		 return amount * sell;
	 }
	 
	 @Override
	 public int Conversion(int amount, int buy, int sell){
		 int huf = amount * buy;
		 int convertedAmount = huf / sell;
		 return convertedAmount;
	 }
	 
	 

}
