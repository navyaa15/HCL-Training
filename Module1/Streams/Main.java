package Streams;
import java.util.*;

public class Main {
    static void main(){
//        ArrayList<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//
//        ArrayList<Integer> list2 = new ArrayList<>();
//        list.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
        ArrayList<String> list = new ArrayList<>();
        list.add("Ram");
        list.add("Shyam");
        list.add("Rahul");
        list.add("Sohan");
        list.add("Ramesh");
        list.add("Rachit");
        list.stream().filter(x -> x.startsWith("R")).forEach(System.out::println);
        list.stream().filter(x -> x.endsWith("T")).forEach(System.out::println);
        list.stream().filter(x -> x.startsWith("S")).forEach(System.out::println);
   }
}
