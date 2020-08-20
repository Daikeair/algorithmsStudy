package jucutils;

import java.util.concurrent.Semaphore;

/**
 * @Author alex.chen
 * @Date 2020-06-03 16:30
 * @Version 1.0
 */
public class DemoSemaphore {

        public static void main(String[] args) {
            Parking parking = new Parking(3);
            for (int i = 0; i < 5; i++) {
                new Car(parking).start();
            }
        }

        static class Parking {
            //信号量
            private Semaphore semaphore;

            Parking(int count) {
                semaphore = new Semaphore(count);
            }

            public void park() {
                try {
                    //获取信号量
                    semaphore.acquire(2);
                    long time = (long) (Math.random() * 10);
                    System.out.println(Thread.currentThread().getName() + "进入停车场，停车" + time + "秒...");
                    Thread.sleep(time);
                    System.out.println(Thread.currentThread().getName() + "开出停车场...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //释放信号量
                    semaphore.release();
                }
            }
        }

        static class Car extends Thread {
            Parking parking;

            Car(Parking parking) {
                this.parking = parking;
            }

            @Override
            public void run() {
                //进入停车场
                parking.park();
            }
        }
    }

