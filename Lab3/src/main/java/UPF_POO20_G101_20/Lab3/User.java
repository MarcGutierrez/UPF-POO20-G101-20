package UPF_POO20_G101_20.Lab3;

public class User {
	private String name, id, password;
	
	public User(String n, String i, String p){
		setName(n);
		id = i;
		password = p;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return Integer.parseInt(id);
	}
	
	public String getPassword() {
		return password;
	}
	
	public boolean login(String p) {
		return (getPassword().equals(p));
	}
}
