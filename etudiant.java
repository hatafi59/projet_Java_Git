import java.util.Arrays;

public class etudiant {
    private String nom;
    private String prenom;
    private int age;
    private String CNE;
    private modules[] modules= new modules[3];
    public etudiant(String nom, String prenom, int age, String CNE, modules[] modules) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.CNE = CNE;
        this.modules = modules;
    }

    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public int getAge() {
        return age;
    }
    public String getCNE() {
        return CNE;
    }
    public modules[] getModules() {
        return modules;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCNE(String cNE) {
        CNE = cNE;
    }
    public void setModules(modules[] modules) {
        this.modules = modules;
    }

    public double moyenne() {
        double moyenne = 0;
        for (int i = 0; i < modules.length; i++) {
            moyenne += modules[i].getNote();
        }
        return moyenne / modules.length;
    }

    public String  valider(){
        String s;

        if(moyenne()>=10){
            s = "Admis";
        }
        else{
            s = "Non admis";
        }
        return s;
    }


    @Override
    public String toString() {
        return "Etudiant :\nnom=" + getNom() + " .\nprenom=" + getPrenom() + ".\nage=" + getAge() + ".\nCNE=" + getCNE() + ".\nmodules=" + Arrays.toString(this.getModules()) + ".\nmoyenne=" + moyenne() + "\nSituation :" + valider() ;
    }
   
}






