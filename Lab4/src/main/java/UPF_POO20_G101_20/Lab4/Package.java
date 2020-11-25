package UPF_POO20_G101_20.Lab4;

import UPF_POO20_G101_20.Lab4.items.Taxable;

public class Package implements Taxable {
    private int width;
    private int height;
    private double price;

    public Package(int w, int h){
        width = w;
        height = h;
    }

	public int getWidth() {
		return width;
	}

	public void setWidth(int w) {
		width = w;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int h) {
		height = h;
	}

	public double getPrice() {
		return price;
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
}
