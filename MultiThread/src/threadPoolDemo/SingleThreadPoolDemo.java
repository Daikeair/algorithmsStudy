package threadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author alex.chen
 * @Date 2020-06-03 23:45
 * @Version 1.0
 */
public class SingleThreadPoolDemo {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Demo());
            Thread.sleep(5);
        }
        exec.shutdown();
    }

    static class Demo implements Runnable {
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 2; i++) {
                count++;
                System.out.println(name + ":" + count);
            }
        }
    }
}
