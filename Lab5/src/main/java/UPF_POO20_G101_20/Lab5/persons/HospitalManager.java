package UPF_POO20_G101_20.Lab5.persons;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import UPF_POO20_G101_20.Lab5.Hospital;

public class HospitalManager{
	private List< Hospital > hospitals;
	private List< Doctor > doctors;
	private List< Administrative > administratives;

	public HospitalManager(){
		hospitals = new ArrayList< Hospital >();
		doctors = new ArrayList< Doctor >();
		administratives = new ArrayList< Administrative >();
	}

	public void addHospital( String name ){
		hospitals.add( new Hospital( name ) );
	}

	public void addDoctor( int id, String name ){
		doctors.add( new Doctor( id, name ) );
	}

	public void addAdministrative( int id, String name, Hospital h ){
		administratives.add( new Administrative( id, name, h ) );
	}
	
	public Hospital getHospital( int idx ){ return hospitals.get( idx ); }
	
	public Doctor getDoctor( int idx ){ return doctors.get( idx ); }
	
	public Administrative getAdmin( int idx ){ return administratives.get( idx ); }
	
	public static void main( String args[] ){
		HospitalManager hm = new HospitalManager();

		hm.addHospital( "Hospital Sant Joan de Deu" );
		hm.addHospital( "Hospital de Barcelona" );

		hm.addDoctor( 1, "Joline" );
		hm.addDoctor( 2, "Antoine" );

		hm.addAdministrative( 3, "Clarise", hm.getHospital( 0 ) );
		hm.addAdministrative( 4, "Pere", hm.getHospital( 1 ) );

		for( int id = 0; id < 2; id++ ){
			for( int h = 0; h < 2; h++ ){
				hm.getHospital( h ).addRoom( id );
				for( int b = 0; b < 2; b++ )
					hm.getHospital( h ).getRoom( id ).addBed( b );
			}
		}

		hm.getHospital( 0 ).addAdmin( hm.getAdmin( 0 ) );
		hm.getHospital( 1 ).addAdmin( hm.getAdmin( 1 ) );

		hm.getHospital( 0 ).addDoctor( hm.getDoctor( 0 ) );
		hm.getHospital( 0 ).addDoctor( hm.getDoctor( 1 ) );
		hm.getHospital( 0 ).getDoctor( 0 ).addSpeciality( "General" );
		hm.getHospital( 0 ).getDoctor( 1 ).addSpeciality( "General" );
		hm.getHospital( 0 ).getDoctor( 1 ).addSpeciality( "Cardiologist" );
		hm.getHospital( 1 ).addDoctor( hm.getDoctor( 0 ) );

		for( int i = 0; i < 2; i++ ){
			Doctor d = hm.getDoctor( i );
			d.listSpecialities();
			d.listVisits();		
			System.out.println();
		}
		System.out.println();

		hm.getHospital( 0 ).addResident( 87634, "Jaume", 19 );
		hm.getHospital( 0 ).addResident( 34532, "Monica", 25);
		hm.getHospital( 0 ).addResident( 62452, "German", 50);
		hm.getHospital( 0 ).addResident( 21411, "Maria", 37 );
		hm.getHospital( 0 ).addResident( 12999, "Francesc", 88);
		hm.getHospital( 0 ).addVisitor( 78678, "Carme", 63);

		hm.getHospital( 1 ).addVisitor( 12841, "Xavi", 43 );
		hm.getHospital( 1 ).addVisitor( 26256, "Fatima",65 );
		hm.getHospital( 1 ).addVisitor( 62213, "Johan",22 );
		hm.getHospital( 1 ).addVisitor( 26268, "Johanna",10 );
		hm.getHospital( 1 ).addVisitor( 99887, "Jan",90 );
			
		hm.getHospital( 0 ).getAdmin( 0 ).addVisit( Calendar.getInstance(), "Is a cold", hm.getHospital( 0 ).getDoctor( 0 ), hm.getHospital( 0 ).getPatient( 0 ) );
		hm.getHospital( 0 ).getAdmin( 0 ).addVisit( Calendar.getInstance(), "Undefined, visit with cardiologist", hm.getHospital( 0 ).getDoctor( 1 ), hm.getHospital( 0 ).getPatient( 1 ) );
		hm.getHospital( 1 ).getAdmin( 0 ).addVisit( Calendar.getInstance(), "Is a cold", hm.getHospital( 0 ).getDoctor( 0 ), hm.getHospital( 0 ).getPatient( 3 ) );

		hm.getHospital( 0 ).assignBeds( 0 );

		System.out.println();

		for( int i = 0; i < 2; i++ ){
			System.out.println( hm.getHospital( i ) );
		}

	}
}
