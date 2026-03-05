package prog2.model;
import prog2.vista.ExcepcioReserva;
import java.util.*;
import java.time.LocalDate;

public class LlistaReserves implements InLlistaReserves {
    private ArrayList<Reserva>llistaReserves;
    private Reserva reserva;

    public LlistaReserves (){
        this.llistaReserves = new ArrayList<Reserva>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida)
            throws ExcepcioReserva {
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("L'allotjament " + allotjament.getId() + " no està disponible a " + dataEntrada + " per " + client.getNom() + " amb DNI: " + client.getDni());
        }

    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        //afeguir la lògica
        return true;
    }
}
