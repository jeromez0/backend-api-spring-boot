package com.flexon.BackendAPI;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.flexon.BackendAPI.services.CatalogDAO;
import com.flexon.BackendAPI.services.OrderDAO;
import com.flexon.BackendAPI.utils.ConnSingleton;
import com.flexon.BackendAPI.models.Item;
import com.flexon.BackendAPI.models.Order;

@SpringBootTest
class BackendApiApplicationTests {

	ConnSingleton cu = ConnSingleton.getConnSingleton();
	Connection conn = cu.getConnection();
	OrderDAO orderDAO = new OrderDAO();
	CatalogDAO catalogDAO = new CatalogDAO();

	
	@Test
	public void testGetOrderIDReturnsOrderType() {
		Order testOrder = orderDAO.getOrderID(2);		
		assertEquals(testOrder instanceof Order, true);
	}

	@Test
	public void testAcceptShipDate() {
		Order testOrder = orderDAO.getOrderID(2);
		assertEquals(testOrder.isAccepted(),false);
		assertEquals(orderDAO.acceptShipDate(2), true);		
	}

	@Test
	public void testGetSKU() {
		Item testItem = catalogDAO.getSKU(99999998);
		assertEquals(testItem instanceof Item, true);
	}
	
	@Test
	public void testCancelItem() {
		assertEquals(orderDAO.cancelItem(2, 3), true);
	}

	@Test
	public void testCancelOrder() {
		assertEquals(orderDAO.cancelOrder(2),true);
	}


}
