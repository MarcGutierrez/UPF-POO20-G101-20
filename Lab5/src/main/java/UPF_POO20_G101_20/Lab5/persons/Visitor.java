package UPF_POO20_G101_20.Lab5.persons;

public class Visitor extends Patient
{
	public Visitor( int id, String name, int age ){
		super(id, name, age);
	}
	
	public String toString(){
		return "Visitor " + super.toString();
	}
}
