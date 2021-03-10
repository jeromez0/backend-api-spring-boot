package com.flexon.BackendAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flexon.BackendAPI.models.Item;
import com.flexon.BackendAPI.models.Order;
import com.flexon.BackendAPI.services.CatalogDAO;
import com.flexon.BackendAPI.services.OrderDAO;

@RestController
public class UserAccountController {

	@Autowired
	OrderDAO orderDAO = new OrderDAO();
	CatalogDAO catalogDAO = new CatalogDAO();

	@GetMapping(path = "/order/{orderID}")
	public Order getOrder(@PathVariable int orderID) {
		return orderDAO.getOrderID(orderID);
	}
	
	@RequestMapping(path = "/orderactions/acceptShipDate/{orderID}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void acceptShipDate(@PathVariable int orderID) {
		orderDAO.acceptShipDate(orderID);
	}

	@RequestMapping(path = "/orderactions/cancelOrder/{orderID}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void cancelOrder(@PathVariable int orderID) {
		orderDAO.cancelOrder(orderID);
	}

	@RequestMapping(path = "/orderactions/cancelItem/{orderID}/{ItemNumber}", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void cancelItem(@PathVariable int orderID, @PathVariable int ItemNumber) {
		orderDAO.cancelItem(orderID, ItemNumber);
	}

	@GetMapping(path = "/catalog/sku/{skuId}")
	public Item getSKU(@PathVariable int skuId) {
		return catalogDAO.getSKU(skuId);
	}

}