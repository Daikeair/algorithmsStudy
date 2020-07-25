package lock;

/**
 * @Author alex.chen
 * @Date 2020-05-10 23:17
 * @Version 1.0
 * 双重校验锁实现单例模式
 */
public class Singleton {
    /**
     * uniqueInstance 采用 volatile 关键字修饰也是很有必要的， uniqueInstance = new lock.Singleton(); 这段代码其实是分为三步执行：
     * 1.为 uniqueInstance 分配内存空间
     * 2.初始化 uniqueInstance
     * 3.将 uniqueInstance 指向分配的内存地址
     * 但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2
     * 使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
     *
     */
    private volatile static Singleton uniqueInstance;

    private Singleton(){

    }

    public static Singleton getUniqueInstance(){
        //先判断对象是否已经实例化，若没有实例化才进入加锁代码
        if(uniqueInstance==null){
            //类对象加锁
            synchronized (Singleton.class){
                if (uniqueInstance==null){
                    uniqueInstance=new Singleton();
                }
            }
        }
        return uniqueInstance;
    }

}
