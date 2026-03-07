package prog2.model;
import prog2.vista.ExcepcioReserva;
import java.util.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LlistaReserves implements InLlistaReserves {
    // Array amb totes les reserves del camping
    private ArrayList<Reserva> llistaReserves;

    // Inicialitzacio de la llista buida
    public LlistaReserves (){
        this.llistaReserves = new ArrayList<Reserva>();
    }

    @Override
    public void afegirReserva(Allotjament allotjament, Client client, LocalDate dataEntrada, LocalDate dataSortida)
            throws ExcepcioReserva {

        // Comprovem disponibilitat de l'allotjament:
        // Cridem el mètode auxiliar allotjamentDisponible que comprova si l'allotjament esta lliure a la data solicitades
        if (!allotjamentDisponible(allotjament, dataEntrada, dataSortida)) {
            // Si no està disponible es llança una excepció amb un missatge que inclou ID allotjament data i dades del client)
            throw new ExcepcioReserva("L'allotjament " + allotjament.getId() + " no està disponible a " + dataEntrada + " per " + client.getNom() + " amb DNI: " + client.getDni());
        }

        // Comprovem estada mínima segons temporada:
        // Cridem el mètode auxiliar isEstadaMinima que calcula els dies entre dataEntrada i dataSortida i ho compara amb l'estada mínima que correspon
        if (!isEstadaMinima(allotjament, dataEntrada, dataSortida)) {
            // Si no compleix la estada minima es llança la seguent excepció:
            throw new ExcepcioReserva("Les dates sol·licitades per " + client.getNom() + " amb DNI: " + client.getDni() + " no compleixen l'estada mínima per l'allotjament amb identificador " + allotjament.getId());
        }

        // Comprovem que no hi haigui error en les dates:
        // Mirem que la data d'entrada sigui previa a la data de sortida
        if (!dataEntrada.isBefore(dataSortida)) {
            throw new ExcepcioReserva("La data d'entrada ha de ser anterior a la data de sortida.");
        }

        // Si totes les comprovacions són correctes es crea la nova reserva
        llistaReserves.add(new Reserva(allotjament, client, dataEntrada, dataSortida));

    }

    @Override
    public int getNumReserves() { return llistaReserves.size();}

    // Mètode que comprova si un allotjament està disponible per un període concret:
    public boolean allotjamentDisponible(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida){
        // mirem totes les reserves existents
        for (Reserva reserva : llistaReserves) {
            // Nomes volem les reserves del mateix allotjament
            if (reserva.getAllotjament_().equals(allotjament)) {
                LocalDate e = reserva.getDataEntrada(); // reserva existent en data d'entrada
                LocalDate s = reserva.getDataSortida(); // reserva existent en data de sortida

                // Comprovacio de solapament de dates:
                if (dataEntrada.isBefore(s) && dataSortida.isAfter(e)) {
                    return false; // no disponible
                }
            }
        }
        return true;
    }

    // Mètode que comprova si l'estada solicitada compleix l'estada mínima:
    public boolean isEstadaMinima(Allotjament allotjament, LocalDate dataEntrada, LocalDate dataSortida) {
        // ChronoUnit.DAYS.between és un mètode de Java que calcula la diferència en dies entre dues dates:
        long estada = ChronoUnit.DAYS.between(dataEntrada, dataSortida);
        // Obtenim la temporada de la data d'entrada:
        InAllotjament.Temp temporada = Camping.getTemporada(dataEntrada);
        // Obtenim l'estada mínima per aquest allotjament i temporada:
        long estadaMinima = allotjament.getEstadaMinima(temporada);
        // Retorna "true" si l'estada solcitada és mes gran o igual que la mínima:
        return estada >= estadaMinima;
    }
}
