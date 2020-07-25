package createThread;

/**
 * @Author alex.chen
 * @Date 2020-05-31 17:42
 * @Version 1.0
 *
 * 守护线程的创建：
 *
 * Java中有两种线程，一种是用户线程，另一种是守护线程。
 *
 * 用户线程是指用户自定义创建的线程，主线程停止，用户线程不会停止。
 *
 * 守护线程当进程不存在或主线程停止，守护线程也会被停止。
 */
public class DemoDaemon {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(10);
                    } catch (Exception e) {
                    }
                    System.out.println("子线程..." + i);
                }
            }
        });

        // 设置线程为守护线程
        thread.setDaemon(true);
        thread.start();

        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(10);
                System.out.println("主线程" + i);
            } catch (Exception e) {

            }
        }


        System.out.println("主线程执行完毕!");
    }

    }


