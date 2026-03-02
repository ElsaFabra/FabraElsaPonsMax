package prog2.model;

public class BungalowPremium extends Bungalow{

    private boolean serveisExtra_;
    private String codiWifi_;

    public BungalowPremium(String nom_, String idAllotjament_,
                           String mida, int habitacions,
                           int placesPersones, int placesParquing,
                           boolean terrassa, boolean tv, boolean aireFred,
                           boolean serveisExtra, String codiWifi){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        this.serveisExtra_ = serveisExtra;
        this.codiWifi_ = codiWifi;
        setEstadaMinima(4,7);
    }

    public boolean isServeisExtra_() {
        return serveisExtra_;
    }

    public void setServeisExtra_(boolean serveisExtra_) {
        this.serveisExtra_ = serveisExtra_;
    }

    public String getCodiWifi_() {
        return codiWifi_;
    }

    public void setCodiWifi_(String codiWifi_) {
        this.codiWifi_ = codiWifi_;
    }

    @Override
    public boolean correcteFuncionament(){
        return isAireFred_() && codiWifi_ != null && codiWifi_.length() >= 8 && codiWifi_.length() <= 16;
    }

    @Override
    public String toString(){
        return super.toString() + ". Bungalow Premium(serveis extra = " + serveisExtra_ + ", codi wifi = " + codiWifi_ + ")";
    }
}
