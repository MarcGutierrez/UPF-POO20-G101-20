package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;

import UPF_POO20_G101_20.Lab5.Person;
import UPF_POO20_G101_20.Lab5.Visit;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends Person implements Comparable<Patient>{
	protected Date admissionDate;
	protected Integer age;
	protected List< Visit > visits;

	public Patient( int id, String name, int age ){
		super(age, name);
		visits = new ArrayList<Visit>();
		// Add code here
	}
	
	public void addVisit( Visit v ){
		// Add code here
	}
		
	public void setAdmissionDate( Date d ){
		// Add code here
	}
	
	public Date getAdmissionDate(){
		return admissionDate;
		// Add code here
	}
	
	public void setAge( Integer age ){
		// Add code here	
	}
	
	public Integer getAge(){
		return age;
		// Add code here	
	}

	public int compareTo( Patient p ){
		return age;
		// Add code here
	}
	
	public String toString(){
		return name;
		// Add code here
	}
}
