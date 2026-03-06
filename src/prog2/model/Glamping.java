package prog2.model;

public class Glamping extends Casa{
    private String material_;
    private boolean casaMascota_;

    public Glamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota){
        super(nom_, idAllotjament_, mida, habitacions, placesPersones, 3, 3);
        setMaterial_(material);
        setCasaMascota_(casaMascota);
    }

    public String getMaterial_() {
        return material_;
    }

    public void setMaterial_(String material) {
        this.material_ = material;
    }

    public boolean isCasaMascota_() {
        return casaMascota_;
    }

    public void setCasaMascota_(boolean casaMascota) {
        this.casaMascota_ = casaMascota;
    }

    @Override
    public boolean correcteFuncionament() {
        return casaMascota_;
    }

    @Override
    public String toString(){
        return super.toString() + ". Glamping(material  = " + material_ + ", casa de mascotes = " + casaMascota_ + ")";
    }
}
