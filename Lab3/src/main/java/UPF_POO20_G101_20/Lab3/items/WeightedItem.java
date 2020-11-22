package UPF_POO20_G101_20.Lab3.items;

import UPF_POO20_G101_20.Lab3.Item;

public class WeightedItem extends Item {
	private double price;
	private double stock;
	private double initStock;
	
	public WeightedItem(String name, String type, double[] size, double cost, double price, double n) {
		super(name, type, size, cost);
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
	
	public double sell(int n) {
		stock -= n;
		return getPrice()*n;
	}
	
	public double getStock() {
		return stock;
	}

}