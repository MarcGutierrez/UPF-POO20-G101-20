package UPF_POO20_G101_20.Lab2;

import java.awt.Graphics;

public class Turtle {
    private int x;
    private int y;
    private Double dirX;
    private Double dirY;
    private boolean pen;

    Turtle(int x, int y, Double dirX, Double dirY, boolean pen){
    	this.x = x; this.y = y;
    	this.dirX = dirX; this.dirY = dirY;
    	this.pen = pen;
    }

    public int getX(){
    	return x;
    }

    public int getY(){
    	return y;
    }

    public double getDirX(){
        return dirX;
    }

    public double getDirY(){
        return dirY;
    }

    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setCoord(int x, int y){
        setX(x);
        setY(y);
    }

    public void setDirX(double dirX) {
    	this.dirX = dirX;
    }
    
    public void setDirY(double dirY) {
    	this.dirY = dirY;
    }
    
    public void setDir(double dirX, double dirY) {
    	setDirX(dirX);
    	setDirY(dirY);
    }
    
    public void forward(double distance, Graphics g) {
    	int xMod = (int)(x + distance*dirX), yMod = (int)(y + distance*dirY);
    	if (isPenOn()) {
        	g.drawLine(x, y, xMod, yMod);
    	}
    	else {
    		setCoord(xMod, yMod);
    	}
    	x = xMod;
    	y = yMod;
    }
    
    public void turn(double a) {
    	a = a * (Math.PI/180);
        double temp = Math.cos(a)*dirX - Math.sin(a)*dirY;
        dirY = Math.sin(a)*dirX + Math.cos(a)*dirY;
        dirX = temp;
    }

    public void setPen(boolean on ){
        pen = on;
    }
    
    public boolean isPenOn() {
        return pen;        
    }

    public void draw(Graphics g) {
    	if (isPenOn()) {
        	int[] xCoords = {0, 0, 0}, yCoords = {0, 0, 0};
        	
        	xCoords [ 0 ] = ( int ) ( x + 8 * dirY  ); 
        	xCoords [ 1 ] = ( int ) ( x - 8 * dirY  ); 
        	xCoords [ 2 ] = ( int ) ( x + 16 * dirX ); 
        	yCoords [ 0 ] = ( int ) ( y - 8 * dirX  );
        	yCoords [ 1 ] = ( int ) ( y + 8 * dirX  );
        	yCoords [ 2 ] = ( int ) ( y + 16 * dirY );
        	
        	int nPoints = xCoords.length;
        	
        	g.drawPolygon ( xCoords, yCoords, nPoints ) ;
    	}
    }
}