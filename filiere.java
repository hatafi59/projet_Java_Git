public class filiere {
    private String nom;
    private Ci[] etudiants = new Ci[60];
    private String chefFiliere ;
    public filiere(String nom) {
        this.nom = nom;
    }
    public String getNom() {
        return nom;
    }
    public Ci[] getEtudiants() {
        return etudiants;
    }
    public String getChefFiliere() {
        return chefFiliere;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setEtudiants(Ci[] etudiants) {
        this.etudiants = etudiants;
    }
    public void setChefFiliere(String chefFiliere) {
        this.chefFiliere = chefFiliere;
    }
    public void afficherEtudiants(){
        for (int i = 0; i < etudiants.length; i++) {
            if(etudiants[i]!=null){
                System.out.println(etudiants[i].toString());
            }
        }
    }
    public void ajouterEtudiant(Ci etudiant){
        for (int i = 0; i < etudiants.length; i++) {
            if(etudiants[i]==null){
                etudiants[i] = etudiant;
                break;
            }
        }
    }
    




}


    
