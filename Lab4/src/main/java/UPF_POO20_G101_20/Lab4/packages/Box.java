package UPF_POO20_G101_20.Lab4.packages;

import UPF_POO20_G101_20.Lab4.Package;

public class Box extends Package {
	private int depth;

    public Box(int w, int h, int d) {
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
    public boolean isSuitable (double[] size){
        return ((getHeight() > size[0]) && (getWidth() > size[1]) && (getDepth() > size[2])  
        && (getHeight() - size[0] <= 20) && (getWidth() - size[1] <= 20) && (getDepth() - size[2] <= 20)) ? true : false;
    }
}
