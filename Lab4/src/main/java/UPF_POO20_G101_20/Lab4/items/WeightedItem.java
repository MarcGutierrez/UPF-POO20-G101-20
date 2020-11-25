package UPF_POO20_G101_20.Lab4.items;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.users.Seller;

public class WeightedItem extends Item {
	private double price;
	private double stock;
	private double initStock;
	
	public WeightedItem(String name, String type, double[] size, double cost, Seller s, double price, double n) {
		super(name, type, size, cost, s);
		this.price = price;
		stock = n;
		initStock = n;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public double computeProfit() {
		return (initStock-stock)*(getPrice()-getCost());
	}
	
	public double sell(double n) {
		if (n > stock || n <= 0) {
			n = stock;
		}
		stock -= n;
		return getPrice()*n;
	}
	
	public double getStock() {
		return stock;
	}
}