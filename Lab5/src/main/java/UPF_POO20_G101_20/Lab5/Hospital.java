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
		if(adminIdx < admins.size() && adminIdx >= 0) {
			for (int i = 0; i < patients.size(); i++) {
				if (patients.get(i) instanceof Resident) {
					Resident r = (Resident)patients.get(i);
					for(int j = 0; j < rooms.size(); j++) {
						Bed bed = rooms.get(j).getAvailableBed();
						if(bed != null) {
							r.assignBed(bed);
							bed.assignResident(r);
							break;
						}
					}
					System.out.println(admins.get(0).toString() + " has assigned bed to " + r.toString() + 
							
							" is assigned to " + ((r.getBed() != null) ? r.getBed().getRoom().toString() + " " + r.getBed().toString() :  " and has no room neither bed")
							
							+ " and " + 
						
							((r.getDoctor() != null) ? r.getDoctor().toString() :  " and has no doctor"));
				}
			}
		}
	}

	public void sortPatients(){
		Collections.sort(patients);
	}
	
	public String toString(){
		String a = "";
		for(Administrative admin : admins) a += admin.toString() + "\n";
		String d = "";
		for(Doctor doctor : doctors) d += doctor.toString() + "\n";
		String p = "";
		for(Patient patient : patients) {
			p += patient.toString();
			if (patient instanceof Resident) {
				Resident r = (Resident) patient;
				p += 
				" is assigned to " + ((r.getBed() != null) ? r.getBed().getRoom().toString() + " " + r.getBed().toString() :  " and has no room neither bed")
				+ " and " + 
				((r.getDoctor() != null) ? r.getDoctor().toString() :  " and has no doctor");
			}
			p += "\n";
		}
				
		String r = "";
		for(Room room : rooms) r += room.toString() + "\n" + room.listBeds() + "\n";
		
		return name + "\n" + "Administratives:\n" + a + "Doctors:\n" + d + "Patients:\n" + p + "Rooms:\n" + r;
	}
}
