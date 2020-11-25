package UPF_POO20_G101_20.Lab4.packages;

import UPF_POO20_G101_20.Lab4.Package;

public class Envelope extends Package {
	private String name;

	public Envelope(int w, int h, String n) {
		super(w, h);
		name = n;
	}

	public String getName() {
		return name;
	}

	public void setName(String n) {
		name = n;
	}
    // a == Item / 5cm margin of "not too big yet"
	public boolean isSuitable(double[] size) {
		return ((getHeight() > size[0]) && (getWidth() > size[1]) && (getHeight() - size[0] <= 5) && (getWidth() - size[1] <= 5)) ? true : false;
	}
}