package main.store;

public class CloathingDiscount implements DiscountCalculator{
	public float calculateDiscount(OrderItem orderItem) {
		
		return orderItem.getProduct().getUnitPrice();
	}
}
