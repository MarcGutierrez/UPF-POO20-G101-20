package UPF_POO20_G101_20.Lab4;

import java.util.List;

import UPF_POO20_G101_20.Lab4.items.Taxable;
import UPF_POO20_G101_20.Lab4.packages.Box;
import UPF_POO20_G101_20.Lab4.packages.Envelope;
import UPF_POO20_G101_20.Lab4.users.Seller;

public abstract class Item implements Taxable {
	
	private String name;
	private String type;
	private double size[] = {0, 0, 0};
	private double cost;
	private Package pack;
	private Seller seller;
	
	Item(){
		setName("Default name");
		setType("Default type");
		setCost(10.0);
		pack = null;
	}
	
	public Item(String name, String type, double size[], double cost, Seller s){
		this.setName(name);
		this.setType(type);
		this.setSize(size);
		this.setCost(cost);
		seller = s;
		pack = null;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double[] getSize() {
		return size;
	}
	
	public Package getPackage() {
		return pack;
	}

	public void setSize(double size[]) {
		this.size[0] = size[0];
		this.size[1] = size[1];
		if (size.length > 2) {
			this.size[2] = size[2];
		}
		else {
			this.size[2] = 0;
		}
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public Seller getSeller() {
		return seller;
	}
	
	public void assignBestPackage(List<Package> p) {
		for (int i = 0; i < p.size(); i++) {
			if(p.get(i) instanceof Box) {
				Box b = (Box)p.get(i);
				if (b.isSuitable(size)) {
					pack = p.get(i);
				}
			}
			else {
				Envelope e = (Envelope)p.get(i);
				if (size[2] == 0 && e.isSuitable(size)) {
					pack = p.get(i);
				}
			}
		}
		if (pack == null) {
			System.out.println("There is no package suited for this Item, please make a new package for Item of size: ("
		+ size[0] + "," + size[1] + "," + size[2] + ")");
		}
		else if ( pack instanceof Box) {
			Box b = (Box)pack;
			System.out.println("Box with size(" + b.getHeight() + "," + b.getWidth()+ "," + b.getDepth() + ") assigned to item " + getName());
		}
		else {
			System.out.println("Envelope with size(" + pack.getHeight() + "," + pack.getWidth()+ ") assigned to item " + getName());
		}
	}

	public double getPriceOnlyTax() {
		return getPrice()*IVA;
	}

	public double getPricePlusTax() {
		return getPrice()+getPrice()*IVA;
	}

	public double sumTotalTax(Taxable t) {
		return getPricePlusTax() + ((t instanceof Item) ? ((Item)t).getPricePlusTax() : ((Package)t).getPricePlusTax());
	}
	
	public abstract double getPrice();
	
	public abstract double computeProfit();
}
