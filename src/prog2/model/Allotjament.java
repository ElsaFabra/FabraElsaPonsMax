package prog2.model;


/** Definició de la classe que representa
 * els allotjaments. Queda definida per la seva interfície InAllotjament.
 * **/
public abstract class Allotjament implements InAllotjament {
    //Declaració dels atributs
    private String nom_; //Nom de l'allotjament
    private String identificador_; //Nom de l'identificador de l'allotjament
    private long estadaMinimaALTA_; // Estada minima a l'allotjament en temporada alta
    private long estadaMinimaBAIXA_; // Estada minima a l'allotjament en temporada baixa

    public Allotjament(String nom_, String identificador_, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        setNom(nom_);
        setId(identificador_);
        setEstadaMinima(estadaMinimaALTA_, estadaMinimaBAIXA_);
    }

    @Override
    public String getNom() {
        return nom_;
    }

    @Override
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    @Override
    public String getId() {
        return identificador_;
    }

    @Override
    public void setId(String id) {
        this.identificador_ = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) {
            return estadaMinimaALTA_;
        } else {
            return estadaMinimaBAIXA_;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    @Override
    public abstract boolean correcteFuncionament();

    @Override
    public String toString(){
        return "Nom = " + nom_ + ", Id = " + identificador_ +
                ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
