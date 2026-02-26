package prog2.model;
import java.util.*;


public class Client implements InClient {

    private String nom_;
    private String dni_;

    public Client() {

    }

    public Client(String nom_, String dni_){
        this.nom_ = nom_;
        this.dni_ = dni_;
    }


    @Override
    public String getNom() {
        return "";
    }

    @Override
    public String getDni() {
        return "";
    }

    @Override
    public void setNom(String nom) {

    }

    @Override
    public void setDni(String dni) {

    }
}
