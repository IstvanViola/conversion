package com.viola.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.viola.model.GetRates;

@Repository
public class GetRateDAO implements GetRateDAORepository  {
	
	String databaseURL = "jdbc:mysql://localhost:3306/rates";
	String user = "root";
    String password = "Cranfield11";
	
    //fill the list with data from database
    
    @Override
    public List<GetRates> list() {
        List<GetRates> listGetRate = new ArrayList<>();
        
         
        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
            String sql = "SELECT * FROM rates";
            Statement statement = (Statement) connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
             
            while (result.next()) {
                int id = result.getInt("id");
                String currency = result.getString("currency");
                int sell = result.getInt("sell");
                int buy = result.getInt("buy");
                GetRates getRates = new GetRates(id, currency, sell, buy);
                     
                listGetRate.add(getRates);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            
        }      
         
        return listGetRate;
    }


}
