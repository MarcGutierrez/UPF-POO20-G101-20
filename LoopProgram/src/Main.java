import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		Instruction inst1 = new Instruction();
		List<Instruction> inst = new ArrayList<>();
		inst.add(inst1);
		Program prog = new Program(inst, "Test", 1);
		
		System.out.println(prog.getName());
	}

}
