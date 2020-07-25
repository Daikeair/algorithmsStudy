package atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author alex.chen
 * @Date 2020-05-11 18:58
 * @Version 1.0
 */

public class AtomicIntegerTest {

   private AtomicInteger count= new AtomicInteger();

   //使用AtomicInteger之后，不需要将方法加锁，也可线程安全实现自增
    public void increment(){
        count.incrementAndGet();
    }

    public int getCount() {
        return count.get();
    }

}
