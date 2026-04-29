package List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


/*
*
* for easy understanding
return o1-o2 :

If o1 is smaller than o2, the answer is negative → tells Java “o1 comes first.”
If o1 is bigger than o2, the answer is positive → tells Java “o2 comes first.”

If they’re the same, the answer is 0 → order doesn’t change.

return o2 - o1

If o2 is smaller than o1, the answer is negative → tells Java “o2 comes first” → bigger numbers come first.
If o2 is bigger than o1, the answer is positive → tells Java “o1 comes first” → bigger numbers still come first.

If they’re the same, the answer is 0 → order doesn’t change.

In short:
o1 - o2 → sorts small → big (ascending)
o2 - o1 → sorts big → small (descending)
* */


class IntegerComp implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
           //o1-o2 = ascending
          // o2-o1 = descending


        return o2 - o1;
    }
}

class StringComp implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        //o1-o2 = ascending
        // o2-o1 = descending


        return o2.length() - o1.length();   //descendingg value
    }
}

class Student{

    String name;
    double gpa;


    Student(String name,double gpa){
        this.name = name;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }



}



public class B_Comparator {

    public void compp(){

        ArrayList<String> fruity = new ArrayList<>(List.of("Tomato","Apple","Banana","Cherry","dragonfruit","dates","Date"));
        System.out.println("Fruity array: " + fruity);

        fruity.sort(null);
        System.out.println("Sorted Fruits: " + fruity);

        fruity.sort(new StringComp());
        System.out.println("Sorted by length (descending) Fruity: " + fruity);

        ArrayList<Integer> intt = new ArrayList<>(List.of(2,5,1,9,6));
        System.out.println("og intt:" + intt);

        intt.sort(null);
        System.out.println("sort intt:" + intt);

        intt.sort(new IntegerComp());
        System.out.println("comparator intt:" + intt);

        intt.sort((a,b)-> a-b);
        System.out.println("Lambda sort: " + intt);

        List<String> words = new ArrayList<>(Arrays.asList("Oven","Refrigerator","Dryer","Washer","Cameras"));
        words.sort((a,b) -> a.length() - b.length());
        System.out.println("Lambda Words" + words);

        
        List<Student> students = new ArrayList<>();
        students.add(new Student("Charlie",3.5));
        students.add(new Student("Bob",3.7));
        students.add(new Student("Alice",3.5));
        students.add(new Student("Akshita",3.9));

        //First compared by gpa.. and in case of same gpa, compare by name.

        Comparator<Student> comparator1  = Comparator.comparing(Student::getGpa).reversed().thenComparing(Student::getName);

        students.sort(comparator1);

        for(Student stu : students){
            System.out.println(stu.getName() + " : "+ stu.getGpa());
        }


    }
}
