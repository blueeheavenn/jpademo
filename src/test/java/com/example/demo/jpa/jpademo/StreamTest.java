package com.example.demo.jpa.jpademo;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {
    @Test
    void intrange(){

        IntStream.range(1, 3).forEach(System.out::println);
    }

    @Test
    void intrangeClosed(){

        IntStream.rangeClosed(1, 3).forEach(System.out::println);
    }

    @Test
    void stringSplit(){
        String str=" the monkey jumping on the wall is a donkey";
        Stream<String> splitString= Pattern.compile(" ").splitAsStream(str);
        Pattern.compile(" ").splitAsStream(str)
                .forEach(System.out::println);
        splitString.forEach(System.out::println);
        //splitString.forEach(System.out::println);



    }

    @Test
    void streamBuilder() {
        Stream<String> sb= Stream.<String>builder().add("ami").build();

    }

    StringBuilder s=new StringBuilder();
    String str="jumping from";
    Supplier<List<String>> list=()-> Pattern.compile("").splitAsStream(str)
            .collect(Collectors.toList());
    AtomicInteger size = new AtomicInteger(list.get().size());
    List<String> ll=new ArrayList<>();

    @Test
    void stringReverse(){

        list.get().stream().map(x->{
            ll.add(list.get().get(size.get()-1));
            size.getAndDecrement();
            return ll;
        }).flatMap(List::stream)
                .collect(Collectors.toList());

        String p=ll.stream().collect(Collectors.joining(""));

        System.out.println(p);


    }

    //List<String> li=new ArrayList<>();
    //Supplier<Stream<Character>> original= ()->str.chars().mapToObj(x->(char)x);
    String str3="jumping from";
    AtomicInteger sizel= new AtomicInteger(str3.length());
    StringBuilder sb=new StringBuilder();
    @Test
    void stringReverseUsingStream(){

       Stream<Object> f= str3.chars().mapToObj(x-> {
                   sb.append(str3.charAt(sizel.get()-1));
                   sizel.getAndDecrement();
                   return sb.toString() ;

               });


      System.out.println(f.count());

      
    }


    StringBuilder s2=new StringBuilder();
    String str2=" the monkey jumping on the wall is a donkey";
    int  len=str.length();
    char rev;
    @Test
    void stringReverseRecursive(String str){

        String rev=String.valueOf(str.charAt(len));
        s.append(rev);
        len--;
        if (len > - 1)
            stringReverseRecursive(str);


    }

    @Test
    void countduplicate(){
        StringBuilder s=new StringBuilder();
        String str=" the monkey jumping on the wall is a donkey";
        str=str.replaceAll("\\s+","");

        Map<Character, Long> m=
                str.chars().mapToObj(x->(char)x).collect(Collectors.groupingBy(Character::charValue,Collectors.counting()));

        System.out.println(m);

    }

    @Test
    public void flatmap() {
        Optional.of(new Outer())
                .flatMap(o -> Optional.ofNullable(o.nested))
                .flatMap(n -> Optional.ofNullable(n.inner))
                .flatMap(i -> Optional.ofNullable(i.foo))
                .ifPresent(System.out::println);

    }

    class Outer {
        Nested nested;
    }

    class Nested {
        Inner inner;
    }

    class Inner {
        String foo="ami";
    }

    @Test
    public void paralleism()
    {

        Arrays.asList("a1", "a2", "b1", "c2", "c1")
                //.parallelStream()
                .stream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .sorted((s1, s2) -> {
                    System.out.format("sort: %s <> %s [%s]\n",
                            s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));

    }
}
