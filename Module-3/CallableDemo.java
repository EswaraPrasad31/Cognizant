import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args)
            throws Exception {
        ExecutorService ex =
                Executors.newFixedThreadPool(2);
        Callable<Integer> c1 = () -> 10 + 20;
        Callable<Integer> c2 = () -> 30 + 40;
        Future<Integer> f1 = ex.submit(c1);
        Future<Integer> f2 = ex.submit(c2);
        System.out.println(f1.get());
        System.out.println(f2.get());
        ex.shutdown();
    }
}