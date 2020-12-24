package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;

import UPF_POO20_G101_20.Lab5.Hospital;
import UPF_POO20_G101_20.Lab5.Person;
import UPF_POO20_G101_20.Lab5.Visit;
import UPF_POO20_G101_20.Lab5.room.Bed;

import java.util.ArrayList;
import java.util.Calendar;

public class Administrative extends Person// Add code here
{

	private Hospital hospital;	
	
	public Administrative( int id, String name, Hospital hospital ){
		super(id, name);
		this.hospital = hospital;
	}
	
	public void addVisit( Calendar d, String s, Doctor doc, Patient p ){
		hospital.addVisit(new Visit(d, s, doc, p));
	}

	public boolean assignBed( Resident resident  ){
		for(int i = 0; i < hospital.getRooms().size(); i++) {
			Bed bed = hospital.getRooms().get(i).getAvailableBed();
			if(bed != null) {
				resident.assignBed(bed);
				bed.assignResident(resident);
			}
		}
		return true;
	}
	
	public String toString(){
		return super.toString() + hospital.toString();
 	}
}
