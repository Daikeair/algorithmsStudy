package jucutils;

import java.util.concurrent.Semaphore;

/**
 * @Author alex.chen
 * @Date 2020-07-26 00:06
 * @Version 1.0
 */
public class LeetcodeCyclicBarrierAndSemaphore {
    public static void main(String[] args) {

        H2O h2o = new H2O();
        int n = 5;

        new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    h2o.hydrogen(() -> System.out.println("H"));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    h2o.hydrogen(() -> System.out.println("H"));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                for (int i = 0; i < n; i++) {
                    h2o.oxygen(() -> System.out.println("O"));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static class H2O {

        private Semaphore s1, s2, s3, s4;

        public H2O() {
            s1 = new Semaphore(2); // H线程信号量
            s2 = new Semaphore(1); // O线程信号量

            s3 = new Semaphore(0); // 反应条件信号量
            s4 = new Semaphore(0); // 反应条件信号量
        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            s1.acquire(); // 保证只有2个H线程进入执行
            s3.release(); // 释放H原子到达信号
            s4.acquire(); // 等待O原子到达
            releaseHydrogen.run();
            s1.release(); // 相当于唤醒1个H线程
        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            s2.acquire(); // 保证只有1个O线程进入执行
            s4.release(2); // 释放O原子到达信号，因为有2个H线程等待所以释放2个
            s3.acquire(2); // 等待H原子到达，2个原因同上
            releaseOxygen.run();
            s2.release(); // 相当于唤醒1个O线程
        }

    }
}
