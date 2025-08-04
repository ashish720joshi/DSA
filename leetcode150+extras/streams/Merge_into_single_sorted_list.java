// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
import java.util.stream.*; 

class Main {
    public static void main(String[] args){
    List<Integer> list1 = Arrays.asList(1, 3, 5, 7, 9);
    List<Integer> list2 = Arrays.asList(2, 4, 6, 8, 10);
    List<Integer>list3=Stream.concat(list1.stream(),list2.stream()).sorted().collect(Collectors.toList());
    System.out.println(list3);
    }
    
}