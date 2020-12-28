package UPF_POO20_G101_20.Lab5.room;

import java.util.List;
import java.util.ArrayList;

public class Room{
	private List< Bed > beds;
	private int roomID;
	
	public Room( int roomID ){
		beds = new ArrayList<Bed>();
		this.roomID = roomID;
	}
	
	public void addBed( int bedID ){
		beds.add(new Bed(bedID, this));
	}
	
	public Bed getBed( int idx ){
		return beds.get(idx);
	}
	
	public Bed getAvailableBed(){
		for(Bed b : beds) { if (b.isAvailable()) return b; }; return null;
	}
	
	public boolean isAvailable(){
		for(Bed b : beds) { if (b.isAvailable()) return true; };
		return false;
	}
	
	public String listBeds(){		
		String bedList = "";
		for(Bed b : beds) bedList += b.toString() + "\n" ;
		return bedList;
	}

	public String toString(){
		return "Room " + Integer.toString(roomID);
		
	}
}