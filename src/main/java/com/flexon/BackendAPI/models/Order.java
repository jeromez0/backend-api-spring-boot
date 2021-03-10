package com.flexon.BackendAPI.models;

import java.util.ArrayList;

public class Order {

	int KeyID;
	int orderID;
	String ShipDate;
	boolean Accepted;
	boolean Deleted;
	public ArrayList<Item> Items = new ArrayList<Item>();

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [KeyID=" + KeyID + ", orderID=" + orderID + ", ShipDate=" + ShipDate + ", Accepted=" + Accepted
				+ ", Deleted=" + Deleted + ", Items=" + Items + "]";
	}

	public int getKeyID() {
		return KeyID;
	}

	public void setKeyID(int keyID) {
		KeyID = keyID;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public String getShipDate() {
		return ShipDate;
	}

	public void setShipDate(String shipDate) {
		ShipDate = shipDate;
	}

	public boolean isAccepted() {
		return Accepted;
	}

	public void setAccepted(boolean accepted) {
		Accepted = accepted;
	}

	public boolean isDeleted() {
		return Deleted;
	}

	public void setDeleted(boolean deleted) {
		Deleted = deleted;
	}

}