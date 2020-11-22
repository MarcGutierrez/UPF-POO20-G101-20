package UPF_POO20_G101_20.Lab3.users;

import java.util.List;

import UPF_POO20_G101_20.Lab3.Item;
import UPF_POO20_G101_20.Lab3.User;
import UPF_POO20_G101_20.Lab3.items.UnitItem;
import UPF_POO20_G101_20.Lab3.items.WeightedItem;

public class Seller extends User{
    private String accountNumber;
    private List<Item> availableItems;

   public Seller(String n, String id, String p, String a){
        super(n, id, p);
        accountNumber = a;
    }

    public void sell(Item i) {
        if (deposit(i.getPrice())) {
        	if (i instanceof UnitItem) {
        		UnitItem item = (UnitItem)i;
        		item.sell(1);
        	}
        	else if (i instanceof WeightedItem) {
        		WeightedItem item = (WeightedItem)i;
        		item.sell(1);
        	}
			System.out.println(getName() + " is selling item " + i.getName() + " for " + i.computeProfit() + " euros");
			System.out.println("Price " + i.getPrice() + " is getting added into account " + accountNumber + " from user " + getName());
            
		}

    }

    public void addAvailableItem(Item i) {
        availableItems.add(i);
    }

    private boolean deposit(double p) {
    	return (p > 0) ? true : false;
    }
}