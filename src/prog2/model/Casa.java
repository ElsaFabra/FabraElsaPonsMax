package prog2.model;

/** Definició de la subclasse d'Allotjament que representa
 * la Casa. Té herència d'Allotjament.
 * **/
public abstract class Casa extends Allotjament{
    //Declaració dels atributs privats de Casa
    private String mida_; //Mida de la casa
    private int habitacions_; //Nombre d'habitacions
    private int placesPersones_; //Quantitat de persones que caben

    /** Constructor de la classe Casa, als paràmetres passen els
     * atributs d'Allotjament que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Casa **/
    public Casa(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        super(nom_, idAllotjament_, estadaMinimaALTA_, estadaMinimaBAIXA_);
        //Com cada tipus de casa té estades minimes diferents, aquí no l'inicialitzo amb cao valor
        setMida_(mida);
        setHabitacions_(habitacions);
        setHabitacions_(placesPersones);
    }

    //Setters i getters per accedir als atributs privats
    public String getMida_() { return mida_; }

    public void setMida_(String mida) { this.mida_ = mida; }

    public int getHabitacions_() { return habitacions_; }

    public void setHabitacions_(int habitacions) { this.habitacions_ = habitacions;}

    public int getPlacesPersones_() { return placesPersones_;}

    public void setPlacesPersones_(int placesPersones) { this.placesPersones_ = placesPersones;}

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString() {
        return super.toString() + ", mida =" + mida_ + ", habitacions =" + habitacions_ + ", places de persones =" + placesPersones_;
    }
}
