package com.example.demo.jpa.jpademo.dto;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MAP {

    @Test
    public void treeeMap(){
        TreeMap<Integer, String> tmap =
                new TreeMap<Integer, String>();

        tmap.put(1, "Data1");
        tmap.put(23, "Data2");
        tmap.put(70, "Data3");
        tmap.put(4, "Data4");
        tmap.put(2, "Data5");

        tmap.forEach((x,y)-> System.out.println("key    "+ x+"  value   "+y));

        for (Map.Entry<Integer,String> entry : tmap.entrySet()){
        System.out.println(entry.getKey() + "   "+ entry.getValue());

        }

        tmap.entrySet().stream()
        .forEach((e-> System.out.println(e.getKey()+" "+ e.getValue())));
    
        //Map<String, Integer> m=tmap.forEach((x,y)-> Collectors.toMap())

    }

    @Test
    public void nulltest(){

        Map map = new HashMap();

        map.put("a", null);
        map.put("b", null);
        map.put("c", null);

        //System.out.println(map.getOrDefault("e","default val"));

        System.out.println(map.computeIfAbsent("a", x->x.equals(x)));
    }
}
