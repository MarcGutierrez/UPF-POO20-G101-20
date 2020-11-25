package UPF_POO20_G101_20.Lab4.items;

import java.util.Date;

import UPF_POO20_G101_20.Lab4.Item;
import UPF_POO20_G101_20.Lab4.users.Buyer;
import UPF_POO20_G101_20.Lab4.users.Seller;

public class AuctionItem extends Item {
	private double bid;
	private Buyer bidder;
	private Date deadline;
	
	static final int fee = 5;
	static final double tax = 0.05;
	
	public AuctionItem(String name, String type, double[] size, double cost, Seller s, double bid, Date deadline) {
		super(name, type, size, cost, s);
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
	
	public void makeBid(Buyer bidder, double bid, Date time) {
		if (!frozen(time)) {
			if (this.bid < bid) {
				this.bidder = bidder;
				this.bid = bid;
			}
			else {
				System.out.println("The bid of " + bid + " is too low, please try again " + bidder.getName());
			}
		}
		else {
			buy();
		}
	}
	
	private void buy() {
		bidder.buy((Item)this, 1);
		getSeller().sell((Item)this, 1);
	}
	
	public boolean frozen(Date time) {
		return time.after(getDeadline());
	}

	public Buyer getBuyer() {
		return bidder;
	}
	
	public Date getDeadline() {
		return deadline;
	}
	
}
