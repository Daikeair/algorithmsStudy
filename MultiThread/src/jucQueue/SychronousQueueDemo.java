package jucQueue;

import java.util.Random;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author alex.chen
 * @Date 2020-06-03 18:55
 * @Version 1.0
 */
public class SychronousQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        new Thread(new Product(queue)).start();
        new Thread(new Customer(queue)).start();
    }

    static class Product implements Runnable {
        SynchronousQueue<Integer> queue;
        Random r = new Random();

        public Product(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                int number = r.nextInt(1000);
                System.out.println("等待1秒后运送" + number);
                try {
                    TimeUnit.SECONDS.sleep(1);

                    queue.put(number);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Customer implements Runnable {
        SynchronousQueue<Integer> queue;

        public Customer(SynchronousQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("收到了:" + queue.take());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
