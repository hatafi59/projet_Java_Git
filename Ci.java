public class Ci extends etudiant{
    private filiere filiere;
    private modules pfe = new modules();

    public Ci(String nom, String prenom, int age, String CNE, modules[] modules, filiere filiere ,modules pfe) {
        super(nom, prenom, age, CNE, modules);
        this.filiere = filiere;
        this.pfe = pfe;
        this.pfe.setNom("PFE");
    }
   
    public filiere getFiliere() {
        return filiere;
    }
    public void setFiliere(filiere filiere) {
        this.filiere = filiere;
    }
    public modules getPfe() {
        return pfe;
    }
    public void setPfe(modules pfe) {
        this.pfe = pfe;
    }
    @Override
    public double moyenne() {
        double moyenne = 0;
        for (int i = 0; i < getModules().length; i++) {
            moyenne += getModules()[i].getNote();
        }
        return (moyenne / getModules().length+ pfe.getNote())/2;
    }
    @Override
    public String  valider(){
        String s;
        if(this.moyenne()>=12){
            s = "Admis";
        }
        else{
            s  = "Non admis";
        }
        return s;
    }
    @Override
    public String toString() {
        return "Ci->" + super.toString() + "\nFilière: " + filiere.getNom() + "\n" + pfe.getNom() + ":" + pfe.getNote() + ".\nmoyenne=" + moyenne() + "\nSituation :" + valider();
    }


    
}


