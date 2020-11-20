package UPF_POO20_G101_20.Lab3.items;

import UPF_POO20_G101_20.Lab3.Item;

public class UnitItem extends Item {
	private double price;
	private int initStock;
	private int stock;

	UnitItem(String name, String type, double[] size, double cost, double price, int n) {
		super(name, type, size, cost);
		this.price = price;
		initStock = n;
		stock = n;
	}

	@Override
	public double getPrice() {
		return price*stock;
	}

	@Override
	public double computeProfit() {
		return (initStock-stock)*(getPrice()-getCost());
	}
	
	public double sell(int n) {
		stock -= n;
		return getPrice()*n;
	}

}
