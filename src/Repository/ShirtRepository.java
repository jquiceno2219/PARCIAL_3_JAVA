package Repository;
import Class.Shirt;

import java.io.IOException;
import java.util.List;
public interface ShirtRepository {

    Shirt findById(int id);


    List<Shirt> findAll() throws IOException, ClassNotFoundException;
    void save(Shirt fuelPoints) throws IOException;
    void update(Shirt fuelPoints) throws IOException;
    void delete(Shirt fuelPoints) throws IOException;
}