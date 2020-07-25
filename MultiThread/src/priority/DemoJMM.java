package priority;

/**
 * @Author alex.chen
 * @Date 2020-06-01 01:01
 * @Version 1.0
 * 内存可见性
 * 按照main方法的逻辑，我们已经把flag设置为false，那么从逻辑上讲，子线程就应该跳出while死循环，
 * 因为这个时候条件不成立，但是我们可以看到，程序仍旧执行中，并没有停止。
 */
public class DemoJMM {
    public static void main(String[] args) throws InterruptedException {

        JmmDemo demo = new JmmDemo();
        Thread t = new Thread(demo);
        t.start();
        Thread.sleep(100);
        demo.flag = false;
        System.out.println("已经修改为false");
        System.out.println(demo.flag);
    }

    static class JmmDemo implements Runnable {
        public boolean flag = true;
        @Override
        public void run() {
            System.out.println("子线程执行。。。");
            while (flag) {
//                synchronized (this){
//                    System.out.println(this);
//                }
            }
            System.out.println("子线程结束。。。");
        }
    }
}
