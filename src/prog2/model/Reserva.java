package prog2.model;
import java.time.LocalDate;
import java.util.*;


public class Reserva implements InReserva {
    private Allotjament allotjament_;
    private Client client_;
    private LocalDate dataEntrada_;
    private LocalDate dataSortida_;

    public Reserva (Allotjament allotjament_, Client client_, LocalDate dataEntrada_, LocalDate dataSortida_){
        this.allotjament_ = allotjament_;
        this.client_ = client_;
        this.dataEntrada_ = dataEntrada_;
        this.dataSortida_ = dataSortida_;
    }

    @Override
    public Allotjament getAllotjament_() {
        return allotjament_;
    }

    @Override
    public Client getClient() {
        return client_;
    }

    @Override
    public LocalDate getDataEntrada() {
        return dataEntrada_;
    }

    @Override
    public LocalDate getDataSortida() {
        return dataSortida_;
    }

    @Override
    public void setAllotjament_(Allotjament allotjament) {
        this.allotjament_ = allotjament;
    }

    @Override
    public void setClient(Client client) {
        this.client_ = client;
    }

    @Override
    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada_ = dataEntrada;
    }

    @Override
    public void setDataSortida(LocalDate dataSortida) {
        this.dataSortida_ = dataSortida;

    }

    @Override
    public String toString(){
        return allotjament_ + "del client: " + client_ + ", amb la data d'entrada: " + dataEntrada_ + ", i amb la data de sortida" + dataSortida_;
    }
}
