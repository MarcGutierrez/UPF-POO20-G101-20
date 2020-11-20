package UPF_POO20_G101_20.Lab3.items;

import UPF_POO20_G101_20.Lab3.Item;
import UPF_POO20_G101_20.Lab3.users.Buyer;

public class AuctionItem extends Item {
	private double bid;
	private Buyer bidder;
	private String deadline;
	
	static final int fee = 5;
	static final double tax = 0.05;
	
	AuctionItem(String name, String type, double[] size, double cost, double bid, String deadline) {
		super(name, type, size, cost);
		this.bid = bid;
		this.deadline = deadline;
	}

	@Override
	public double getPrice() {
		return bid;
	}

	@Override
	public double computeProfit() {
		return bid - fee - (bid*tax) - getCost();
	}
	
	public void makeBid(Buyer bidder, double bid) {
		if (this.bid < bid) {
			this.bidder = bidder;
			this.bid = bid;
		}
	}
	
	public boolean frozen(String time) {
		return (time.equals(getDeadline())) ? true : false;
	}

	public Buyer getBuyer() {
		return bidder;
	}
	
	public String getDeadline() {
		return deadline;
	}
	
}
