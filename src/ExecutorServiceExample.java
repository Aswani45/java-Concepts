import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {


    public static void main() {
        long startTIme = System.currentTimeMillis();


//        Thread [] threads = new Thread[9];
//        for(int i=1;i<10;i++){
//            final int FinalI = i;
//            threads[i-1] = new Thread(()->{
//                calculateFactorial(FinalI);
//            });
//            threads[i-1].start();
//        }
//        for(Thread t:threads){
//            try {
//                t.join();
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
    // SO the above logic , we need to manually create the threads ,
        //we were not able to re-use the threads , and joining logic also i s quite complicated , we can use
        //executor framework     for the same .


        ExecutorService executor = Executors.newFixedThreadPool(9);

        for(int i = 0 ;i<10;i++){
            int finalI = i;
            executor.submit(()->{
                calculateFactorial(finalI);
            });
        }

        // Shutdown the executor - no new tasks will be accepted
        executor.shutdown();

        // Wait for all tasks to complete
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("time taken "+(System.currentTimeMillis()-startTIme));
    }


    static public void calculateFactorial(int n){
        System.out.println("Factorial of "+n+" is "+factorial(n));
    }

    static private int factorial(int n) {
        if(n==0 || n==1){
            return 1;
        }
        return n*factorial(n-1);
    }
}
