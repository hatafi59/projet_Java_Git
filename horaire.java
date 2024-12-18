public class horaire {
    private String jours ;
    private int heure;
    private int minute;
    public horaire(String jours , int heure, int minute) {
        this.jours = jours;
        this.heure = heure;
        this.minute = minute;
    }
    public String getJours() {
        return jours;
    }
    public int getHeure() {
        return heure;
    }
    public int getMinute() {
        return minute;
    }
    public void setJours(String jours) {
        this.jours = jours;
    }
    public void setHeure(int heure) {
        this.heure = heure;
    }
    public void setMinute(int minute) {
        this.minute = minute;
    }
    @Override
    public String toString() {
        return jours + " " + heure + ":" + minute;
    }
}
