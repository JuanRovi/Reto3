
package Reto3.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import Reto3.inter.InterfaceReservaciones;
import Reto3.modelo.Cliente;
import Reto3.modelo.Reservaciones;
import Reto3.reporte.ContadorCliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioReservaciones {
       @Autowired
    private InterfaceReservaciones crud4;

    public List<Reservaciones> getAll(){
        return (List<Reservaciones>) crud4.findAll();
    }
    public Optional<Reservaciones> getReservation(int id){
        return crud4.findById(id);
    }
    public Reservaciones save(Reservaciones reservation){
        return crud4.save(reservation);
    }
    public void delete(Reservaciones reservation){
        crud4.delete(reservation);
    }

    public List<Reservaciones> ReservacionStatus (String status){
        return crud4.findAllByStatus(status);
    }

    public List<Reservaciones> ReservacionTiempo (Date a, Date b){
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorCliente> getTopClientes(){
        List<ContadorCliente> res=new ArrayList<>();
        List<Object[]>report = crud4.countTotalReservationsByClient();
        for(int i=0; i<report.size();i++){
            res.add(new ContadorCliente((Long)report.get(i)[1],(Cliente) report.get(i)[0]));

        }
        return res;
    }
}
