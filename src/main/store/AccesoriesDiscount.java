package main.store;

public class AccesoriesDiscount implements DiscountCalculator {
	
	public float calculateDiscount(OrderItem orderItem) {
		
		return orderItem.calculateAmount() * 10 / 100;
	}
}
