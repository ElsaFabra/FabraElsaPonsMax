package prog2.model;

/** Definició de la subclasse de casa que representa
 * els Bungalows. Té herència de casa.
 * **/
public class Bungalow extends Casa{
    //Declaració dels atributs privats de Bungalow
    private int placesParquing_; //Nombre de places de pàrquing que hi ha
    private boolean terrassa_; // Boolean true si hi ha terrassa
    private boolean tv_; // Boolean true si hi ha televisió
    private boolean aireFred_; // Boolean true si hi ha sistema d'aire fred

    /** Constructor de la subclasse Bungalow, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de Bungalow **/
    public Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 7, 4);
        //Estada Minima en temporada alta de 7 dies i en estada minima en temporada baixa de 4 dies
        setPlacesParquing_(placesParquing);
        setTerrassa_(terrassa);
        setTv_(tv);
        setTerrassa_(aireFred);
    }

    //Setters i getters per accedir als atributs privats
    public int getPlacesParquing_() {
        return placesParquing_;
    }

    public void setPlacesParquing_(int placesParquing) {
        this.placesParquing_ = placesParquing;
    }

    public boolean isTerrassa_() {
        return terrassa_;
    }

    public void setTerrassa_(boolean terrassa) {
        this.terrassa_ = terrassa;
    }

    public boolean isTv_() {
        return tv_;
    }

    public void setTv_(boolean tv) {
        this.tv_ = tv;
    }

    public boolean isAireFred_() {
        return aireFred_;
    }

    public void setAireFred_(boolean aireFred) {
        this.aireFred_ = aireFred;
    }

    //El mètode que determina si el Bungalow funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return aireFred_;
    }
    //Retornarà true si funciona perquè només funciona si existeix sistema d'aire fred

    //Mètode toString que retorna amb un string totes les dades d'aquesta subclasse
    @Override
    public String toString(){
        return super.toString() + ". Bungalow(places de parquing = " + placesParquing_ +
                ", terrassa = " + terrassa_ + ", televisio = " + tv_ + ", aire fred = " + aireFred_ + ")";
    }
}
