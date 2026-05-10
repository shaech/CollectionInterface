package Hash;

import java.util.HashMap;
import java.util.Objects;

public class Studentt {


    //Generated Equals and Hashcode like generating getter and setter.

    //THis is specific for CUSTOM Classes
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Studentt studentt = (Studentt) o;
        return id == studentt.id && Objects.equals(name, studentt.name);
    }

    @Override
    public int hashCode() {
        System.out.println("HashCode: " + Objects.hash(name, id));
        return Objects.hash(name, id);
    }


     String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Studentt{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
