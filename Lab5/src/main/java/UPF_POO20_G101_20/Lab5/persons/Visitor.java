package UPF_POO20_G101_20.Lab5.persons;

public class Visitor extends Patient // Add code here
{
	public Visitor( int id, String name, int age ){
		super(id, name, age);
	}
	
	public String toString(){
		return super.toString();
	}
}
