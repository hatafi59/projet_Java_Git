import java.util.Scanner;

public class salle {
    private String nom;
    private horaire start;
    private horaire end;
    private Boolean occupee = false;

    public salle(String nom ) {
        this.nom = nom;
    }
    public salle(String nom, horaire start, horaire end) {
        this.nom = nom;
        this.start = start;
        this.end = end;
        this.occupee = true;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public horaire getStart() {
        return start;
    }
    public horaire getEnd() {
        return end;
    }
    public void setStart(horaire start) {
        this.start = start;
    }
    public void setEnd(horaire end) {
        this.end = end;
    }
    public Boolean getOccupee() {
        return occupee;
    }
    public void setOccupee(Boolean occupee) {
        this.occupee = occupee;
    }

    @Override
    public String toString() {
        return  nom + "Start :" + start + "End :"+ end;
    }
    
    
}
