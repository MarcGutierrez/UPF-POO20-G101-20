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
        loopIndex = 0;
        programIndex = 0;
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
        programIndex = 0;
    }

    public boolean hasFinished(){    	
        return (loopIndex-- == this.Instructions.size()) ? true : false;
    }

    public Instruction getNextInstruction(){
    	if (hasFinished()) {
    		return Instructions.get(Instructions.size());
    	}
    	return Instructions.get(programIndex+1);
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
    			System.out.println(inst.getCode() + " " + Double.toString(inst.getParam()));
    		}
    		inst = getNextInstruction();
    	}
    	goToStartLoop();
    }
    
    private void goToStartLoop() {
    	while (!this.Instructions.get(programIndex).getCode().equals("REP")) {
    		programIndex--;
    	}
    	programIndex++;
    }
}
