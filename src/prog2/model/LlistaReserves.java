package prog2.model;
import prog2.vista.ExcepcioReserva;

import java.util.*;
import java.time.LocalDate;

public class LlistaReserves implements InLlistaReserves {

    private ArrayList<Reserva> llistaReserves;

    public LlistaReserves (){
        // = new ArrayList<Reserva>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida) throws ExcepcioReserva {

    }

    @Override
    public int getNumReserves() {
        return 0;
    }

    public void allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){

    }
}
