package UPF_POO20_G101_20.Lab4.users;

import java.util.ArrayList;
import java.util.List;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.User;
import UPF_POO20_G101_20.Lab4.items.UnitItem;
import UPF_POO20_G101_20.Lab4.items.WeightedItem;

public class Buyer extends User {
	private String accountNumber;
	private List<Item> boughtItems = new ArrayList<Item>();

	public Buyer() {
		super("Null", "Null", "Null");
		accountNumber = "Null";
	}
	
	public Buyer(String n, String id, String p, String a){
		super(n, id, p);
		accountNumber = a;
	}
	
	public void buy(Item i, double number) {
		if (pay(i.getPrice())) {
        	if (i instanceof UnitItem) {
        		UnitItem item = (UnitItem)i;
        		number = (int)((number > item.getStock()) ? item.getStock() : number);
        	}
        	else if (i instanceof WeightedItem) {
        		WeightedItem item = (WeightedItem)i;
        		number = (number > item.getStock()) ? item.getStock() : number;
        	}
			System.out.println(getName() + " is buying item " + i.getName() + " for " + i.sumTotalTax(i.getPackage()) + " euros");
			boughtItems.add(i);
			System.out.println("Price " + i.sumTotalTax(i.getPackage()) + " is getting charged into account " + accountNumber + " from user " + getName());
			i.getSeller().sell(i, number);
		}
	}
	
	private boolean pay(double p) {
		return (p > 0) ? true : false;
	}
}
