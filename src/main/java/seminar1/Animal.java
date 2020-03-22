package seminar1;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class Animal implements Serializable {
    private KindAnimal Type;
    private String Name;
    private int Age;
    private List<Food> listFood;


    public Animal(KindAnimal Type, String Name, int Age, List<Food> Food) {
        this.Type = Type;
        this.Name = Name;
        this.Age = Age;
        this.listFood = Food;
    }

    public KindAnimal getType() {
        return Type;
    }

    public void setKindAnimal(KindAnimal Kind) {
        this.Type = Kind;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public List<Food> getFoodList() {
        return listFood;
    }

    public void setFoodList(List<Food> listFood) {
        this.listFood = listFood;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Kind='" + Type + '\'' +
                ", name=" + Name +
                ", age=" + Age +
                ", listfood=" + listFood +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Age == animal.Age &&
                Objects.equals(Name, animal.Name) &&
                Type == animal.Type &&
                Objects.equals(listFood, animal.listFood);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Type, Name, Age, listFood);
    }
}
