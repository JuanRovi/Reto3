
package Reto3.inter;

import Reto3.modelo.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface InterfaceCliente extends CrudRepository<Cliente,Integer> {
    
}
