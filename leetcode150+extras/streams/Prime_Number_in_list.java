// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;

class Main {
    static boolean isPrime(int n){
        if(n<=1) return false;
        if(n==2) return true;
         if (n % 2 == 0) return false; 
         for(int i=3;i<=Math.sqrt(n);i+=2){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void main(String[] args){
         List<Integer> numbers = Arrays.asList(4, 6, 8, 10, 18, 12, 20, 14, 15);
boolean isPrime=numbers.stream().anyMatch(Main::isPrime);
System.out.println(isPrime);
    }
    
}