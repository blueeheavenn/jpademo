package com.example.demo.jpa.jpademo;

import org.junit.jupiter.api.Test;

public class GENERICS<T extends Number> {
    T t;
//    GENERICS(T t){
//      this.t= t;
//    }

    @Test
    public void boundedGenericType(){
       // GENERICS<String> g=new GENERICS();



       //System.out.printf("MAX   "+  g.maximum(5.5));
                //"apple", "orange", maximum("pear", "apple", "orange"));
    }

    public T maximum(T x) {
        //  // assume x is initially the largest
        return x;

    }


}

 interface IExecutesService<A,B>
{
    A executeService();
    A executeService(B inputParameter);
}

