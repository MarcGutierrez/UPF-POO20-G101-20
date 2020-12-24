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
		// Add code here
	}
	
	public void assignResident( Resident r ){
		// Add code here
	}
	
	public void release(){
		// Add code here
	}
	
	public int getBedID(){
		return bedID;
		// Add code here
	}

	public boolean isAvailable(){
		return false;
		// Add code here
	}	
	
	public String toString(){
		return null;
		// Add code here	
	}
}
