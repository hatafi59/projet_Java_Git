public class modules {
    private String nom;
    private double note = 0;
    private salle sal;
    private prof p;

public modules() {
    }
    public modules(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public double getNote() {
        return note;
    }
    public salle getSal() {
        return sal;
    }
    public prof getP() {
        return p;
    }
   
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNote(double note) {
        this.note = note;
    }
    public void setSal(salle sal) {
        this.sal = sal;
    }
    public void setP(prof p) {
        this.p = p;
    }
   
    @Override
    public String toString() {
        return  "Nom : "+ nom + "Salle : "+ sal.getNom() + "Prof : "+ p.getNom();
    }
   
}
