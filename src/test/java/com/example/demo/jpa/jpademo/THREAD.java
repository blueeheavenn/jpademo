package com.example.demo.jpa.jpademo;

import org.junit.Test;

import java.util.Collections;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class THREAD {

    int i=0;
    @Test
    public void testThread() throws InterruptedException {

        ThreadLocal<Integer> t1l1=new ThreadLocal<>();
        //ThreadLocal<Integer> t2l2=new ThreadLocal<>();

        Thread t1=new Thread(()-> {
            for (i = 1; i < 4; i++) {
                //System.out.println("t1 running  "+i);
                 t1l1.set(i);

            }
            System.out.println("value in t1 "+t1l1.get());
            t1l1.remove();
        });



        Thread t2=new Thread(()-> { for ( i = 4; i <7 ; i++) {
            //System.out.println("t2 running  "+i);
           t1l1.set(i);

        }
            System.out.println("value in t2 "+t1l1.get());
        });

        t1.start();
        t2.start();

        //t1.join();
       // t2.join();




    }
    private   boolean sayHello = false;
    @Test
    public void tesVolatile() throws InterruptedException {


            Thread thread1 = new Thread(() -> {
                System.out.println("Say Hello..");
                sayHello = true;
                while (sayHello) {
                    System.out.println("Hello World!");
                    System.out.println("Thread in hello "+Thread.currentThread().getName());
                    sayHello = false;
                }
            });



                Thread thread2 = new Thread(()->{
                    System.out.println("Say Bye..");
                    sayHello = false;
            while(!sayHello) {
                        System.out.println("Good Bye!");
                System.out.println("Thread in bye "+Thread.currentThread().getName());
                sayHello=true;
            }


            });



        //Thread.sleep(1000);

        thread1.start();
        //thread1.run();


        //Thread.sleep(1000);

        //thread2.start();
        thread2.run();

    }

    @Test
    public void testExecutoeservice(){
        ExecutorService executor= Executors.newFixedThreadPool(2);

        Runnable thread1 = () -> {
            System.out.println("Say Hello..");
            sayHello = true;
            while (sayHello) {
                System.out.println("Hello World!");
                System.out.println("Thread in hello "+Thread.currentThread().getName());
                sayHello = false;
            }
        };



        Runnable thread2 = ()->{
            System.out.println("Say Bye..");
            sayHello = false;
            while(!sayHello) {
                System.out.println("Good Bye!");
                System.out.println("Thread in bye "+Thread.currentThread().getName());
                sayHello=true;
            }
        };

        executor.submit(thread1);
        executor.submit(thread2);
        //executor.execute(()-> System.out.println());
        Collections.EMPTY_LIST.forEach(x->
                System.out.println(x));




    }

}
