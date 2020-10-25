import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Instruction inst1 = new Instruction( "FWD", 100.0 );// No bug when code changed, no bug when param changed
		Instruction inst2 = new Instruction("ROT", 90.0);   // Bug when code changed, bug when param changed _______ Infinite loop bug
		
		List<Instruction> inst = new ArrayList<>();
		
		for (int i = 0; i < 4; i++) {
			inst.add(inst1);
			inst.add(inst2);			
		}
			
		Program prog = new Program(inst, "Test");
		if (prog.isCorrect()) {
			System.out.println("Correct");
		}else {
			System.out.println("Error");
		}
	}
}