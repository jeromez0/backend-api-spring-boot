package com.flexon.BackendAPI.models;

public class Item {

	int KeyID;
	String Name;
	double Price;
	int SKU;
	int Quantity;
	int orderID;
	boolean catalog;

	public Item(int KeyID, String Name, double Price, int SKU, int Quantity, int orderID, boolean catalog) {
		this.KeyID = KeyID;
		this.Name = Name;
		this.Price = Price;
		this.SKU = SKU;
		this.Quantity = Quantity;
		this.orderID = orderID;
		this.catalog = catalog;
	}

	public Item() {
		super();
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public int getKeyID() {
		return KeyID;
	}

	public void setKeyID(int keyID) {
		KeyID = keyID;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	public int getSKU() {
		return SKU;
	}

	public void setSKU(int sKU) {
		SKU = sKU;
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public boolean isCatalog() {
		return catalog;
	}

	public void setCatalog(boolean catalog) {
		this.catalog = catalog;
	}

}
