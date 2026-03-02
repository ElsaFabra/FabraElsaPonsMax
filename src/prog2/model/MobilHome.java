package prog2.model;

public class MobilHome extends Casa{
    private boolean terrassaBarbacoa_;

    public MobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        super(nom_, idAllotjament_, mida, habitacions, placesPersones);
        this.terrassaBarbacoa_ = terrassaBarbacoa;
        setEstadaMinima(3, 5);
    }
    public boolean isTerrassaBarbacoa_() {
        return terrassaBarbacoa_;
    }

    public void setTerrassaBarbacoa_(boolean terrassaBarbacoa) {
        this.terrassaBarbacoa_ = terrassaBarbacoa;
    }

    @Override
    public boolean correcteFuncionament() {
        return terrassaBarbacoa_;
    }

    @Override
    public String toString() {
        return super.toString() + ". Mobil-Home(Terrassa amb barbacoa = " + terrassaBarbacoa_ + ")";
    }

}
