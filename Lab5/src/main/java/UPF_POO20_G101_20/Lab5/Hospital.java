package UPF_POO20_G101_20.Lab5;


import java.util.List;
import java.util.ArrayList;

import UPF_POO20_G101_20.Lab5.persons.Administrative;
import UPF_POO20_G101_20.Lab5.persons.Doctor;
import UPF_POO20_G101_20.Lab5.persons.Patient;
import UPF_POO20_G101_20.Lab5.room.Room;

import java.util.Collections;

public class Hospital{
	private List< Administrative > admins;
	private List< Doctor > doctors;
	private List< Patient > patients;
	private List< Room > rooms;
	private List< Visit > visits;
	private String name;

	public Hospital( String name ){
		admins = new ArrayList<Administrative>();
		doctors = new ArrayList<Doctor>();
		patients = new ArrayList<Patient>();
		rooms = new ArrayList<Room>();
		visits = new ArrayList<Visit>();
		// Add code here
	}
	
	public void addAdmin( Administrative a ){	
		// Add code here
	}

	public Administrative getAdmin( int idx ){
		return null;
		// Add code here	
	}
	
	public void addDoctor( Doctor d ){
		// Add code here
	}

	public Doctor getDoctor( int idx ){
		return null;
		// Add code here
	}

	public void addRoom( int id ){
		// Add code here
	}

	public Room getRoom( int idx ){
		return null;
		// Add code here	
	}	
	
	public List< Room > getRooms(){
		return rooms;
		// Add code here	
	}
	
	public void addResident(  int id, String name, int age ){
		// Add code here
	}
	
	public void addVisitor( int id, String name, int age ){
		// Add code here
	}
	
	public void addVisit( Visit v ){
		// Add code here
	}
	
	public Visit getVisit( int idx ){
		return null;
		// Add code here	
	}
	
	public Patient getPatient( int idx ){
		return null;
		// Add code here
	}

	public void deletePatient( int idx ){
		// Add code here
	}
	
	public void assignBeds( int adminIdx ){
		// Add code here
	}

	public void sortPatients(){
		// Add code here
	}
	
	public String toString(){
		return name;
		// Add code here
	}

}
