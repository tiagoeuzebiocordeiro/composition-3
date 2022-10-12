/*	DevSuperior - Aulão
 * 
 * 	Ref: https://www.youtube.com/watch?v=gj80JEqk5ms&t=185s&ab_channel=DevSuperior
 * 	Tema: composição de objetos
 * 	Java OOP Course				*/

package application;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	
	
	public static void main(String[] args) {
		
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter client data:");
		
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		
		System.out.print("Email: ");
		String clientEmail = sc.next();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		LocalDate clientBirthDate = LocalDate.parse(sc.next(), dtf);
		
		Client client = new Client(clientName, clientEmail, clientBirthDate);
		
		System.out.println("Enter order data:");
		
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next().toUpperCase()); // Why to upper case? Because the user may type with lower case letters, resulting in program malfunctions.
		
		Order order = new Order(LocalDateTime.now(ZoneId.of("America/Sao_Paulo")), status, client);
		
		System.out.print("How many items to this order? ");
		int itemsQuantity = sc.nextInt();
		
		for (int i = 1; i <= itemsQuantity; i++) {
			System.out.println("Enter #" + i + " item data:");
			sc.nextLine(); // Buffer Cleaner
			
			System.out.print("Product name: ");
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem oi = new OrderItem(quantity, productPrice, product);
			
			order.addItem(oi);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}
