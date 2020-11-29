package UPF_POO20_G101_20.Lab4.items;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.users.Seller;

public class UnitItem extends Item {
	private double price;
	private int initStock;
	private int stock;

	public UnitItem(String name, String type, double[] size, double cost, Seller s, double price, int n) {
		super(name, type, size, cost, s);
		this.price = price;
		initStock = n;
		stock = n;
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
		if (n > stock || n < 1)
			n = stock;
		
		stock -= n;
		return sumTotalTax(getPackage())*n - ((getPackage() != null) ? getPackage().getPricePlusTax() : 0);
	}
	
	public double getStock() {
		return stock;
	}
}
