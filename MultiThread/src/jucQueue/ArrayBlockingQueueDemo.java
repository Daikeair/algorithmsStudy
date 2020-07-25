package jucQueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author alex.chen
 * @Date 2020-06-03 18:18
 * @Version 1.0
 */
public class ArrayBlockingQueueDemo {
    //最大容量为5的数组阻塞队列
    private static ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5, true);
    //private static LinkedBlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);

    public static void main(String[] args) {

        Thread t1 = new Thread(new ProducerTask());
        Thread t2 = new Thread(new ConsumerTask());

        //启动线程
        t1.start();
        t2.start();

    }

    //生产者
    static class ProducerTask implements Runnable {
        private Random rnd = new Random();

        @Override
        public void run() {
            try {
                while (true) {
                    int value = rnd.nextInt(100);
                    //如果queue容量已满，则当前线程会堵塞，直到有空间再继续
                    queue.put(value);

                    System.out.println("生产者：" + value);

                    TimeUnit.MILLISECONDS.sleep(100); //线程休眠
                }
            } catch (Exception e) {
            }
        }
    }

    //消费者
    static class ConsumerTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    //如果queue为空，则当前线程会堵塞，直到有新数据加入
                    Integer value = queue.take();

                    System.out.println("消费者:" + value);

                    TimeUnit.MILLISECONDS.sleep(15); //线程休眠
                }
            } catch (Exception e) {
            }
        }
    }
}
