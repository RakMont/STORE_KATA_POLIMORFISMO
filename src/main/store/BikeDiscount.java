package main.store;

public class BikeDiscount implements DiscountCalculator{
	public float calculateDiscount(OrderItem orderItem) {
		
			return orderItem.calculateAmount() * 20 / 100;
		
	}
}
