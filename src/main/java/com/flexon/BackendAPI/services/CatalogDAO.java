package com.flexon.BackendAPI.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.flexon.BackendAPI.models.Item;
import com.flexon.BackendAPI.repositories.CatalogInterface;
import com.flexon.BackendAPI.utils.ConnSingleton;

public class CatalogDAO implements CatalogInterface{
	
	ConnSingleton cu = ConnSingleton.getConnSingleton();
	Connection conn = cu.getConnection();
	
	public Item getSKU(int SKU) {
		String getItem = "select * from bankDB.Items where SKU = ?";		
		try {
			PreparedStatement prepStatement = conn.prepareStatement(getItem);
			prepStatement.setInt(1, SKU);
			ResultSet results = prepStatement.executeQuery();
			while (results.next()) {			
				// getters
				int KeyID = results.getInt("KeyID");
				String ItemName = results.getString("item_name");
				int Price = results.getInt("Price");
				int Quantity = results.getInt("Quantity");
				int OrderID = results.getInt("orderID");
				// setters
				Item currentItem = new Item(KeyID, ItemName, Price, SKU, Quantity, OrderID, false);
				return currentItem;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
