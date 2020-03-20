package seminar1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Serialaze {

    public static void serialize(List<Animal> listAnimal, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(listAnimal);
            System.out.println("File has been written");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static List<Animal> deserialize(String fileName) {

        ArrayList<Animal> newAnimal = new ArrayList<Animal>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            newAnimal = ((ArrayList<Animal>) ois.readObject());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return newAnimal;

    }


}
