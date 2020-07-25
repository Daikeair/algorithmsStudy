package threadPoolDemo;

import java.util.Date;

/**
 * @Author alex.chen
 * @Date 2020-05-11 17:40
 * @Version 1.0
 * 这是一个简单的线程Runable Demo类
 */
public class MyRunable implements Runnable {

    private String command;
    public MyRunable(String s){
        this.command=s;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "start time" + new Date());

        processCommand();

        System.out.println(Thread.currentThread().getName() + "end time" + new Date());


    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @Override
    public String toString() {
        return "MyRunable{" +
                "command='" + command + '\'' +
                '}';
    }
}
