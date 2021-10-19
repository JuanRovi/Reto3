
package Domingo_Reto3.Reto3.inter;

import Domingo_Reto3.Reto3.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
    
}
