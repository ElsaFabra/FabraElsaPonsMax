package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class Camping implements InCamping {
    private String nomCamping_;
    private ArrayList<Allotjament> llistaAllotjaments_;
    private ArrayList<Client> llistaClients_;
    private LlistaReserves llistaReserves_;

    public Camping(String nomCamping){
        this.nomCamping_ = nomCamping;
        this.llistaAllotjaments_ = new ArrayList<Allotjament>();
        this.llistaClients_ = new ArrayList<Client>();
        this.llistaReserves_ = new LlistaReserves();
    }

    public static InAllotjament.Temp getTemporada(LocalDate data) {
        return Allotjament.getTemporada(data);
    }

    public Allotjament buscarAllotjament(String id){
        Iterator<Allotjament> it = llistaAllotjaments_.iterator();
        while (it.hasNext()) {
            Allotjament a = it.next();
            if (a.getId().equals(id)) {
                return a;
            }
        }
        return null;
    }

    public Client buscarClient(String dni){
        Iterator<Client> it = llistaClients_.iterator();
        while(it.hasNext()){
            Client c = it.next();
            if (c.getDni().equals(dni)){
                return c;
            }
        }
        return null;
    }

    @Override
    public String getNom() {
        return nomCamping_;
    }

    @Override
    public prog2.model.LocalDate getLlistaReserves() {
        return null;
    }

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {
        return llistaAllotjaments_;
    }

    @Override
    public ArrayList<Client> getLlistaClients() {
        return llistaClients_;
    }

    @Override
    public int getNumAllotjaments() {
        return llistaAllotjaments_.size();
    }

    @Override
    public int getNumReserves() {
        return llistaReserves_.getNumReserves();
    }

    @Override
    public int getNumClients() {
        return llistaClients_.size();
    }

    @Override
    public void afegirClient(String nom_, String dni_) {
        Client client = new Client(nom_, dni_);
        llistaClients_.add(client);
    }

    @Override
    public void afegirParcela(String nom_, String idAllotjament_, float metres, boolean connexioElectrica) {
        Parcela p = new Parcela(nom_, idAllotjament_, metres, connexioElectrica);
        llistaAllotjaments_.add(p);
    }

    @Override
    public void afegirBungalow(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred) {
        Bungalow b = new Bungalow(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred);
        llistaAllotjaments_.add(b);
    }

    @Override
    public void afegirBungalowPremium(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, int placesParquing, boolean terrassa, boolean tv, boolean aireFred, boolean serveisExtra, String codiWifi) {
        BungalowPremium bp = new BungalowPremium(nom_, idAllotjament_, mida, habitacions, placesPersones, placesParquing, terrassa, tv, aireFred, serveisExtra, codiWifi);
        llistaAllotjaments_.add(bp);
    }

    @Override
    public void afegirGlamping(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, String material, boolean casaMascota) {
        Glamping gp = new Glamping(nom_, idAllotjament_, mida, habitacions, placesPersones, material, casaMascota);
        llistaAllotjaments_.add(g);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mh = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments_.add(mh);
    }

    @Override
    public void afegirReserva(String id_, String dni_, java.time.LocalDate dataEntrada, java.time.LocalDate dataSortida)
            throws ExcepcioReserva {

            Allotjament allotjament = buscarAllotjament(id_);
            Client client = buscarClient(dni_);

            //Si no es troba l'allotjament el client, llançar excepció
            if (allotjament == null) {
                throw new ExcepcioReserva("No existeix l'allotjament amb id = " + id_);
            }
            if (client == null) {
                throw new ExcepcioReserva("No existeix el client amb dni = " + dni_);
            }

            llistaReserves_afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }

    @Override
    public int calculAllotjamentsOperatius() {
        int comptador = 0;
        Iterator<Allotjament> it = llistaAllotjaments_.iterator();
        while (it.hasNext()){
            Allotjament a = it.next();
            if (a.correcteFuncionament()){
                comptador++;
            }
        }
        return comptador;
    }

    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Allotjament resultat = null;
        long estadaMinima = Long.MAX_VALUE;

        //fer iterator

        return null;
    }
}
