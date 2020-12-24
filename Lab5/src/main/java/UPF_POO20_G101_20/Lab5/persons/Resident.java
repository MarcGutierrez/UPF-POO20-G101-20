package UPF_POO20_G101_20.Lab5.persons;

import UPF_POO20_G101_20.Lab5.room.*;

public class Resident extends Patient // Add code here
{
	private Room room;
	private Bed bed;

	public Resident ( int id, String name, int age ){
		super(id, name, age);
	}
	
	public void assignRoom( Room r ){
		room = r;
	}
	
	public void assignBed( Bed b ){
		bed = b;	
	}
	
	public Doctor getDoctor(){
		return visits.get(0).getDoctor();
	}
	
	public String toString(){
		return super.toString();
	}
}
