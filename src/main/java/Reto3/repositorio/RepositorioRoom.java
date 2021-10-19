
package Reto3.repositorio;

import java.util.List;
import java.util.Optional;

import Reto3.inter.InterfaceRoom;
import Reto3.modelo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class RepositorioRoom {
    
    @Autowired
    private InterfaceRoom crud;

    public List<Room> getAll(){
        return (List<Room>) crud.findAll();
    }

    public Optional<Room> getRoom(int id){
        return crud.findById(id);
    }

    public Room save(Room room){
        return crud.save(room);
    }
    public void delete(Room room){
        crud.delete(room);
    }
    
}
