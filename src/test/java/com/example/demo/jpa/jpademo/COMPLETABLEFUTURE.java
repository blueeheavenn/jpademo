package com.example.demo.jpa.jpademo;


import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class COMPLETABLEFUTURE {
   @Test
    public void cF(){

       CompletableFuture<String> completableFuture = new CompletableFuture<String>();



       System.out.println(completableFuture.getNow("got it"));
    }

    @Test
    public void supplyasync(){
        System.out.println("thread  "+Thread.currentThread().getName());

        CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("thread in supply    "+Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);

            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
            return "Some Result";
        }).thenApply(result -> {
    /*
      Executed in the same thread where the supplyAsync() task is executed
      or in the main thread If the supplyAsync() task completes immediately (Remove sleep() call to verify)
    */      System.out.println("thread in apply "+Thread.currentThread().getName());
            return "Processed Result";
        });
    }


}
