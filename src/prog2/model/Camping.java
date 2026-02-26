package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.util.*;
import java.util.Iterator;


public class Camping implements InCamping {
    private String nomCamping;
    private Allotjament llistaAllotjaments; //fer array?
    private Client llistaClients; //fer array
    private LlistaReserves llistaReserves;  //fer array

    public Camping(String nomCamping){
        this.nomCamping = nomCamping;
        this.llistaAllotjaments = new Allotjament();
        this.llistaClients = new Client();
        this.llistaReserves = new LlistaReserves();
    }

    public void buscarAllojament(){

    }


    @Override
    public String getNom() {
        return "";
    }

    @Override
    public LocalDate getLlistaReserves() {
        return null;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return null;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return null;
    }

    @Override
    public int getNumAllotjaments() {
        return 0;
    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    @Override
    public int getNumClients() {
        return 0;
    }

    @Override
    public void afegirClient(String nom_, String dni_) {

    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments.add(p);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        llistaAllotjaments.add(b);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        llistaAllotjaments.add(bp);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        llistaAllotjaments.add(g);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        llistaAllotjaments.add(mh);
    }

    @Override
    public void afegirReserva(String id_, String dni_, java.time.LocalDate dataEntrada, java.time.LocalDate dataSortida) throws ExcepcioReserva {
        llistaAllotjaments.add(r);
    }

    @Override
    public int calculAllotjamentsOperatius() {
        return 0;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        return null;
    }
}
