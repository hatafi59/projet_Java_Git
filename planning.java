import java.util.Scanner;
import java.util.Hashtable;
import java.util.Map;


public class planning {
    private horaire[][] horaires = new horaire[6][8] ;
    private modules[] modules = new modules[8];
    private static Hashtable<String, modules[]> emploiDuTemps = new Hashtable<>();

    public planning() {
        for(String jour : new String[]{"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"}) {
            emploiDuTemps.put(jour, new modules[0]);

        }
        for (int jourIndex = 0; jourIndex < 6; jourIndex++) {
            for (int i = 0; i < 8; i++) {
                horaires[jourIndex][i] = new horaire("Jour" + jourIndex, 8 + i+1, 30);
            }
        }
        for(String m : new String[]{"algebre", "analyse", "langue", "C++", "python", "mecanique", "optimisation", "C"}) {
            for(int i = 0; i < 8; i++) {
                modules[i] = new modules(m);
            }
        }
        modules[0].setSal(new salle("H10"));
        modules[0].getSal().setStart(horaires[0][0]);
        modules[0].getSal().setEnd(horaires[0][1]);
        modules[0].getSal().setOccupee(true);   
        modules[0].setP(new prof("Toufik"));

        modules[1].setSal(new salle("H11"));
        modules[1].getSal().setStart(horaires[0][2]);
        modules[1].getSal().setEnd(horaires[0][3]);
        modules[1].getSal().setOccupee(true);
        modules[1].setP(new prof("Mehdioui"));

        modules[2].setSal(new salle("H10"));
        modules[2].getSal().setStart(horaires[0][4]);
        modules[2].getSal().setEnd(horaires[0][5]);
        modules[2].getSal().setOccupee(true);
        modules[2].setP(new prof("Bouzid"));

        modules[3].setSal(new salle("H11"));
        modules[3].getSal().setStart(horaires[0][6]);
        modules[3].getSal().setEnd(horaires[0][7]);
        modules[3].getSal().setOccupee(true);
        modules[3].setP(new prof("Elyaakoubi"));

        modules[4].setSal(new salle("H12"));
        modules[4].getSal().setStart(horaires[1][0]);
        modules[4].getSal().setEnd(horaires[1][1]);
        modules[4].getSal().setOccupee(true);
        modules[4].setP(new prof("Toumanari"));

        modules[5].setSal(new salle("H10"));
        modules[5].getSal().setStart(horaires[1][2]);
        modules[5].getSal().setEnd(horaires[1][3]);
        modules[5].getSal().setOccupee(true);
        modules[5].setP(new prof("Essabir"));

        modules[6].setSal(new salle("H11"));
        modules[6].getSal().setStart(horaires[1][4]);
        modules[6].getSal().setEnd(horaires[1][5]);
        modules[6].getSal().setOccupee(true);
        modules[6].setP(new prof("Toufik"));

        modules[7].setSal(new salle("H12"));
        modules[7].getSal().setStart(horaires[1][6]);
        modules[7].getSal().setEnd(horaires[1][7]);
        modules[7].getSal().setOccupee(true);
        modules[7].setP(new prof("Toumanari"));

        emploiDuTemps.put("Lundi", new modules[]{modules[0], modules[1]});
        emploiDuTemps.put("Mardi", new modules[]{modules[2], modules[3]});
        emploiDuTemps.put("Mercredi", new modules[]{modules[4], modules[5]});
        emploiDuTemps.put("Jeudi", new modules[]{modules[6], modules[7]});
        emploiDuTemps.put("Vendredi", new modules[]{modules[0], modules[1]});
        emploiDuTemps.put("Samedi", new modules[]{modules[2], modules[3]});
    }
    
    public horaire[][] getHoraires() {
        return horaires;
    }
    public modules[] getModules() {
        return modules;
    }
    public static Hashtable<String, modules[]> getEmploiDuTemps() {
        return emploiDuTemps;
    }
    public void setHoraires(horaire[][] horaires) {
        this.horaires = horaires;
    }
    public void setModules(modules[] modules) {
        this.modules = modules;
    }
    public static void setEmploiDuTemps(Hashtable<String, modules[]> emploiDuTemps) {
        planning.emploiDuTemps = emploiDuTemps;
    }


