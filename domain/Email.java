package domain;

public class Email {
    private static final String RFC_5322_REGEX = "[\\w._-]+@[\\w]+\\.[a-zA-Z]+";

    private String emailAddr;

    public Email (String emailAddr) throws Exception {
        if(!validateEmail(emailAddr)) {
            throw new Exception("Invalid e-mail address.");
        }
        
        this.emailAddr = emailAddr;
    }
    
    private boolean validateEmail(String str){
        if(!str.matches(RFC_5322_REGEX)) return false;
        
        return true;
    }
    
    public String toString() {
        return this.emailAddr;
    }
}