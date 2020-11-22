package UPF_POO20_G101_20.Lab3;

import java.util.List;

import UPF_POO20_G101_20.Lab3.packages.Box;
import UPF_POO20_G101_20.Lab3.packages.Envelope;

public abstract class Item {
	private String name;
	private String type;
	private double size[] = {0, 0, 0};
	private double cost;
	private Package pack;
	
	Item(){
		setName("Default name");
		setType("Default type");
		setCost(10.0);
		pack = new Package(5, 5);
	}
	
	public Item(String name, String type, double size[], double cost){
		this.setName(name);
		this.setType(type);
		this.setSize(size);
		this.setCost(cost);
		pack = new Package(5, 5);
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
		if ( pack instanceof Box) {
			Box b = (Box)pack;
			System.out.println("Box with size(" + b.getHeight() + "," + b.getWidth()+ "," + b.getDepth() + ") assigned to item " + getName());
		}
		else {
			System.out.println("Envelope with size(" + pack.getHeight() + "," + pack.getWidth()+ ") assigned to item " + getName());
		}
	}
	
	public abstract double getPrice();
	
	public abstract double computeProfit();
}
