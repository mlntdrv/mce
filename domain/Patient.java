package domain;

import java.time.*;
import java.time.format.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Patient {
    private UUID          id;
    private String        name;
    private LocalDate     birthDate;
    private String        address;
    private Email         email;
    private String        telNumber;
    private List<MedCase> medCases;
    
    public Patient(String name, LocalDate birthDate, String address, Email email, String telNumber){
        this.name      = name;
        this.birthDate = birthDate;
        this.address   = address;
        this.email     = email;
        this.telNumber = telNumber;
        this.id        = UUID.randomUUID();
        this.medCases  = new ArrayList<>();
    }
    
    public UUID getId() {
        return id;
    }
    
    public long getAge(){
        LocalDate now = LocalDate.now();
        return ChronoUnit.YEARS.between(this.birthDate, now);
    }
    
    public static void main(String[] args){
        // "Milan Todorov" "1986-09-18" "Slatina, bl. 2A" "mlntdrv@gmail.com" "359883447066"
        
        if(args.length < 5){
            System.out.println("Insufficient number of args");
            return;
        }
        
        Email email;
        try {
            email = new Email(args[3]);
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
            return;
        }
        
        LocalDate bDate;
        try {
            bDate = LocalDate.parse(args[1]);
        }
        catch (DateTimeParseException ex) {
            System.out.println("Invalid birthdate");
            return;
        }
        
        String name = args[0];
        String address = args[2];
        String telNumber = args[4];
        
        Patient patient = new Patient(name, bDate, address, email, telNumber);
        System.out.println("Generated patient ID: " + patient.getId().toString());
        System.out.println("The patient is " + Long.toString(patient.getAge()) + " years old");
    }
}