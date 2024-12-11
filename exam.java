import java.util.Date;
public class exam  {
    private Date date;
    private String salle;
    private filiere filiere;
    public exam() {
    }
    public exam(Date date, String salle, filiere filiere) {
        this.date = date;
        this.salle = salle;
        this.filiere = filiere;
    }
    public Date getDate() {
        return date;
    }
    public String getSalle() {
        return salle;
    }
    public filiere getFiliere() {
        return filiere;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setSalle(String salle) {
        this.salle = salle;
    }
    public void setFiliere(filiere filiere) {
        this.filiere = filiere;
    }
    public void afficherExam(){
        System.out.println("Date: "+date);
        System.out.println("Salle: "+salle);
        System.out.println("Filière: "+filiere.getNom());
        System.out.println("Liste des étudiants qui ont passés l'exam: ");
        filiere.afficherEtudiants();


        
        
    }
    public void afficherAdmis(){
        for (int i = 0; i < filiere.getEtudiants().length; i++) {
            if(filiere.getEtudiants()[i]!=null){
                if(filiere.getEtudiants()[i].valider().equals("Admis")){
                    System.out.println(filiere.getEtudiants()[i].toString());
                    System.out.println("Date: "+date);
                }
            }
        }
    } 
    public void afficherNonAdmis(){
        for (int i = 0; i < filiere.getEtudiants().length; i++) {
            if(filiere.getEtudiants()[i]!=null){
                if(filiere.getEtudiants()[i].valider().equals("Non admis")){
                    System.out.println(filiere.getEtudiants()[i].toString());
                    System.out.println("Date: "+date);
                }
            }
        }
    }

}
    
