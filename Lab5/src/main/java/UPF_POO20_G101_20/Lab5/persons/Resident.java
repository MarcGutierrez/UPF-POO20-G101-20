package UPF_POO20_G101_20.Lab5.persons;

import UPF_POO20_G101_20.Lab5.room.*;

public class Resident extends Patient
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
		return (visits.size() > 0) ? visits.get(0).getDoctor() : null;
	}
	
	public Bed getBed() {
		return bed;
	}
	
	public String toString(){
		return "Resident " + super.toString();
	}
}
