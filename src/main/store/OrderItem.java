package main.store;
import java.util.HashMap;
import java.util.Map;
public class OrderItem {
	
	private Product product;
	private int quantity;

	/*
	 * Order Item Constructor
	 */
	public OrderItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	float calculateTotalForItem() {
		float totalItem=0;
		float discount=0;
		DiscountCalculator discountCalculator = createDiscountCalculator();
		discount=discountCalculator.calculateDiscount(this);
		float itemAmount = calculateAmount();
		totalItem =itemAmount-discount;
		return totalItem;
	}

	 float calculateAmount() {
		return getProduct().getUnitPrice() * getQuantity();
	}

	private DiscountCalculator createDiscountCalculator() {
		Map<ProductCategory, DiscountCalculator> map = 
				new HashMap<ProductCategory, DiscountCalculator>();
		DiscountCalculator discountCalculator = null;
		
		map.put(ProductCategory.Accessories, new AccesoriesDiscount());
		map.put(ProductCategory.Bikes, new BikeDiscount());
		map.put(ProductCategory.Cloathing, new CloathingDiscount());
		
		if (getProduct().getCategory() == ProductCategory.Accessories) {
			discountCalculator = new AccesoriesDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Bikes) {
			discountCalculator = new BikeDiscount();
		}
		if (getProduct().getCategory() == ProductCategory.Cloathing) {
			discountCalculator = new CloathingDiscount();
		}
		return map.get(getProduct().getCategory());
	}
}
