import Class.Shirt;
import Repository.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/*
    public int Id;
    private String material;
    private String size;
    private String color;
    private String type;
 */

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opt;
        ShirtRepository shirtsList = new AbstractImpl();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Welcome To the Menu: \n 1.Add \n 2.Show List \n 3.Edit by ID \n 4.Delete \n 5.Search shirt by ID \n 6.Exit");
            opt = s.next();
            switch (opt) {
                case "1": {

                    System.out.println("Shirt Id: ");
                    int id = s.nextInt();
                    System.out.println("Material: ");
                    String material = s.next();
                    System.out.println("Size: ");
                    String size = s.next();
                    System.out.println("Shirt Color: ");
                    String color = s.next();
                    System.out.println("Type: ");
                    String type = s.next();
                    shirtsList.save(new Shirt(id, material, size, color, type));
                    ;
                    break;

                }

                case "2": {
                    List<Shirt> shirtsListAll = shirtsList.findAll();
                    shirtsListAll.forEach(System.out::println);
                    break;
                }
                case "3": {
                    System.out.println("=====Edit=====");
                    System.out.println("Id: ");
                    int id = s.nextInt();
                    System.out.println("Material: ");
                    String material = s.next();
                    System.out.println("Size: ");
                    String size = s.next();
                    System.out.println("Shirt Color: ");
                    String color = s.next();
                    System.out.println("Type: ");
                    String type = s.next();
                    Shirt update = new Shirt(id, material, size, color, type);
                    shirtsList.update(update);
                    break;
                }
                case "4": {
                    System.out.println("=====Delete=====");
                    System.out.println("Insert Id: ");
                    int id = s.nextInt();
                    shirtsList.delete(shirtsList.findById(id));
                    shirtsList.findAll().forEach(System.out::println);
                    break;
                }
                case "5": {
                    System.out.println("Insert ID of shirt:");
                    int id = s.nextInt();
                    System.out.println("The shirt selected is: \n" + shirtsList.findById(id));
                }
            }
        }while (!opt.equals("6")) ;
        System.out.println("Successfully exited!");
    }
}