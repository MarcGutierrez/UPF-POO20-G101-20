package UPF_POO20_G101_20.Lab2;

import java.awt.Graphics;

public class Logo {
    private int width;
    private int height;
    private Turtle t;

    Logo(int width, int height) {
    	this.width = width;
    	this.height = height;
    	t = new Turtle(width/2, height/2, 0.0, 1.0, true);
    }

    public int getWidth() {
    	return width;
    }

    public int getHeight() {
    	return height;
    }

    public void resetTurtle() {
    	t = new Turtle(width/2, height/2, 0.0, 1.0, true);
    }
    
    public void togglePen() {
    	if (t.isPenOn()) {
    		t.setPen(false);
    	}
    	else {
        	t.setPen(true);
    	}
    }

    public void execute(Program p, Graphics g) {
    	Instruction ins;
    	while (!p.hasFinished()) {
        	t.draw(g);
    		ins = p.getNextInstruction();
    		if (ins.isCorrect()) {
        		if(ins.getCode().equals("ROT")) {
        			t.turn(ins.getParam());
        		}
        		else if (ins.getCode().equals("FWD")) {
        			t.forward(ins.getParam(), g);
        		}
        		else if (ins.getCode().equals("PEN")) {
        			t.setPen(ins.getParam() == 1.0);
        		}
        		else if(ins.getCode().equals("REP")) {
        			p.setLoopIndex((int)ins.getParam());
        		}
        		else if(ins.getCode().equals("END")) {
        			p.goToStartLoop();
        		}
    		}
    	}
    	t.draw(g);
    	p.restart();
    }
}
