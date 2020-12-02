package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;

import UPF_POO20_G101_20.Lab5.Visit;

import java.util.ArrayList;

public class Doctor 		// Add code here
{
	private List< String > specialities;
	private List< Visit > visits;

	public Doctor( int id, String name ){
		specialities = new ArrayList<String>();
		visits = new ArrayList<Visit>();
		// Add code here
	}
	
	public void addSpeciality( String s ){
		// Add code here
	}
	
	public void addVisit( Visit v ){
		// Add code here	
	}
	
	public void listSpecialities(){
		// Add code here
	}
	
	public void listVisits(){
		// Add code here
	}
	
	public String toString(){
		return null; 
		// Add code here
	}
}
