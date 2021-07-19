package com.example.demo.jpa.jpademo.dto;

import org.junit.Test;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class THREAD {

   @Test
   public void priorityTest() throws InterruptedException {

       Thread one=new Thread(()-> System.out.println("thread one running"));

       Thread two=new Thread(()-> System.out.println("thread two running"));

       Thread three=new Thread(()-> System.out.println("thread three running"));

       one.run();
       one.join();
       two.run();
       two.join();
       three.run();
       three.join();



    }

    @Test
    public void prioritytest2() throws InterruptedException {

        Thread one=new Thread(()->

        { System.out.println("thread one running   "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });



        Thread two=new Thread(()->

        { System.out.println("thread two running   "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });



        Thread three=new Thread(()->
        {
            System.out.println("thread three running   "+Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
//        one.setPriority(1);
//        two.setPriority(5);
//        three.setPriority(10);

        one.start();
        //one.join();
        two.start();
        //two.join();
        three.start();
        //three.join();
    }

    volatile boolean producerB=true;
    volatile boolean consumerB =true;

    @Test
    public void producerconsumer() throws InterruptedException {
        BlockingQueue q=  new LinkedBlockingDeque<>();

        Thread producer = new Thread(() -> {
            while (producerB) {
                System.out.println("producer running " + Thread.currentThread().getName());
                try {
                    q.add("adding");

                    Thread.sleep(10);
                    //producerB=true;

                } catch (InterruptedException e) {
                    e.printStackTrace();

                }
            }

        });


        Thread consumer=new Thread(()->{
            while (consumerB) {
                q.remove("adding");
                System.out.println("consumer running    " + Thread.currentThread().getName());
                try {
                    Thread.sleep(10);


                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });


            producer.start();
            //consumerB=true;
            //producerB=false;




            consumer.start();
           // producerB=true;
            //consumerB=false;

    }
}
