
package Reto3.inter;

import Reto3.modelo.Reservaciones;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;


public interface InterfaceReservaciones extends CrudRepository<Reservaciones,Integer>{

    public List<Reservaciones> findAllByStatus(String status);

    public List<Reservaciones> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);

    // select clientId, count(*) as "total" from reservacion group by cliendId order by total desc;
    @Query("SELECT c.client, COUNT(c.client) from Reservaciones AS c group by c.client order by COUNT(c.client)DESC")
    public List<Object[]> countTotalReservationsByClient();

    
}
