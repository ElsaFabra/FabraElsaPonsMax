package prog2.model;

public class Allotjament implements InAllotjament {

    private String nom_;
    private int identificador;
    private int tempsEstadaMin;



    @Override
    public String getNom() {
        return "";
    }

    @Override
    public void setNom(String nom) {

    }

    @Override
    public String getId() {
        return "";
    }

    @Override
    public void setId(String id) {

    }

    @Override
    public long getEstadaMinima(Temp temp) {
        return 0;
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {

    }

    @Override
    public boolean correcteFuncionament() {
        return false;
    }
}
