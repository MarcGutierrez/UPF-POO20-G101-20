public class Instruction {
    int error;

    Instruction(){
        error = 1;
    }

    public boolean isCorrect(){
        return errorCode();
    }
    
    public boolean errorCode() {
    	return true;
    }
    
    public String getCode() {
    	return "Hello";
    }
    
    public int getParam() {
    	return 1;
    }
}
