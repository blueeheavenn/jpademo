package com.example.demo.jpa.jpademo;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LIST {

    @Test
    public void datastruct(){

        List<String> l= new LinkedList<>();
        String[] str={};

        Integer[] i={};

        str= new String[]{"ami", "t"};



        i[0]=1;
        i[1]=1;
        i[2]=1;
        i= new Integer[]{3, 4, 5};

    }

    @Test
    public void listtoarray(){

        List<String> list      = new ArrayList<>();

        list.add("element 1");
        list.add("element 2");
        list.add("element 3");
        list.add("element 3");

        Object[] objects =  list.toArray();
        for (Object str: objects){
            System.out.println(str.toString());
        }
    }


    @Test
    public void testcomparator(){

        List<Car> list = new ArrayList<>();


        list.add(new Car("Volvo V40" , "XYZ 201845", 5));
        list.add(new Car("Citroen C1", "ABC 164521", 4));
        list.add(new Car("Dodge Ram" , "KLM 845990", 2));




        SortedSet sortedSet2 = new TreeSet(Comparator.comparing(Car::getBrand).thenComparing(car->car.noOfDoors));

        //List<String> listset = new ArrayList<>(set);

        //Collections.sort(list);

        sortedSet2.forEach(System.out::println);

        SortedSet sortedSet = new TreeSet();

        sortedSet.add("a");
        sortedSet.add("b");
        sortedSet.add("c");
        sortedSet.add("d");
        sortedSet.add("e");



        //headSet.forEach(System.out::println);




    }


}
@Data
 class Car{
    public String brand;
    public String numberPlate;
    public int noOfDoors;

    public Car(String brand, String numberPlate, int noOfDoors) {
        this.brand = brand;
        this.numberPlate = numberPlate;
        this.noOfDoors = noOfDoors;
    }
}


