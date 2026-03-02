package prog2.model;

public abstract class Allotjament implements InAllotjament {

    private String nom_;
    private String identificador_;
    private long estadaMinimaALTA_;
    private long estadaMinimaBAIXA_;

    public Allotjament(String nom_, String identificador_) {
        this.nom_ = nom_;
        this.identificador_ = identificador_;
    }

    public Allotjament(String nom_, String identificador_, long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.nom_ = nom_;
        this.identificador_ = identificador_;
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    @Override
    public String getNom() {
        return nom_;
    }

    @Override
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    @Override
    public String getId() {
        return identificador_;
    }

    @Override
    public void setId(String id) {
        this.identificador_ = id;
    }

    @Override
    public long getEstadaMinima(Temp temp) {
        if (temp == Temp.ALTA) {
            return estadaMinimaALTA_;
        } else {
            return estadaMinimaBAIXA_;
        }
    }

    @Override
    public void setEstadaMinima(long estadaMinimaALTA_, long estadaMinimaBAIXA_) {
        this.estadaMinimaALTA_ = estadaMinimaALTA_;
        this.estadaMinimaBAIXA_ = estadaMinimaBAIXA_;
    }

    @Override
    public abstract boolean correcteFuncionament();


    public static InAllotjament.Temp getTemporada(LocalDate data){
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();
        if(mes > 3 && mes < 9 || mes == 3 && dia >= 21 || mes == 9 && dia <= 20 ){
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    @Override
    public String toString(){
        return "Nom = " + nom_ + ", Id = " + identificador_ +
                ", estada mínima en temporada alta és " + estadaMinimaALTA_ +
                ", estada mínima en temporada baixa és " + estadaMinimaBAIXA_ + ".";
    }
}
