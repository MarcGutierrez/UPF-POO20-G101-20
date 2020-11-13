package UPF_POO20_G101_20.Lab3;

public abstract class Item {
	private String name;
	private String type;
	private double size[] = {0, 0, 0};
	private double cost;
	Package pack;
	
	Item(){
		setName("Default name");
		setType("Default type");
		setCost(10.0);
		pack = new Package();
	}
	
	protected Item(String name, String type, double size[], double cost){
		this.setName(name);
		this.setType(type);
		this.setSize(size);
		this.setCost(cost);
		pack = new Package();
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
		this.size = size;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public abstract double getPrice();
	
	public abstract double computeProfit();
}
