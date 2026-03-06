package prog2.model;

/** Definició de la subclasse de casa que representa
 * els Mobil-Home. Té herència de casa.
 * **/
public class MobilHome extends Casa{
    private boolean terrassaBarbacoa_; //Boolean true si ha terrassa amb barbacoa

    /** Constructor de la subclasse Glamping, als paràmetres passen els
     * atributs de casa que s'inicialitzen fent ús del super, i
     * després aprofito els setters per inicialitzar els altres
     * atributs de MobilHome **/
    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 5);
        //Estada Minima en temporada alta de 3 dies i en estada minima en temporada baixa de 5 dies
        setTerrassaBarbacoa_(terrassaBarbacoa);
    }

    //Setters i getters per accedir als atributs privats
    public boolean isTerrassaBarbacoa_() { return terrassaBarbacoa_;}

    public void setTerrassaBarbacoa_(boolean terrassaBarbacoa) { this.terrassaBarbacoa_ = terrassaBarbacoa;}

    //El mètode que determina si el MobilHome funciona correctament
    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa_;
        //Retornarà true si funciona perquè només funciona si existeix terrassa amb barbacoa
    }

    //Mètode toString que retorna amb un string totes les dades d'aquesta subclasse
    @Override
    public String toString() {
        return super.toString() + ". Mobil-Home(Terrassa amb barbacoa = " + terrassaBarbacoa_ + ")";
    }

}
