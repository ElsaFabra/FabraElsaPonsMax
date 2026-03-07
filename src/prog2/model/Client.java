package prog2.model;
import java.util.*;

/** Definició de la classe que representa
 * els Clients del càmping. Queda definit per la seva interfície InClient.
 * **/
public class Client implements InClient {
    //Declaració dels atributs privats
    private String nom_; //Nom del client
    private String dni_; //Dni del client

    //Constructor de la classe client, inicialitzem els atributs aprofitant els setters
    public Client(String nom, String dni){
        setNom(nom);
        setDni(dni);
    }

    //Getters i setters per accedir als atributs privats
    @Override
    public String getNom() { return nom_;}

    @Override
    public String getDni() {return dni_;}

    @Override
    public void setNom(String nom) {this.nom_ = nom;}

    @Override
    public void setDni(String dni) {this.dni_ = dni;}

    //Mètode toString que retorna amb un string totes les dades d'aquesta classe
    @Override
    public String toString(){
        return nom_ + " amb DNI: " + dni_ + ". ";
    }
}
