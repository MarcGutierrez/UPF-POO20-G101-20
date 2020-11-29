package UPF_POO20_G101_20.Lab4;

import java.util.Calendar;

import UPF_POO20_G101_20.Lab4.users.Buyer;

public class Sale implements Comparable<Sale> {
	private final Calendar date;
	private final Item item;
	private final Buyer buyer;
	
	Sale(Item i, Buyer b, Calendar d){
		date = d;
		item = i;
		buyer = b;
	}
	
	public Calendar getDate() {
		return date;
	}
	
	public Item getItem() {
		return item;
	}
	
	public Buyer getBuyer() {
		return buyer;
	}
	
	// override from Comparable< MyClass >
	public int compareTo( Sale ins ) {
		if ( getDate().before(ins.getDate()))
			return -1;
		else if ( getDate().equals(ins.getDate()) )
			return 0;
		else
			return 1;
	}
}
