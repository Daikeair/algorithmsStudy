package threadPoolDemo;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Author alex.chen
 * @Date 2020-06-04 00:07
 * @Version 1.0
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) throws Exception{
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
        System.out.println("程序开始：" + new Date());
        // 第二个参数是延迟多久执行
        scheduledThreadPool.schedule(new Task(), 0, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(new Task(), 1, TimeUnit.SECONDS);
        scheduledThreadPool.schedule(new Task(), 5, TimeUnit.SECONDS);

        Thread.sleep(5000);

        // 关闭线程池
        scheduledThreadPool.shutdown();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                String name = Thread.currentThread().getName();

                System.out.println(name + ", 开始：" + new Date());
                Thread.sleep(1000);
                System.out.println(name + ", 结束：" + new Date());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
