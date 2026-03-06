package prog2.model;
import java.util.*;


public class Client implements InClient {

    private String nom_;
    private String dni_;

    public Client(String nom, String dni){
        setNom(nom);
        setDni(dni);
    }

    @Override
    public String getNom() {
        return nom_;
    }

    @Override
    public String getDni() {
        return dni_;
    }

    @Override
    public void setNom(String nom) {
        this.nom_ = nom;
    }

    @Override
    public void setDni(String dni) {
        this.dni_ = dni;
    }

    @Override
    public String toString(){
        return nom_ + " que té DNI: " + dni_ + ". ";
    }
}
