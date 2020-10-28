package UPF_POO20_G101_20.Lab2;

import java.awt.Graphics;

public class Logo {
    private int width;
    private int height;
    private Turtle t;

    Logo(int width, int height) {
    	this.width = width;
    	this.height = height;
    	t = new Turtle();
    }

    public int getWidth() {
    	return width;
    }

    public int getHeight() {
    	return height;
    }

    public void resetTurtle() {
    	t = new Turtle();
    }

    public void execute(Program p, Graphics g) {
    	
    }

}
