package com.flexon.BackendAPI.repositories;

import com.flexon.BackendAPI.models.Order;

public interface OrderInterface {

	public Order getOrderID(int orderID);

	public boolean acceptShipDate(int orderID);

	public boolean cancelItem(int orderID, int ItemNumber);

	public boolean cancelOrder(int orderID);

}
