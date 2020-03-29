package com.ws.soap;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.feature.Features;

import com.bharath.ws.trainings.CreateOrdersRequest;
import com.bharath.ws.trainings.CreateOrdersResponse;
import com.bharath.ws.trainings.CustomerOrdersPortType;
import com.bharath.ws.trainings.DeleteOrderRequest;
import com.bharath.ws.trainings.DeleteOrderResponse;
import com.bharath.ws.trainings.GetOrdersRequest;
import com.bharath.ws.trainings.GetOrdersResponse;
import com.bharath.ws.trainings.Order;
import com.bharath.ws.trainings.Product;

@Features(features="org.apache.cxf.feature.LoggingFeature")
public class CustomerOrderWsImpl implements CustomerOrdersPortType {

	Map<BigInteger,List<Order>> customerOrder=new HashMap<>();
	int currentId;
	public CustomerOrderWsImpl() {
		init();
	}
	public void init() {
		List<Order> orders=new ArrayList();
		
		Order order=new Order();
		order.setId(BigInteger.valueOf(1));
		Product product=new Product();
		product.setId("2");
		product.setDescription("IPhone");
		product.setQuantity(BigInteger.valueOf(3));
		order.getProduct().add(product);
		
		Order order1=new Order();
		order1.setId(BigInteger.valueOf(2));
		Product product1=new Product();
		product1.setId("3");
		product1.setDescription("MacBook");
		product1.setQuantity(BigInteger.valueOf(5));
		order1.getProduct().add(product1);
		
		Order order2=new Order();
		order2.setId(BigInteger.valueOf(3));
		Product product2=new Product();
		product2.setId("4");
		product2.setDescription("HP");
		product2.setQuantity(BigInteger.valueOf(4));
		order2.getProduct().add(product2);
		
		orders.add(order);
		orders.add(order1);
		orders.add(order2);
		
		customerOrder.put(BigInteger.valueOf(++currentId), orders);
	}
	@Override
	public GetOrdersResponse getOrders(GetOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		List<Order> orders=customerOrder.get(customerId);
		GetOrdersResponse response=new GetOrdersResponse();
		for(int i=0;i<orders.size();i++) {
			response.getOrder().add(orders.get(i));
		}
		return response;
	}

	@Override
	public CreateOrdersResponse createOrders(CreateOrdersRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		
		List<Order> orders=customerOrder.get(customerId);
		orders.add(order);
		CreateOrdersResponse createOrdersResponse = new CreateOrdersResponse();
		createOrdersResponse.setResult(true);
		return createOrdersResponse;
	}
	@Override
	public DeleteOrderResponse deleteOrders(DeleteOrderRequest request) {
		BigInteger customerId=request.getCustomerId();
		Order order=request.getOrder();
		List<Order> orders=customerOrder.get(customerId);
		Boolean flag=false;
		DeleteOrderResponse deleteOrderResponse=new DeleteOrderResponse();
		orders.remove(order);
		deleteOrderResponse.setResult(true);
		return deleteOrderResponse;
	}

}
