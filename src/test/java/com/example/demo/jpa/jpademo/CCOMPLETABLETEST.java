package com.example.demo.jpa.jpademo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CCOMPLETABLETEST {

    @Test
    public void completableapply() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture.supplyAsync(() -> "hello from ist");

        CompletableFuture f = c.thenApply(x -> x + " hello from apply");

        System.out.println(f.get());


    }

    @Test
    public void completablecompose() throws ExecutionException, InterruptedException {
        CompletableFuture c = CompletableFuture.supplyAsync(() -> "hello from ist");

        CompletionStage f = c.thenCompose(x -> x);


        //f.thenAccept(()-> System.out.println("got it"));


    }

    @Test
    public void singleThread() throws ExecutionException, InterruptedException {
        
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("submitting " + 1000));

        Callable<String> callable = () -> {
            // Perform some computation
            Thread.sleep(2000);
            return "Return some result";
        };

    }

     //AtomicReference<Boolean>  sayHello = new AtomicReference<>(false);
    //private static boolean sayHello = false;
    private static volatile boolean sayHello = false;
    @org.junit.jupiter.api.Test
    public  void atomicReference() throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (!sayHello)
            {
            }

            System.out.println("Hello World!");

            while (sayHello) {
            }

            System.out.println("Good Bye!");
        });

        thread.start();

        Thread.sleep(1000);
        System.out.println("Say Hello..");
        //sayHello = new AtomicReference<>(true);
        sayHello = true;

        Thread.sleep(1000);
        System.out.println("Say Bye..");
        //sayHello = new AtomicReference<>(false);
        sayHello = false;

    }

}

