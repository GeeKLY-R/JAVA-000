import java.util.concurrent.*;

public class UseCompletionService {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();

        // 在这里创建一个线程或线程池
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        CompletionService completionService = new ExecutorCompletionService<>(executorService);

        // 异步执行 下面方法
        Future<Integer> task = completionService.submit(() -> sum());//这是得到的返回值

        // 确保  拿到result 并输出
        System.out.println("异步计算结果为：" + task.get());
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");

        // 然后退出main线程
        executorService.shutdown();
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
