package UPF_POO20_G101_20.Lab4;

import java.util.Date;

import UPF_POO20_G101_20.Lab4.users.Buyer;

public class Sale {
	private final Date date;
	private final Item item;
	private final Buyer buyer;
	
	Sale(Item i, Buyer b){
		date = new Date();
		item = i;
		buyer = b;
	}
	
	public Date getDate() {
		return date;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
}
