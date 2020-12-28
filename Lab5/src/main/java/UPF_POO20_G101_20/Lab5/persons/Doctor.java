package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;

import UPF_POO20_G101_20.Lab5.Person;
import UPF_POO20_G101_20.Lab5.Visit;

import java.util.ArrayList;

public class Doctor extends Person	
{
	private List< String > specialities;
	private List< Visit > visits;

	public Doctor( int id, String name ){
		super(id, name);
		specialities = new ArrayList<String>();
		visits = new ArrayList<Visit>();
	}
	
	public void addSpeciality( String s ){
		specialities.add(s);
	}
	
	public void addVisit( Visit v ){
		visits.add(v);
	}
	
	public void listSpecialities(){
		System.out.println(toString() + " has specialities:");
		for(int i = 0; i < specialities.size(); i++)
			System.out.println(specialities.get(i));
	}
	
	public void listVisits(){
		System.out.println(toString() + " has the following visits:");
		for(int i = 0; i < visits.size(); i++)
			System.out.println(visits.get(i).toString());
	}
	
	public String toString(){
		return "Doctor " + super.toString() + ")";
	}
}
