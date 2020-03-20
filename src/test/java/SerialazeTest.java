import org.junit.Test;
import seminar1.Animal;
import seminar1.Food;
import seminar1.KindAnimal;
import seminar1.Serialaze;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SerialazeTest {

    List<Animal> animalList = Arrays.asList(
            new Animal(KindAnimal.BIRD, "parrot", 10, Arrays.asList(new Food("seeds", 100))),
            new Animal(KindAnimal.FISH, "shark", 25, Arrays.asList(new Food("fry", 1000))),
            new Animal(KindAnimal.MAMMALS, "bear", 30, Arrays.asList(new Food("honey", 10))),
            new Animal(KindAnimal.SPIDERS, "cross", 60, Arrays.asList(new Food("flies", 50))),
            new Animal(KindAnimal.AMPHIBIANS, "caudata", 10, Arrays.asList(new Food("flies", 100))));

    List<Animal> animalList1 = Arrays.asList(
            new Animal(KindAnimal.BIRD, "parrot", 10, Arrays.asList(new Food("seeds", 100))),
            new Animal(KindAnimal.FISH, "shark", 25, Arrays.asList(new Food("fry", 1000))),
            new Animal(KindAnimal.AMPHIBIANS, "caudata", 10, Arrays.asList(new Food("flies", 100))));

    List<Animal> animalList2 = Arrays.asList(
            new Animal(KindAnimal.MAMMALS, "bear", 30, Arrays.asList(new Food("honey", 10))),
            new Animal(KindAnimal.SPIDERS, "cross", 60, Arrays.asList(new Food("flies", 50))));

    @Test
    public void serialize() {
        Serialaze.serialize(animalList, "animalFile");
        Serialaze.deserialize("animalFile");
    }

    @Test
    public void serializeEmpty() {
        Serialaze.serialize(Collections.emptyList(), "emptyFile");
        Serialaze.deserialize("emptyFile");
    }

    @Test
    public void serializerTwoLists(){
        Serialaze.serialize(animalList1, "animalFile1");
        Serialaze.serialize(animalList2,"animalFile2");
        Serialaze.deserialize("animalFile1");
        Serialaze.deserialize("animalFile2");
    }
}

