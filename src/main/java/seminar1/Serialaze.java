package seminar1;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serialaze {

    public static void serialize(List<Animal> listAnimal, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(path))) {
            oos.writeObject(listAnimal);
        }
    }

    public static List<Animal> deserialize(String fileName) throws IOException, ClassNotFoundException{
        Path path = Paths.get(fileName);
        List<Animal> newAnimal ;
        try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(path))) {
            newAnimal = ((List<Animal>) ois.readObject());
        }
        return newAnimal;

    }

    public static void serializeData(List<Animal> listAnimal, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        try(DataOutputStream dos = new DataOutputStream(Files.newOutputStream(path))) {
            dos.writeInt(listAnimal.size());
            for (Animal currentAnimal : listAnimal) {
                dos.writeUTF(currentAnimal.getType().name());
                dos.writeUTF(currentAnimal.getName());
                dos.writeInt(currentAnimal.getAge());
                dos.writeInt(currentAnimal.getFoodList().size());
                for (Food currentFood : currentAnimal.getFoodList()) {
                    dos.writeUTF(currentFood.getName());
                    dos.writeInt(currentFood.getCount());
                }
            }
        }
    }

    public static List<Animal> deserializeData(String fileName) throws IOException{
        Path path = Paths.get(fileName);
        List<Animal> animalList = new ArrayList<>();
        String name;
        KindAnimal type;
        int age;
        try(DataInputStream dis = new DataInputStream(Files.newInputStream(path)))
        {
            int countAnimals = dis.readInt();
            for (int i = 0; i < countAnimals; i++) {
                type = KindAnimal.valueOf(dis.readUTF());
                name = dis.readUTF();
                age = dis.readInt();
                int countFood = dis.readInt();
                List<Food> arrayFood = new ArrayList<>();
                for (int j = 0; j < countFood; j++) {
                    String nameFood = dis.readUTF();
                    int count = dis.readInt();
                    arrayFood.add(new Food(nameFood, count));
                }
                animalList.add(new Animal(type, name, age, arrayFood));
            }
        }
        return animalList;
    }
}
