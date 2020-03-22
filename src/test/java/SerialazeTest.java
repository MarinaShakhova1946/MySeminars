import org.junit.Test;
import seminar1.Animal;
import seminar1.Food;
import seminar1.KindAnimal;
import seminar1.Serialaze;

import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.*;

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
    public void serialize() throws IOException, ClassNotFoundException {
        Serialaze.serialize(animalList, "animalFile");
        assertEquals(animalList, Serialaze.deserialize("animalFile"));
    }

    @Test
    public void serializeEmpty() throws IOException, ClassNotFoundException{
        Serialaze.serialize(Collections.emptyList(), "emptyFile");
        assertEquals(Collections.emptyList(), Serialaze.deserialize("emptyFile"));
    }

    @Test
    public void serializerTwoLists() throws IOException, ClassNotFoundException{
        Serialaze.serialize(animalList1, "animalFile1");
        Serialaze.serialize(animalList2,"animalFile2");
        assertEquals(animalList1, Serialaze.deserialize("animalFile1"));
        assertEquals(animalList2, Serialaze.deserialize("animalFile2"));
        assertNotEquals(animalList1, Serialaze.deserialize("animalFile2"));
        assertNotEquals(animalList2, Serialaze.deserialize("animalFile1"));
    }

    @Test
    public void serializeException() throws ClassNotFoundException {
        try {
            Serialaze.deserialize("hcska");
            fail();
        } catch (NoSuchFileException e) {

        } catch (IOException e) {
            fail();
        }
    }

    @Test
    public void dataSerialize() throws IOException, ClassNotFoundException {
        Serialaze.serializeData(animalList, "dataanimalFile");
        assertEquals(animalList, Serialaze.deserializeData("dataanimalFile"));
    }

    @Test
    public void dataSerializeEmpty() throws IOException, ClassNotFoundException {
        Serialaze.serializeData(Collections.emptyList(), "dataemptyFile");
        assertEquals(Collections.emptyList(), Serialaze.deserializeData("dataemptyFile"));
    }

    @Test
    public void dataserializeTwoLists() throws IOException, ClassNotFoundException{
        Serialaze.serializeData(animalList1, "dataanimalFile1");
        Serialaze.serializeData(animalList2,"dataanimalFile2");
        assertEquals(animalList1, Serialaze.deserializeData("dataanimalFile1"));
        assertEquals(animalList2, Serialaze.deserializeData("dataanimalFile2"));
        assertNotEquals(animalList1, Serialaze.deserializeData("dataanimalFile2"));
        assertNotEquals(animalList2, Serialaze.deserializeData("dataanimalFile1"));
    }

    @Test
    public void dataSerializeException() throws ClassNotFoundException {
        try {
            Serialaze.deserializeData("hcska");
            fail();
        } catch (NoSuchFileException e) {

        } catch (IOException e) {
            fail();
        }

    }

}



