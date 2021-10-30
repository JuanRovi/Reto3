
package Reto3.controlador;

import java.util.List;
import java.util.Optional;

import Reto3.reporte.ContadorCliente;
import Reto3.reporte.StatusReservas;
import Reto3.servicios.ServiciosReservaciones;
import Reto3.modelo.Reservaciones;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE})

public class ControladorReservaciones {
      @Autowired
    private ServiciosReservaciones servicio;
    @GetMapping("/all")
    public List<Reservaciones> getReservations(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Reservaciones> getReservation(@PathVariable("id") int reservationId) {
        return servicio.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones save(@RequestBody Reservaciones reservation) {
        return servicio.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservaciones update(@RequestBody Reservaciones reservation) {
        return servicio.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId) {
        return servicio.deleteReservation(reservationId);
    }

    @GetMapping("/report-status")
    public StatusReservas getReservas(){
        return servicio.getReporteStatusReservaciones();
    }

    @GetMapping("/report-dates/{dateOne}/{dateTwo}")
    public List<Reservaciones> getReservasTiempo (@PathVariable("dateOne")String dateOne, @PathVariable("dateTwo")String dateTwo){
        return servicio.getReportesTiempoReservaciones(dateOne, dateTwo);
    }

    @GetMapping("/report-clients")
    public List<ContadorCliente> getClientes(){
        return servicio.servicioTopClientes();

    }
}
