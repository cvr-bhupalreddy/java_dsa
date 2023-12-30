package completablefuture;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.sleep;

public class ThreadOfExecution {

    public static int compute() throws InterruptedException {

        System.out.println("In Compute Thread : " +  Thread.currentThread());

        sleep(1000);

        return 2;

    }

    public static CompletableFuture<Integer> create(){
        System.out.println("In Create  Thread : " +  Thread.currentThread());
        return CompletableFuture.supplyAsync(() -> {
            try {
                return compute();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static  void printIt(int value){
        System.out.println(value + " __ "+ Thread.currentThread());
    }

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture<Integer> integerPipeline = new CompletableFuture<Integer>()
                .thenApply(data -> data * 2)
                .thenApply(data -> data + 1);
        System.out.println("Prepared Pipeline");

        integerPipeline.thenAccept(data -> System.out.println(data));

        System.out.println("Prepared Print ");

        sleep(1000);

        integerPipeline.complete(2);


        System.out.println("In Main " + Thread.currentThread());

        CompletableFuture<Integer> future = create();

            sleep(100);

        future.thenAccept(data -> printIt(data) ); // Completable Future may not complete , main Thread will not block

        sleep(1000);
        System.out.println("Main Thread Completed ");
    }
}
