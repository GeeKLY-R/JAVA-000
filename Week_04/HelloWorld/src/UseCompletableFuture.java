import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class UseCompletableFuture {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        long start = System.currentTimeMillis();
        Integer result = CompletableFuture.supplyAsync(() -> sum()).join();//这是得到的返回值
        System.out.println("异步计算结果为：" + result);
        System.out.println("使用时间：" + (System.currentTimeMillis() - start) + " ms");
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
