import java.util.Scanner;
import java.util.Hashtable;
public class main {
    private static Cp[] cp = new Cp[0];
    private static Ci[] ci = new Ci[0];
    private static Hashtable<String, filiere> filtable = new Hashtable<>();
    public static void main(String[] args) {
    String[] fils={"info", "btp", "indus"};
    for (String fil: fils){
        filtable.put(fil, new filiere(fil));
    }
        boolean continuer = true;
        while(continuer){
            // Menu
            System.out.println("Menu: ");
            System.out.println("1- Ajouter un étudiant");
            System.out.println("2- Supprimer un étudiant");
            System.out.println("3- Afficher les étudiants");
            System.out.println("4- Rechercher un étudiant");
            System.out.println("5- trier les étudiants");
            System.out.println("6- Afficher la moyenne des étudiants");
            System.out.println("7- Quitter");
            System.out.println("8-afficher les etudiatants dune filiere spécifiée :");
            Scanner scanner = new Scanner(System.in);
            int choix = scanner.nextInt();
            scanner.nextLine();
            switch (choix) {
                case 1:
                    ajouteretudiant();
                    break;
                case 2:
                    supprimeretudiant();
                    break;
                case 3:
                    afficherEtudiants();
                    break;
                case 4:
                    searchEtudiant();
                    break;
                case 5:
                    trierEtudiants();
                case 6:
                    System.out.println("La moyenne des étudiants est: " + moyenneEtudiants());
                    break;
                case 7:
                    continuer = false;
                    break;
                case 8 :
                    afficherEtudiantsFil();
                    break;
                default:
                    System.out.println("Choix invalide");
                    break;
            }
        }
        System.out.println("Au revoir");
    }

