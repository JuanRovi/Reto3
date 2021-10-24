
package Reto3.servicios;

import java.util.List;
import java.util.Optional;

import Reto3.modelo.Room;
import Reto3.repositorio.RepositorioRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiciosRoom {
     @Autowired
    private RepositorioRoom metodosCrud;

    public List<Room> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Room> getRoom(int roomId) {
        return metodosCrud.getRoom(roomId);
    }

    public Room save(Room room){
        if(room.getId()==null){
            return metodosCrud.save(room);
        }else{
            Optional<Room> e=metodosCrud.getRoom(room.getId());
            if(e.isEmpty()){
                return metodosCrud.save(room);
            }else{
                return room;
            }
        }
    }

    public Room update(Room room){
        if(room.getId()!=null){
            Optional<Room> e=metodosCrud.getRoom(room.getId());
            if(!e.isEmpty()){
                if(room.getName()!=null){
                    e.get().setName(room.getName());
                }
                if(room.getHotel()!=null){
                    e.get().setHotel(room.getHotel());
                }
                if(room.getStars()!=null){
                    e.get().setStars(room.getStars());
                }
                if(room.getDescription()!=null){
                    e.get().setDescription(room.getDescription());
                }
                if(room.getCategory()!=null){
                    e.get().setCategory(room.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return room;
            }
        }else{
            return room;
        }
    }


    public boolean deleteRoom(int roomId) {
        Boolean aBoolean = getRoom(roomId).map(room -> {
            metodosCrud.delete(room);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
