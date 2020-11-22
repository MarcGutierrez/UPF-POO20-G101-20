package UPF_POO20_G101_20.Lab3.users;

import java.util.ArrayList;
import java.util.List;

import UPF_POO20_G101_20.Lab3.Item;
import UPF_POO20_G101_20.Lab3.User;

public class Buyer extends User {
	private String accountNumber;
	private List<Item> boughtItems = new ArrayList<Item>();
	
	public Buyer(String n, String id, String p, String a){
		super(n, id, p);
		accountNumber = a;
	}
	
	public void buy(Item i) {
		if (pay(i.getPrice())) {
			System.out.println(getName() + " is buying item " + i.getName() + " for " + i.getPrice() + " euros");
			boughtItems.add(i);
			System.out.println("Price " + i.getPrice() + " is getting charged into account " + accountNumber + " from user " + getName());
		}
	}
	
	private boolean pay(double p) {
		return (p > 0) ? true : false;
	}
}
