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
		this.date = d;
		this.summary = s;
		this.doctor = doc;
		this.patient = p;
	}
	
	public Calendar getDate(){
		return date;
	}
	public String getSummary(){
		return summary; 
	}
	public Doctor getDoctor(){
		return doctor; 
	}
	public Patient getPatient(){
		return patient;	
	}
	
	public String toString(){
		return "Patient: " + patient.toString() + "\n" + "Doctor: " + doctor.toString() + "\nSummary:\n" + summary;
	}

	public int compareTo(Visit arg0) {
		return 0;
	}
}
