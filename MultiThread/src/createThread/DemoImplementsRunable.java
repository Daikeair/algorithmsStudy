package createThread;

/**
 * @Author alex.chen
 * @Date 2020-05-31 17:39
 * @Version 1.0
 */
public class DemoImplementsRunable  {
    public static void main(String[] args) {

        new Thread(()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "执行内容：" + i);
            }
        }).start();

        new Thread(()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i < 5; i++) {
                System.out.println(name + "执行内容：" + i);
            }
        }).start();


    }
}
