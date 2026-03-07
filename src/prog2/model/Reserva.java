package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.*;

/** Definició de la classe que representa
 * les Reserves del allotjaments del càmping. Queda definit per la seva interfície InReserva.
 * **/
public class Reserva implements InReserva {
    //Declaració dels atributs privats
    private Allotjament allotjament_; //Objecte allotjament de la classe Allotjament
    private Client client_; //Objecte client de la classe client
    private LocalDate dataEntrada_; //Objecte amb la data d'entrada de la classe de Java Localdate
    private LocalDate dataSortida_; //Objecte amb la data de srotida de la classe de Java Localdate

    //Constructor de la classe client on s'inicialitzen tots els atributs aprofitant el setters
    public Reserva (Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

        if (dataSortida.isBefore(dataEntrada)) {
            throw new ExcepcioReserva("La data de sortida no pot ser abans de la data d'entrada");
        }

        setAllotjament_(allotjament);
        setClient(client);
        setDataEntrada(dataEntrada);
        setDataSortida(dataSortida);
    }
    //Getters i setters per accedir als atributs privats
    @Override
    public Allotjament getAllotjament_() {return allotjament_;}

    @Override
    public Client getClient() {return client_;}

    @Override
    public LocalDate getDataEntrada() {return dataEntrada_;}

    @Override
    public LocalDate getDataSortida() {return dataSortida_;}

    @Override
    public void setAllotjament_(Allotjament allotjament) {this.allotjament_ = allotjament;}

    @Override
    public void setClient(Client client) {this.client_ = client;}

    @Override
    public void setDataEntrada(LocalDate dataEntrada) {this.dataEntrada_ = dataEntrada;}

    @Override
    public void setDataSortida(LocalDate dataSortida) {this.dataSortida_ = dataSortida;}

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return allotjament_ + "del client: " + client_ + ", amb la data d'entrada: " + dataEntrada_ + ", i amb la data de sortida" + dataSortida_;
    }
}
