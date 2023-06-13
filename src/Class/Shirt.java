package Class;

import java.io.Serializable;

public class Shirt implements Serializable {
    private int Id;
    private String material;
    private String size;
    private String color;
    private String type;

    public Shirt(int id, String material, String size, String color, String type) {
        Id = id;
        this.material = material;
        this.size = size;
        this.color = color;
        this.type = type;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String Material) {
        this.material = Material;
    }


    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "[Id=" + Id + ",\n Material of the shirt=" + material + ",\n Size=" + size + ",\n Color=" + color + ", \n Type=" + type + "]\n";
    }
}