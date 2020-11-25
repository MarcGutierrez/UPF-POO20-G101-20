package UPF_POO20_G101_20.Lab4.users;

import java.util.ArrayList;
import java.util.List;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.User;
import UPF_POO20_G101_20.Lab4.items.UnitItem;
import UPF_POO20_G101_20.Lab4.items.WeightedItem;

public class Seller extends User{
    private String accountNumber;
    private List<Item> availableItems = new ArrayList<Item>();

   public Seller(String n, String id, String p, String a){
        super(n, id, p);
        accountNumber = a;
    }

    public void sell(Item i, int number) {
        if (deposit(i.getPrice()) && hasItem(i)) {
			double x = 0.0;
        	if (i instanceof UnitItem) {
        		UnitItem item = (UnitItem)i;
        		x = item.sell(number);
        	}
        	else if (i instanceof WeightedItem) {
        		WeightedItem item = (WeightedItem)i;
        		x = item.sell(number);
        	}
			System.out.println(getName() + " is selling item " + i.getName() + " for " + x + " euros");
			System.out.println("Price " + x + " is getting added into account " + accountNumber + " from user " + getName());
			
			if (i instanceof UnitItem) {
				UnitItem u = (UnitItem)i;
				if (u.getStock() == 0) {
					availableItems.remove(i);
				}
			}
			else if (i instanceof WeightedItem) {
				WeightedItem u = (WeightedItem)i;
				if (u.getStock() == 0) {
					availableItems.remove(i);
				}
			}
		}
    }

    public boolean hasItem(Item i) {
    	for (int a = 0; a < availableItems.size(); a++) {
    		if (i == availableItems.get(a)) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public void addAvailableItem(Item i) {
        availableItems.add(i);
    }

    private boolean deposit(double p) {
    	return (p > 0) ? true : false;
    }
}