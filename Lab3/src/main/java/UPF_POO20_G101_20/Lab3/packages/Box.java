package UPF_POO20_G101_20.Lab3.packages;

import UPF_POO20_G101_20.Lab3.Package;

public class Box extends Package {
	private int depth;

    protected Box(int w, int h, int d) {
		super(w, h);
        depth = d;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	// a == Item / 20cm margin of "not too big yet"
    public boolean isSuitable (int a[]){
        return ((getHeight() > a[0]) && (getWidth() > a[1]) && (getDepth() > a[2])  
        && (getHeight() - a[0] <= 20) && (getWidth() - a[1] <= 20) && (getDepth() - a[2] <= 20)) ? true : false;
    }
}
