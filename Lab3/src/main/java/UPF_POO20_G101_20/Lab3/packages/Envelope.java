package UPF_POO20_G101_20.Lab3.packages;

import UPF_POO20_G101_20.Lab3.Package;

public class Envelope extends Package {
	private String name;

	Envelope(int w, int h, String n) {
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
	public boolean isSuitable(int a[]) {
		return ((getHeight() > a[0]) && (getWidth() > a[1]) && (getHeight() - a[0] <= 5) && (getWidth() - a[1] <= 5)) ? true : false;
	}
}