package domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class MedCase {
    private UUID          refId;
    private String        diagnosis;
    private String        treatment;
    private LocalDate     caseDate;
    private LocalDate     lastModDate;
    private List<Visit>   visits;
    //private List<Invoice> invoices;
    
    public MedCase(String diagnosis, String treatment, LocalDate caseDate, Visit visit) {
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.caseDate  = caseDate;
        this.refId     = UUID.randomUUID();
        this.visits    = new ArrayList<>();
        this.visits.add(visit);
    }
    
    public UUID getRefId() {
        return refId;
    }

    public void addVisit(Visit visit){

    }

    public static void main(String args[]){

    }
}