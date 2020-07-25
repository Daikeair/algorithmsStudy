package concurrentcollection;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author alex.chen
 * @Date 2020-06-03 17:22
 * @Version 1.0
 */
public class DemoConcurrentHashMap3 {
    public static void main(String[] args) {
        //final Map<String, Integer> count = new HashMap<>();
       final Map<String, Integer> count = new ConcurrentHashMap<>();
        //final Hashtable<String, Integer> count = new Hashtable<>();

        for (int i = 0; i < 2000; i++) {
            count.put("count" + i, 1);
        }

        Runnable task1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 500; i++) {
                    count.remove("count" + i);
                }
            }
        };
        Runnable task2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 1000; i < 1500; i++) {
                    count.remove("count" + i);
                }
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();

        try {
            Thread.sleep(1000L);
            System.out.println(count.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

