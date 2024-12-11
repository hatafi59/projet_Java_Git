import java.util.Date;

public class exam  {
    private modules module;
    private Date date;
    private filiere filiere;
    public exam(modules module, Date date, filiere filiere) {
        this.module = module;
        this.date = date;
        this.filiere = filiere;
    }
    public modules getModule() {
        return module;
    }
    public Date getDate() {
        return date;
    }
    public filiere getFiliere() {
        return filiere;
    }
    public void setModule(modules module) {
        this.module = module;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setFiliere(filiere filiere) {
        this.filiere = filiere;
    }

   
    
    
}
    