    public void ajouterSeance() {
    System.out.println("Veuillez saisir le nom du module : ");
    String nom = new Scanner(System.in).nextLine();

    System.out.println("Veuillez saisir le nom de la salle : ");
    String nomSalle = new Scanner(System.in).nextLine();

    System.out.println("Veuillez saisir le jour de la semaine : ");
    String jour = new Scanner(System.in).nextLine();

    System.out.println("Veuillez saisir l'heure de début : ");
    int heureDebut = new Scanner(System.in).nextInt();
    System.out.println("Veuillez saisir les minutes de début : ");
    int minuteDebut = new Scanner(System.in).nextInt();
    horaire start = new horaire(jour, heureDebut, minuteDebut);

    System.out.println("Veuillez saisir l'heure de fin : ");
    int heureFin = new Scanner(System.in).nextInt();
    System.out.println("Veuillez saisir les minutes de fin : ");
    int minuteFin = new Scanner(System.in).nextInt();
    horaire end = new horaire(jour, heureFin, minuteFin);

    System.out.println("Veuillez saisir le nom du professeur : ");
    String nomProf = new Scanner(System.in).nextLine();
    prof prof = new prof(nomProf);
    modules module = new modules(nom);
    salle salle = new salle(nomSalle);

    salle.setStart(start);
    salle.setEnd(end);
    module.setSal(salle);
    module.setP(prof);
    
    }

    public void supprimerSeance() {
        System.out.println("Veuillez saisir le nom du module : ");
        String nom = new Scanner(System.in).nextLine();
        modules module = new modules(nom);
        System.out.println("Veuillez le nom de la salle : ");
        String nomSalle = new Scanner(System.in).nextLine();
        salle salle = new salle(nomSalle);
        System.out.println("Veuillez saisir le jour de la semaine : ");
        String jour = new Scanner(System.in).nextLine();
        System.out.println("Veuillez saisir l'heure de début : ");
        int heureDebut = new Scanner(System.in).nextInt();
        System.out.println("Veuillez saisir les minutes de début : ");
        int minuteDebut = new Scanner(System.in).nextInt();
        horaire start = new horaire(jour, heureDebut, minuteDebut);

        System.out.println("Veuillez saisir l'heure de fin : ");
        int heureFin = new Scanner(System.in).nextInt();
        System.out.println("Veuillez saisir les minutes de fin : ");
        int minuteFin = new Scanner(System.in).nextInt();
        horaire end = new horaire(jour, heureFin, minuteFin);

        for (String key : emploiDuTemps.keySet()) {
            modules[] modulesArray = emploiDuTemps.get(key);
            for (modules m : modulesArray) {
                if (m.getNom().equals(module.getNom()) 
                        && m.getSal().getNom().equals(salle.getNom()) 
                        && m.getSal().getStart().equals(start) 
                        && m.getSal().getEnd().equals(end)) {
                    emploiDuTemps.remove(key);
                    System.out.println("La séance a été supprimée avec succès !");
                    return;
                }
            }
        }
        
        System.out.println("La séance n'a pas été trouvée !");
    }
    
    public void isOccupee(){
        System.out.println("Veuillez saisir le jour de la semaine : ");
        String jour = new Scanner(System.in).nextLine();
        System.out.println("Veuillez saisir l'heure de début : ");
        int heureDebut = new Scanner(System.in).nextInt();
        System.out.println("Veuillez saisir les minutes de début : ");
        int minuteDebut = new Scanner(System.in).nextInt();
        horaire h = new horaire(jour, heureDebut, minuteDebut);
        for (String key : emploiDuTemps.keySet()) {
        modules[] modulesArray = emploiDuTemps.get(key);
            for (modules m : modulesArray) {
                horaire start = m.getSal().getStart();
                horaire end = m.getSal().getEnd();
                if (h.getJours() == start.getJours() && h.getJours() == end.getJours()) {
                    if (h.getHeure() >= start.getHeure() && h.getHeure() <= end.getHeure()) {
                        if (h.getMinute() >= start.getMinute() && h.getMinute() <= end.getMinute()) {
                            System.out.println("La salle est occupée");
                            return;
                        } else {
                            System.out.println("La salle est libre");
                            return;
                        }
                    } else {
                        System.out.println("La salle est libre");
                        return;
                    }
                } else {
                    System.out.println("La salle est libre");
                    return;
                }
            }
        }

    }

    public  void afficherEmploiDuTemps() {
        for (String key : emploiDuTemps.keySet()) {
            System.out.println(key + " | ");
            modules[] modulesArray = emploiDuTemps.get(key);
            for (modules module : modulesArray) {
                if(module == null) {
                    continue;
                }
                System.out.println(module.toString() + " : " 
                    + module.getSal().getStart().toString() + " --------> " 
                    + module.getSal().getEnd().toString());
            }
        }
        
    }
}
