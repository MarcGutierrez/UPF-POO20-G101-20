package UPF_POO20_G101_20.Lab5;

public class Person{
	public int id;
	public String name;
	
	public Person( int id, String name ){
		this.id = id; 
		this.name = name;
	}
	
	public int getID(){
		return id;
	}
	public String getName(){
		return name;	
	}
	public void setID( int i ){
		id = i;
	}
	public void setName( String n ){
		name = n;
	}
	public String toString(){
		return name + " (ID " + Integer.toString(id);
	}
}
