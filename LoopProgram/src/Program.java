import java.util.List;

public class Program {
    private String name;
    private int loopIndex;
    private int programIndex;
    private List<Instruction> Instructions;

    Program(List<Instruction> inst, String name, int index){
        Instructions = inst;
        this.name = name;
        loopIndex = 0;
        programIndex = Instructions.size();
    }

    public String getName(){
        return name;
    }

    public boolean addInstruction(Instruction instruction){
        if (instruction.isCorrect()) {
            Instructions.add(instruction);
            programIndex++;
            return true;
        }
        return false;
    }

    public void restart(){
        goToStartLoop();
    }

    public boolean hasFinished(){    	
        return (loopIndex-- == programIndex) ? true : false;
    }

    public Instruction getNextInstruction(){
    	if (hasFinished()) {
    		return Instructions.get(Instructions.size());
    	}
    	return Instructions.get(++loopIndex);
    }
    
    public boolean isCorrect() {
    	Instruction inst = Instructions.get(0);
    	boolean correct = true;
    	while (!hasFinished()) {
    		if (!inst.isCorrect()) {
    			correct = false;
    		}
    		inst = getNextInstruction();
    	}
    	goToStartLoop();
    	return correct;
    }
    
    public void printErrors() {
    	Instruction inst = Instructions.get(0);
    	while (!hasFinished()) {
    		if (!inst.isCorrect()) {
    			System.out.println(inst.getCode() + " " + Integer.toString(inst.getParam()));
    		}
    		inst = getNextInstruction();
    	}
    	goToStartLoop();
    }
    
    private void goToStartLoop() {
    	loopIndex = 0;
    }
}
