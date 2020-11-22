package UPF_POO20_G101_20.Lab3.users;

import java.util.List;

import UPF_POO20_G101_20.Lab3.User;
import UPF_POO20_G101_20.Lab3.items.AuctionItem;

public class Admin extends User {

	public Admin(String n, String i, String p) {
		super(n, i, p);
	}
	
	public boolean expel(User u) {
		if (!(u instanceof Admin)) {
			System.out.println(getName() + " expelled the user " + u.getName());
			return true;
		}
		System.out.println("User " + u.getName() + " could not be expelled by " + getName() + " as is an Admin");
		return false;
	}
	
	public boolean manageAuction(AuctionItem i, String d) {
		if (Integer.parseInt(d) < Integer.parseInt(i.getDeadline())) {
			System.out.println(getName() + " managed the item " + i.getName());
			return true;
		}
		System.out.println("Item " + i.getName() + " deadline ended on: " + i.getDeadline());
		return false;
	}
	
	public void printStock(List<AuctionItem> i) {
		System.out.println("Administrator " + getName() + " is printing the current stock");
		for(int idx = 0; idx < i.size(); idx++) {
			System.out.println(i.get(idx).getName() + " has current price " + Double.toString(i.get(idx).getPrice()) + " with deadline " + i.get(idx).getDeadline());
		}
	}

}
