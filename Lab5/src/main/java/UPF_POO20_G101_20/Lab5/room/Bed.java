package UPF_POO20_G101_20.Lab5.room;

import UPF_POO20_G101_20.Lab5.persons.Resident;

public class Bed{
	private int bedID;
	private Room room;
	private Resident resident;
		
	public Bed( int id, Room r ){
		this.bedID = id;
		this.room = r;
	}
	
	public void assignRoom( Room r ){
		room = r;
	}
	
	public void assignResident( Resident r ){
		resident = r;
	}
	
	public void release(){
		resident = null;
	}
	
	public int getBedID(){
		return bedID;
	}
	
	public Room getRoom() {
		return room;
	}

	public boolean isAvailable(){		
		return (resident == null);
	}	
	
	public String toString(){
		return "Bed " + Integer.toString(bedID);
	}
}
