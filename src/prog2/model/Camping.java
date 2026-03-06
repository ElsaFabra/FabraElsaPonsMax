package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/** Definició de la classe principal que representa
 * un càmping. Queda definida per la seva interfície InCamping.
 * **/

public class Camping implements InCamping {
    //Declaració dels atributs
    private String nomCamping_; //Nom del càmping
    private ArrayList<Allotjament> llistaAllotjaments_; //Arraylist que guarda tots els allotjaments
    private ArrayList<Client> llistaClients_; //Arraylist que guarda tots els clients
    private LlistaReserves llistaReserves_; //Llista que guarda totes les reserves del càmping

    //Constructor de la classe Camping i inicialització dels atributs
    public Camping(String nomCamping){
        this.nomCamping_ = nomCamping;
        this.llistaAllotjaments_ = new ArrayList<Allotjament>();
        this.llistaClients_ = new ArrayList<Client>();
        this.llistaReserves_ = new LlistaReserves();
    }

    /** Aquest mètode retorna la temporada corresponent a la data passada
     * com a paràmetre. La temporada alta va del 21 de març al 20 de setembre.
     * La temporada baixa va del 21 de setembre al 20 de març**/
    public static InAllotjament.Temp getTemporada(LocalDate data){
        //Defineixo les variables mes i dia amb els mètodes de la classe LocalDate
        int mes = data.getMonthValue();
        int dia = data.getDayOfMonth();
        if (mes > 3 && mes < 9 || mes == 3 && dia >= 21 || mes == 9 && dia <= 20 ){
            return InAllotjament.Temp.ALTA;
        } else {
            return InAllotjament.Temp.BAIXA;
        }
    }

    /** Aquest mètode retorna l'allotjament corresponent a l'identificador
     * passat com a paràmetre. Fa servir un iterator que recorre
     * l'arraylist que conté els allotjaments del càmping, si
     * l'identificador de l'allotjament correspon al passat com a paràmetre,
     * aquest es retorna**/
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

    /** Aquest mètode retorna el client corresponent a l'identificador
     * passat com a paràmetre. Fa servir un iterator que recorre
     * l'arraylist que conté els clients del càmping, si
     * l'identificador del client correspon al passat com a paràmetre,
     * aquest es retorna**/
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

    /**Getters dels atributs, que retornen els atributs
     * o el nombre d'atributs amb la funció size
    **/

    @Override
    public String getNom() {
        return nomCamping_;
    }

    @Override
    public LlistaReserves getLlistaReserves() { return llistaReserves_;}

    @Override
    public ArrayList<Allotjament> getLlistaAllotjaments() {return llistaAllotjaments_;}

    @Override
    public ArrayList<Client> getLlistaClients() {return llistaClients_;}

    @Override
    public int getNumAllotjaments() {return llistaAllotjaments_.size();}

    @Override
    public int getNumReserves() {return llistaReserves_.getNumReserves();}

    @Override
    public int getNumClients() {return llistaClients_.size();}

    /** Els mètodes afegir afegeixen cada tipus d'allotjament, cada client
     * i cada reserva a la seva llista corresponent.
     * Hem creat un objecte segons el que s'afegeix, amb els atributs que
     * li corresponen, que passen com a paràmetre per ser afegits a cada objecte.
     * **/
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
        llistaAllotjaments_.add(gp);
    }

    @Override
    public void afegirMobilHome(String nom_, String idAllotjament_, String mida, int habitacions, int placesPersones, boolean terrassaBarbacoa) {
        MobilHome mh = new MobilHome(nom_, idAllotjament_, mida, habitacions, placesPersones, terrassaBarbacoa);
        llistaAllotjaments_.add(mh);
    }

    /** Només s'afegirà la reserva si el client i l'allotjament existeixen, si no,
    ** si no es troben es llençarà una excepció amb ExcepcioReserva de prog.vista**/
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

            llistaReserves_.afegirReserva(allotjament, client, dataEntrada, dataSortida);
    }
    /** Aquest mètode calcula sí els allotjaments són operatius
     *recorrent amb un iterator la llista d'allotjaments, i crida al mètode
     * de la classe allotjament correcteFuncionament, que s'aplica a cada subclasse
     * d'allotjament per comprovar els requisits del funcionament d'aquest. **/
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

    /** Aquest mètode recorre amb un iterator la llista d'allotjaments
     * del càmping i retorna el que té l'estada més curta segons la temporada
     * afegida com a paràmetre.**/
    @Override
    public Allotjament getAllotjamentEstadaMesCurta(InAllotjament.Temp temp) {
        Allotjament resultat = null;
        long estadaMinima = Long.MAX_VALUE;
        /** Hem assignat a estada Minima un valor inicial molt alt
         perquè sempre sigui major a l'element de la llista**/

        Iterator<Allotjament> itr = llistaAllotjaments_.iterator();
        while (itr.hasNext()){
            Allotjament a = itr.next();
            if (a.getEstadaMinima(temp) < estadaMinima){
                estadaMinima = a.getEstadaMinima(temp);
                resultat = a;
            }
        }

        return resultat;
    }
}
