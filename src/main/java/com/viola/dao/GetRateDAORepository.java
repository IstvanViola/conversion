package com.viola.dao;

import java.util.List;

//defines the repository with read operation from database (list), it is implemented by GetRateDAO

import com.viola.model.GetRates;

public interface GetRateDAORepository {
	
	 public List<GetRates> list();

}
