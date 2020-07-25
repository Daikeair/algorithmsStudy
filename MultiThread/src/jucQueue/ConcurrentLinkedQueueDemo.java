package jucQueue;

import java.util.Date;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Author alex.chen
 * @Date 2020-06-03 17:56
 * @Version 1.0
 */
public class ConcurrentLinkedQueueDemo {

    public static void main(String[] args) throws Exception {
        Queue<String> queue = new ConcurrentLinkedQueue<String>();
        for (int i = 0; i < 10000; i++) {
            //队列中添加元素
            queue.add(String.valueOf(i));
        }

        QueueDemo1 demo1 = new QueueDemo1(queue);

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(demo1);
            t.start();
        }
    }
}
class QueueDemo1 implements Runnable {
    Queue<String> queue;

    public QueueDemo1(Queue<String> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        try {
            long start = System.currentTimeMillis();
            //检索并移除此队列的头，如果此队列为空，则返回 null
            while (queue.poll() != null) {
                //if (queue.size() == 0) {
                //}

                if (queue.isEmpty()) {
                }
            }
            System.out.println(System.currentTimeMillis() - start);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
