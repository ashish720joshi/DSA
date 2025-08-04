import java.util.*;

// Calculate longestString
class Streams {
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        
        List<String> strings = Arrays
              .asList("apple", "banana", "cherry", "date", "grapefruit");
              
         String longestString=strings.stream().max((o1,o2)->o2.length()-o1.length()).get();
         longestString=strings.stream().max(Comparator.comparingInt(String::length));
         System.out.println(longestString);
    }
}


// calculate Average
import java.util.*;

class Main {
    static class Person{
        String name;
        int age;
        Person(String name,int age){
            this.name=name;
            this.age=age;
        }
        int getAge(){
            return age;
        }
    }
    public static void main(String[] args){
         
    List<Person> persons = Arrays.asList(
    new Person("Alice", 25),
    new Person("Bob", 30),
    new Person("Charlie", 35)
);
double avgAge=persons.stream().mapToInt(Person::getAge).average().orElse(0);
System.out.println(avgAge);
    }
}

