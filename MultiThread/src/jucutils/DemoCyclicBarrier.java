package jucutils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author alex.chen
 * @Date 2020-06-03 15:34
 * @Version 1.0
 *
 * CyclicBarrier相当于一扇门，当所有线程都到达门口时，才开始开门放行，让所有线程一起通过
 *
 */
public class DemoCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(new Athlete(cyclicBarrier, "运动员" + i));
            threadList.add(t);
        }

        for (Thread t : threadList) {
            t.start();
        }
    }

    static class Athlete implements Runnable {

        private CyclicBarrier cyclicBarrier;
        private String name;

        public Athlete(CyclicBarrier cyclicBarrier, String name) {
            this.cyclicBarrier = cyclicBarrier;
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(name + "就位");
            try {
                cyclicBarrier.await();
                System.out.println(name + "跑到终点。");
            } catch (Exception e) {
            }
        }
    }
}
