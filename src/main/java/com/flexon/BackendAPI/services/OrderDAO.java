package com.flexon.BackendAPI.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.flexon.BackendAPI.models.Item;
import com.flexon.BackendAPI.models.Order;
import com.flexon.BackendAPI.repositories.OrderInterface;
import com.flexon.BackendAPI.utils.ConnSingleton;

@Component
public class OrderDAO implements OrderInterface {

	ConnSingleton cu = ConnSingleton.getConnSingleton();
	Connection conn = cu.getConnection();

	// Read Method --> Select an Order by OrderID
	public Order getOrderID(int orderID) {
		String sqlGetOrderID = "select * from bankDB.Orders where orderID = ?";
		Order currentOrder = new Order();
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlGetOrderID);
			prepStatement.setInt(1, orderID);
			ResultSet results = prepStatement.executeQuery();
			if (results.next() == false) 
				return null;
			
			while (results.next()) {
				int KeyID = results.getInt("KeyID");		
				int OrderID = results.getInt("orderID");
				boolean Accepted = results.getBoolean("Accepted");
				currentOrder.setKeyID(KeyID);
				currentOrder.setOrderID(OrderID);
				currentOrder.setAccepted(Accepted);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		// get all items associated with an order
		this.getItemsByOrderID(orderID, currentOrder);
		return currentOrder;
	}

	// Read Method --> Get all Items associated with an order and store it in
	// currentOrder's ArrayList
	private void getItemsByOrderID(int orderID, Order currentOrder) {
		String findItems = "select * from bankDB.Items where orderID = ?";
		currentOrder.Items.clear();
		try {
			PreparedStatement prepStatement = conn.prepareStatement(findItems);
			prepStatement.setInt(1, orderID);
			ResultSet results = prepStatement.executeQuery();
			while (results.next()) {
				// getters
				int KeyID = results.getInt("KeyID");
				String ItemName = results.getString("item_name");
				int Price = results.getInt("Price");
				int SKU = results.getInt("SKU");
				int Quantity = results.getInt("Quantity");
				int OrderID = results.getInt("orderID");
				// setters
				Item currentItem = new Item(KeyID, ItemName, Price, SKU, Quantity, OrderID, false);
				// add currentItem to currentOrder's arraylist
				currentOrder.Items.add(currentItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return;
	}

	// Update Method --> Accept an Order's ship date.
	public boolean acceptShipDate(int orderID) {
		String sqlAcceptShipDate = "update bankDB.Orders set Accepted = true where orderID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlAcceptShipDate);
			prepStatement.setInt(1, orderID);
			prepStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Update Method --> Delete a specific item from an order by orderID and KeyID.
	public boolean cancelItem(int orderID, int KeyID) {
		String sqlDeleteItem = "delete from bankDB.Items where orderID = ? and KeyID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlDeleteItem);
			prepStatement.setInt(1, orderID);
			prepStatement.setInt(2, KeyID);
			prepStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	// Delete Method --> Delete a specific order by orderID.
	public boolean cancelOrder(int orderID) {
		String sqlDeleteMethod = "delete from bankDB.Orders where orderID = ?";
		try {
			PreparedStatement prepStatement = conn.prepareStatement(sqlDeleteMethod);
			prepStatement.setInt(1, orderID);
			prepStatement.execute();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}