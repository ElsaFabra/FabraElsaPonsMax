package prog2.model;

public class Bungalow extends Casa{

    private int placesParquing_;
    private boolean terrassa_;
    private boolean tv_;
    private boolean aireFred_;

    public Bungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones);
        this.placesParquing_ = placesParquing;
        this.terrassa_ = terrassa;
        this.tv_ = tv;
        this.aireFred_ = aireFred;
        setEstadaMinima(7, 4);
    }

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

    @Override
    public boolean correcteFuncionament() {
        return aireFred_;
    }

    @Override
    public String toString(){
        return super.toString() + ". Bungalow(places de parquing = " + placesParquing_ +
                ", terrassa = " + terrassa_ + ", televisio = " + tv_ + ", aire fred = " + aireFred_ + ")";
    }
}
