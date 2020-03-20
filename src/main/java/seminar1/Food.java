package seminar1;

import java.util.Objects;

public class Food {
    private final String Name;
    private final double Count;

    public Food(String Name, double Count) {
        this.Name=Name;
        this.Count=Count;
    }

    public String getName() {
        return Name;
    }

    public double getCount() {
        return Count;
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
