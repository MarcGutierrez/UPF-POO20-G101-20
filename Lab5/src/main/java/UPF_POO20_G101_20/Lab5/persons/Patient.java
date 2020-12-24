package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;

import UPF_POO20_G101_20.Lab5.Person;
import UPF_POO20_G101_20.Lab5.Visit;

import java.util.ArrayList;
import java.util.Calendar;

public class Patient extends Person implements Comparable<Patient>{
	protected Calendar admissionDate;
	protected Integer age;
	protected List< Visit > visits;

	public Patient( int id, String name, int age ){
		super(id, name);
		visits = new ArrayList<Visit>();
		this.age = age;
	}
	
	public void addVisit( Visit v ){
		visits.add(v);
	}
		
	public void setAdmissionDate( Calendar d ){
		admissionDate = d;
	}
	
	public Calendar getAdmissionDate(){
		return admissionDate;
	}
	
	public void setAge( Integer age ){
		this.age = age;
	}
	
	public Integer getAge(){
		return age;
	}

	public int compareTo( Patient p ){
		return age;
	}
	
	public String toString(){
		return super.toString() + " " + Integer.toString(age);
	}
}
