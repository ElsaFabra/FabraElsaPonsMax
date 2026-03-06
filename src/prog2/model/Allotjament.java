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

    //Constructor de la classe allotjament i inicialització dels atributs aprofitant els setters
    public Allotjament(String nom_, String identificador_, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        setNom(nom_);
        setId(identificador_);
        setEstadaMinima(estadaMinimaALTA_, estadaMinimaBAIXA_);
    }

    //Getters i setters de cada atribut privat per accedir a ells
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

    //Usant l'enum temp definit a la interfície aquest getter retorna la temporada corresponent
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

    /**Declaració del mètode correcteFuncionament que aplicaré després a cada subclasse
     * modificada segons els requisits de cadascuna**/
    @Override
    public abstract boolean correcteFuncionament();

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return "Nom = " + nom_ + ", Id = " + identificador_ +
                ", estada mínima en temp ALTA: " + estadaMinimaALTA_ +
                ", estada mínima en temp BAIXA: " + estadaMinimaBAIXA_ + ".";
    }
}
