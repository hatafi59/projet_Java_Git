
public class Cp  extends etudiant {
    public Cp(String nom, String prenom, int age, String CNE, modules[] modules) {
        super(nom, prenom, age, CNE, modules);
    } 
    @Override
    public String toString() {
        return "Cp->" + super.toString();
    }

}
