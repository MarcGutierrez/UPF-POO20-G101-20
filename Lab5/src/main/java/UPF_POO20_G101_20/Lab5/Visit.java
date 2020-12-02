package UPF_POO20_G101_20.Lab5;


import java.util.Calendar;

import UPF_POO20_G101_20.Lab5.persons.Doctor;
import UPF_POO20_G101_20.Lab5.persons.Patient;

public class Visit implements Comparable<Visit>{
	Calendar date;
	String summary;
	Doctor doctor;
	Patient patient;

	public Visit( Calendar d, String s, Doctor doc, Patient p ){
		// Add code here
	}
	
	public Calendar getDate(){
		return date;
		// Add code here	
	}
	public String getSummary(){
		return summary; 
		// Add code here
	}
	public Doctor getDoctor(){
		return doctor; 
		// Add code here
	}
	public Patient getPatient(){
		return patient; 
		// Add code here	
	}
	
	public String toString(){
		return summary; 
		// Add code here	
	}

	public int compareTo(Visit arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}
