package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	
	private Client client; // Composição do objeto.
	
	List <OrderItem> items = new ArrayList<>();
	
	public Order() {
		
	}

	public Order(LocalDateTime moment, OrderStatus status, Client client) {
		super();
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public LocalDateTime getMoment() {
		return moment;
	}

	public void setMoment(LocalDateTime moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public double total() {
		double sum = 0;
		for (OrderItem it : items) {
			sum += it.subTotal();
		}
		
		return sum;
		
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Order moment: " + dtf.format(moment) + "\n");
		sb.append("Order Status: " + status + " \n");
		sb.append("Client: " + client.toString() + "\n");
		sb.append("Order Items: \n");
		for (OrderItem it : items) {
			sb.append(it + "\n");
		}
		
		sb.append("Total price: $" + total());
		
		return sb.toString();
	}
	
}
