import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class UseForkJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

    long start = System.currentTimeMillis();

    // 在这里创建一个线程或线程池
    ForkJoinPool forkJoinPool = new ForkJoinPool(1);

    // 异步执行 下面方法
    ForkJoinTask<Integer> result = forkJoinPool.submit(() -> sum());//这是得到的返回值

    // 确保  拿到result 并输出
    System.out.println("异步计算结果为：" + result.get());
    System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

    // 然后退出main线程
    forkJoinPool.shutdown();
    forkJoinPool.awaitTermination(1, TimeUnit.SECONDS);
}

    private static int sum() {
        return fibo(36);
    }

    private static int fibo(int a) {
        if (a < 2) {
            return 1;
        }
        return fibo(a - 1) + fibo(a - 2);
    }

}
