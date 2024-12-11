public class modules {
    private String nom;
    private double note;
    public modules() {
        
    }
    public modules(String nom, double note) {
        this.nom = nom;
        this.note = note;
    }
    public String getNom() {
        return nom;
    }
    public double getNote() {
        return note;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setNote(double note) {
        this.note = note;
    }
    @Override
    public String toString() {
        return  nom + ":" + note ;
    }
   
}
