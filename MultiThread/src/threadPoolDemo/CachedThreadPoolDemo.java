package threadPoolDemo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author alex.chen
 * @Date 2020-06-03 23:53
 * @Version 1.0
 */
public class CachedThreadPoolDemo {
        public static void main(String[] args) throws InterruptedException {
            ExecutorService exec = Executors.newCachedThreadPool();
            for (int i = 0; i < 10; i++) {
                exec.execute(new Demo());
                Thread.sleep(1);
            }
            exec.shutdown();
        }

        static class Demo implements Runnable {
            @Override
            public void run() {
                String name = Thread.currentThread().getName();
                try {
                    //修改睡眠时间，模拟线程执行需要花费的时间
                    Thread.sleep(1);

                    System.out.println(name + "执行完了");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
