package UPF_POO20_G101_20.Lab4.users;

import java.util.ArrayList;
import java.util.List;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.User;
import UPF_POO20_G101_20.Lab4.items.AuctionItem;
import UPF_POO20_G101_20.Lab4.items.UnitItem;
import UPF_POO20_G101_20.Lab4.items.WeightedItem;

public class Buyer extends User {
	private String accountNumber;
	private List<Item> boughtItems = new ArrayList<Item>();
	
	public Buyer(String n, String id, String p, String a){
		super(n, id, p);
		accountNumber = a;
	}
	
	public void buy(Item i, int number) {
		if (pay(i.getPrice())) {
			double x = 0.0;
        	if (i instanceof UnitItem) {
        		UnitItem item = (UnitItem)i;
        		x = item.sell(number);
        	}
        	else if (i instanceof WeightedItem) {
        		WeightedItem item = (WeightedItem)i;
        		x = item.sell(number);
        	}
        	if (x == 0.0 && !(i instanceof AuctionItem)) {
        		System.out.println("You tried to buy more than the actual stock, please, try again buying less.");
        	}
        	else if(i instanceof AuctionItem) {
        		System.out.println("This is an auction item, please try bidding instead.");
        	}
        	else {
    			System.out.println(getName() + " is buying item " + i.getName() + " for " + i.getPrice() + " euros");
    			boughtItems.add(i);
    			System.out.println("Price " + i.getPrice() + " is getting charged into account " + accountNumber + " from user " + getName());
        	}
		}
	}
	
	private boolean pay(double p) {
		return (p > 0) ? true : false;
	}
}
