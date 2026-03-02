package prog2.model;

public class Parcela extends Allotjament {

    private float mida_;
    private boolean connexioElectrica_;

    public Parcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        super(nom_, idAllotjament_);
        this.mida_ = metres;
        this.connexioElectrica_ = connexioElectrica;
        setEstadaMinima(4,2);
    }

    public float getMida() {
        return mida_;
    }

    public void setMida(float metres) {
        this.mida_ = metres;
    }

    public float getMetres() {
        return mida_;
    }

    public void setMetres(float metres) {
        this.mida_ = metres;
    }

    public boolean isConnexioElectrica() {
        return connexioElectrica_;
    }

    public void setConnexioElectrica(boolean connexioElectrica) {
        this.connexioElectrica_ = connexioElectrica;
    }

    @Override
    public boolean correcteFuncionament() {
        return connexioElectrica_;
    }

    public String toString(){
        return super.toString() + " Parcela(mida = " + mida_ + ", connexio electrica = " + connexioElectrica_ + ")";
    }
}
