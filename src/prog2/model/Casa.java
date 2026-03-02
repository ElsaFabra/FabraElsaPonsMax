package prog2.model;

public abstract class Casa extends Allotjament{
    private String mida_;
    private int habitacions_;
    private int placesPersones_;

    public Casa(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones) {
        super(nom_, idAllotjament_);
        this.mida_ = mida;
        this.habitacions_ = habitacions;
        this.placesPersones_ = placesPersones;
    }

    public String getMida_() {
        return mida_;
    }

    public void setMida_(String mida) {
        this.mida_ = mida;
    }

    public int getHabitacions_() {
        return habitacions_;
    }

    public void setHabitacions_(int habitacions) {
        this.habitacions_ = habitacions;
    }

    public int getPlacesPersones_() {
        return placesPersones_;
    }

    public void setPlacesPersones_(int placesPersones) {
        this.placesPersones_ = placesPersones;
    }

    @Override
    public String toString() {
        return super.toString() + ", mida =" + mida_ + ", habitacions =" + habitacions_ + ", places de persones =" + placesPersones_;
    }
}
