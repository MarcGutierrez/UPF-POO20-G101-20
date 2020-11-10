package UPF_POO20_G101_20.Lab2;

public class Instruction {
    private String code;
    private Double param;

    Instruction( String code, Double param){
        this.code = code;
        this.param = param;
    }
    
    public String getCode() {
    	return code;
    }
    
    public double getParam() {
    	return param;
    }

    public boolean isRepInstruction(){
        return (this.code.equals("REP") || this.code.equals("END")) ? true : false;
    }

    public boolean isCorrect() {
        switch (errorCode()) {
        default:
        	return true;
        case 1:
        	System.out.println("The code is not among the valid logo codes.");
        	return false;
        case 2:
        	System.out.println("In 'FWD' code is not in the range (-1000, 1000).");
        	return false;
        case 3:
            System.out.println("'PEN' code has param different from 0 or 1.");
            return false;
        case 4:
        	System.out.println("'ROT' code has a param greater or equal to 360, or less or equal to -360.");
        	return false;
        case 5:
            System.out.println("'REP' code has param less or equal 0 or greater or equal 1000.");
            return false;
        }
    }
    
    public int errorCode() {
    	String[] codes = {"REP", "PEN", "ROT", "FWD", "END"};
    	boolean rightCode = false;
    	int codeInd = 0;
    	for (int i = 0; i < codes.length; i++) {
    		if (codes[i].equals(this.code)) {
    			rightCode = true;
    			codeInd = i;
    		}
    	}
    	
    	if (rightCode) {
    		switch(codeInd) {
    		case 0:
    			return (this.param >= 0 && this.param <= 1000) ? 0 : 5  ;
    		case 1:
    			return (this.param == 0 || this.param == 1) ? 0 : 3     ;
    		case 2:
    			return (this.param >= -360 && this.param <= 360) ? 0 : 4;
    		case 3:
    			return (this.param > -1000 && this.param < 1000) ? 0 : 2;
    		case 4:
    			return 0;
    		}
    	}
    	return 1;
    }
    
    public String info() {
    	return (this.code + ": " + Double.toString(this.param));
    }
}
