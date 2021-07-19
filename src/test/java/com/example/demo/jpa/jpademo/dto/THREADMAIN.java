package com.example.demo.jpa.jpademo.dto;

import java.util.concurrent.TimeUnit;

public class THREADMAIN {
    public static void main(String[] args) throws InterruptedException {
        Thread one=new Thread(()->

        { System.out.println("thread one running   ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });

        //one.setPriority(10);

        Thread two=new Thread(()->

                { System.out.println("thread two running   ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        });
        //two.setPriority(5);


        Thread three=new Thread(()->
                {
                        System.out.println("thread three running   ");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        });

        //three.setPriority(1);

        one.setPriority(Thread.MIN_PRIORITY);
        two.setPriority(Thread.NORM_PRIORITY);
        three.setPriority(Thread.MAX_PRIORITY);

        one.start();
        //one.join();
        two.start();
        //two.join();
        three.start();
        //three.join();
    }
}