    public static void ajouteretudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de l'étudiant: ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();
        scanner.nextLine();
            System.out.print("Entrez le nom de l'étudiant: ");
            String nom = scanner.nextLine();
            System.out.print("Entrez le prénom de l'étudiant: ");
            String prenom = scanner.nextLine();
            System.out.print("Entrez l'âge de l'étudiant: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Entrez le numéro d'inscription de l'étudiant: ");
            String numeroInscription = scanner.nextLine();
            modules[] modules = new modules[3];
            for (int i = 0; i < 3; i++) {
                System.out.print("Entrez le nom du module " + (i + 1) + ": ");
                String nomModule = scanner.nextLine();
                System.out.print("Entrez la note du module " + (i + 1) + ": ");
                int noteModule = scanner.nextInt();
                scanner.nextLine(); 
                modules[i] = new modules(nomModule, noteModule);
            }
        if(choix == 1){
            Cp nvEtudiant = new Cp(nom, prenom, age, numeroInscription, modules);
            Cp[] newcp = new Cp[cp.length + 1];
            for (int i = 0; i < cp.length; i++) {
                newcp[i] = cp[i];
            }
            newcp[cp.length] = nvEtudiant;
            cp = newcp;
        }else if(choix == 2){
            System.out.print("Entrez la filière de l'étudiant: ");
            String filiere_name = scanner.nextLine();
            if(filtable.containsKey(filiere_name)){
                System.out.print("Entrez la note du PFE: ");
            int noteModulePFE = scanner.nextInt();
            scanner.nextLine();
            modules pfe = new modules();
            pfe.setNote(noteModulePFE);
            Ci nvEtudiant = new Ci(nom, prenom, age, numeroInscription, modules, filtable.get(filiere_name), pfe);
            Ci[] newci = new Ci[ci.length + 1];
            for (int i = 0; i < ci.length; i++) {
                newci[i] = ci[i];
            }
            newci[ci.length] = nvEtudiant;
            ci = newci;
            filtable.get(filiere_name).ajouterEtudiant(nvEtudiant);
            System.out.println("L'étudiant a été ajouté");
            }else{
                System.out.println("la filiere n'existe plus .");
            }
            
            
        }
        
    }

    public static void afficherEtudiants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de la liste à afficher : ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();
        scanner.nextLine();

        if (choix == 1){
            for (int i = 0; i < cp.length; i++) {
                System.out.println(cp[i].toString());
                System.out.println("_________________________");
            }
        }else if (choix == 2){
            for (int i = 0; i < ci.length; i++) {
                System.out.println(ci[i].toString());
                System.out.println("_________________________");
            }
        }else{
            System.out.println("Choix invalide");
        }
       
    }





    public static void supprimeretudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de l'étudiant: ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();

        System.out.print("Entrez le numéro d'inscription de l'étudiant à supprimer: ");
        String numeroInscription = scanner.nextLine();
        boolean trouve = false;
        if (choix == 1) {
            if(cp.length == 0){
                System.out.println("Il n'y a pas d'étudiant Cp");
                return;
            }
            for (int i = 0; i < cp.length; i++) {
                if (cp[i].getCNE().equals(numeroInscription)) {
                    Cp[] newCp = new Cp[cp.length - 1];
                    for (int j = 0; j < i; j++) {
                        newCp[j] = cp[j];
                    }
                    for (int j = i + 1; j < cp.length; j++) {
                        newCp[j - 1] = cp[j];
                    }
                    cp = newCp;
                    trouve = true;
                    System.out.println("L'étudiant a été supprimé");
                    return;
                }
            }
        } else if (choix == 2) {
            if(ci.length == 0){
                System.out.println("Il n'y a pas d'étudiant Ci");
                return;
            }
            for (int i = 0; i < ci.length; i++) {
                if (ci[i].getCNE().equals(numeroInscription)) {
                    Ci[] newCi = new Ci[ci.length - 1];
                    for (int j = 0; j < i; j++) {
                        newCi[j] = ci[j];
                    }
                    for (int j = i + 1; j < ci.length; j++) {
                        newCi[j - 1] = ci[j];
                    }
                    ci = newCi;
                    trouve = true;
                    System.out.println("L'étudiant a été supprimé");
                    return;
                }
            }
        } 
        if (!trouve) {
            System.out.println("L'étudiant n'existe pas dans la liste");
        }
    }



    public static void trierEtudiants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de l'étudiant: ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();
        if (choix == 1) {
            for (int i = 0; i < cp.length; i++) {
                for (int j = i + 1; j < cp.length; j++) {
                    if (cp[i].moyenne() < cp[j].moyenne()) {
                        Cp temp = cp[i];
                        cp[i] = cp[j];
                        cp[j] = temp;
                    }
                }
            }
        } else if (choix == 2) {
            for (int i = 0; i < ci.length; i++) {
                for (int j = i + 1; j < ci.length; j++) {
                    if (ci[i].moyenne() < ci[j].moyenne()) {
                        Ci temp = ci[i];
                        ci[i] = ci[j];
                        ci[j] = temp;
                    }
                }
            }
        } 
        System.out.println("La liste a été triée");
    }


    public static void searchEtudiant() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de l'étudiant: ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Entrez le numéro d'inscription de l'étudiant à rechercher: ");
        String numeroInscription = scanner.nextLine();
        boolean trouve = false;
        if (choix == 1) {
            for (int i = 0; i < cp.length; i++) {
                if (cp[i].getCNE().equals(numeroInscription)) {
                    System.out.println(cp[i]);
                    trouve = true;
                    System.out.println(cp[i].toString());
                    break;
                }
            }
        } else if (choix == 2) {
            for (int i = 0; i < ci.length; i++) {
                if (ci[i].getCNE().equals(numeroInscription)) {
                    System.out.println(ci[i]);
                    trouve = true;
                    System.out.println(ci[i].toString());
                    break;
                }
            }
        } 
        if (!trouve) {
            System.out.println("L'étudiant n'existe pas dans la liste");
        }
        
    }   
    

    
    public static double moyenneEtudiants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Entrez le type de l'étudiant: ");
        System.out.println("1- Cp");
        System.out.println("2- Ci");
        int choix = scanner.nextInt();
        scanner.nextLine();
        double moyenne = 0;
        if (choix == 1) {
            for (int i = 0; i < cp.length; i++) {
                moyenne += cp[i].moyenne();
            }
             moyenne = moyenne / cp.length;
        } else if (choix == 2) {
            for (int i = 0; i < ci.length; i++) {
                moyenne += ci[i].moyenne();
            }
             moyenne = moyenne / ci.length;
        }
        return moyenne;
    }
    public static void afficherEtudiantsFil(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("donner le nom de la filiere ");
        String filiere_name = scanner.nextLine();
        if(filtable.containsKey(filiere_name)){
            filtable.get(filiere_name).afficherEtudiants();
        }else{
            System.out.println("la filiere n'existe pas ");
        }



    }
    


}