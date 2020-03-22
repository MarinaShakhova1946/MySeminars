package seminar1;

import java.io.Serializable;
import java.util.Objects;

public class Food implements Serializable {
    private String Name;
    private int Count;

    public Food(String Name, int Count) {
        this.Name=Name;
        this.Count=Count;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int Count) {
        this.Count = Count;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + Name + '\'' +
                ", count=" + Count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Count == food.Count &&
                Objects.equals(Name, food.Name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Count);
    }
}
