package Repository;
import Class.Shirt;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

abstract class ShirtRepoImpl implements ShirtRepository {

    private List<Shirt> shirtLists;

    public ShirtRepoImpl() throws IOException, ClassNotFoundException{
        shirtLists = new ArrayList<>();
    }

    @Override
    public Shirt findById(int id) {
        return shirtLists.stream()
                .filter(ShirtList -> ShirtList.getId() == id)
                .findFirst()
                .orElse(null);
    }


    @Override
    public List<Shirt> findAll() throws IOException, ClassNotFoundException {
        shirtLists = (List<Shirt>)  ShirtSerializer.readObjectFromFile("shirts.ax");
        return shirtLists;
    }

    @Override
    public void save(Shirt newshirt) throws IOException {
        shirtLists.add(newshirt);
        ShirtSerializer.writeObjectToFile(shirtLists, "shirts.ax");
    }

    @Override
    public void update(Shirt shirt) throws IOException {
        Shirt oldShirt = findById(shirt.getId());
        if (oldShirt != null) {
            shirtLists.remove(oldShirt);
            shirtLists.add(shirt);

            try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("Shirts.ax"))) {
                outputStream.writeObject(shirtLists);
            }
        }
    }

    @Override
    public void delete(Shirt shirt) throws IOException {
        shirtLists.remove(shirt);
        ShirtSerializer.writeObjectToFile(shirtLists, "shirts.ax");
    }
}
