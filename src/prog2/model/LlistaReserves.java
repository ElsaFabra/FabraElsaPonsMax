package prog2.model;
import prog2.vista.ExcepcioReserva;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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

        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            throw new ExcepcioReserva("Les dates sol·licitades per " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId());
        }

        Reserva novaReserva = new Reserva(allotjament, client, dataEntrada, dataSortida);
        llistaReserves.add(novaReserva);
    }

    @Override
    public int getNumReserves() {
        return llistaReserves.size();
    }

    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        for (Reserva reserva : llistaReserves) {
            if (reserva.getAllotjament_().equals(allotjament)) {
                LocalDate e = reserva.getDataEntrada();
                LocalDate s = reserva.getDataSortida();
                if (!(dataSortida.isBefore(e) || dataEntrada.isAfter(s))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);
        long estadaMinima = allotjament.getEstadaMinima(temporada);
        return estada >= estadaMinima;
    }
}
