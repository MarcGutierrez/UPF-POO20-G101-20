package UPF_POO20_G101_20.Lab2;

import java.util.List;

public class Program {
    private String name;
    private int loopIndex;
    private int programIndex;
    private List<Instruction> Instructions;

    Program(List<Instruction> inst, String name){
        Instructions = inst;
        this.name = name;
        setLoopIndex(0);
        programIndex = 0;
    }

    public String getName(){
        return name;
    }

    public boolean addInstruction(Instruction instruction){
        if (instruction.isCorrect()) {
            Instructions.add(instruction);
            return true;
        }
        return false;
    }

    public void restart(){
        programIndex = 0;
    }

    public boolean hasFinished(){    	
        return (programIndex == this.Instructions.size()-1) ? true : false;
    }

    public Instruction getNextInstruction(){
    	if (hasFinished()) {
    		return Instructions.get(Instructions.size()-1);
    	}
    	Instruction ins =  Instructions.get(programIndex);
    	programIndex++;
    	return ins;
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
    	restart();
    	return correct;
    }
    
    public void printErrors() {
    	Instruction inst = Instructions.get(0);
    	while (!hasFinished()) {
    		if (!inst.isCorrect()) {
    			System.out.println(inst.info());
    		}
    		inst = getNextInstruction();
    	}
    	restart();
    }
    
    public void goToStartLoop() {
    	while (!this.Instructions.get(programIndex).getCode().equals("REP")) {
    		loopIndex--;
    	}
    	loopIndex++;
    }

	public int getLoopIndex() {
		return loopIndex;
	}

	public void setLoopIndex(int d) {
		this.loopIndex = d;
	}
}
