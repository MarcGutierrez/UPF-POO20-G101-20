package UPF_POO20_G101_20.Lab5;


import java.util.List;
import java.util.ArrayList;

import UPF_POO20_G101_20.Lab5.persons.Administrative;
import UPF_POO20_G101_20.Lab5.persons.Doctor;
import UPF_POO20_G101_20.Lab5.persons.Patient;
import UPF_POO20_G101_20.Lab5.persons.Resident;
import UPF_POO20_G101_20.Lab5.persons.Visitor;
import UPF_POO20_G101_20.Lab5.room.Bed;
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
		this.name = name;
	}
	
	public void addAdmin( Administrative a ){	
		admins.add(a);
	}

	public Administrative getAdmin( int idx ){
		return admins.get(idx);
	}
	
	public void addDoctor( Doctor d ){
		doctors.add(d);
	}

	public Doctor getDoctor( int idx ){
		return doctors.get(idx);
	}

	public void addRoom( int id ){
		rooms.add(new Room(id));
	}

	public Room getRoom( int idx ){
		return rooms.get(idx);
	}	
	
	public List< Room > getRooms(){
		return rooms;	
	}
	
	public void addResident(  int id, String name, int age ){
		patients.add(new Resident(id, name, age));
	}
	
	public void addVisitor( int id, String name, int age ){
		patients.add(new Visitor(id, name, age));
	}
	
	public void addVisit( Visit v ){
		visits.add(v);
	}
	
	public Visit getVisit( int idx ){
		return visits.get(idx);
	}
	
	public Patient getPatient( int idx ){
		return patients.get(idx);
	}

	public void deletePatient( int idx ){
		patients.remove(idx);
	}
	
	public void assignBeds( int adminIdx ){
		boolean check = false;
		for (int i = 0; i < admins.size(); i++)
			if(admins.get(i).id == adminIdx)
				check = true;
		
		if(check) {
			for (int i = 0; i < patients.size(); i++) {
				if (patients.get(i) instanceof Resident) {
					Resident r = (Resident)patients.get(i);
					for(int j = 0; j < rooms.size(); j++) {
						Bed bed = rooms.get(j).getAvailableBed();
						if(bed != null) {
							r.assignBed(bed);
							bed.assignResident(r);
						}
					}
				}
			}
		}
	}

	public void sortPatients(){
		Collections.sort(patients);
	}
	
	public String toString(){
		return name;
	}
}
