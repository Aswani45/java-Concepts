import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableAndCallable {

    static void main() throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();


        //here since runnable does not return anything
        executor.submit(()->{
            System.out.println("Hello from Runnable");
        });

        Runnable r = ()->{
            System.out.println("Hello from Runnable 2");
        };
        executor.submit(r);

        //run funciton of runnable does not return anything ..


        //this funciton is callable , since it is returnig a value
        Future<Integer> future = executor.submit(()->{
            return 5;
        });


        //get function waits till executon gets over
        System.out.println(future.get());

    }
}
