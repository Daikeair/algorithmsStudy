package function;

import java.util.function.Supplier;

/**
 * @Author alex.chen
 * @Date 2020-05-19 22:17
 * @Version 1.0
 */
public class SupplierDemo {
    public static String getString(Supplier<String> supplier) {
        return supplier.get();
    }

    public static void main(String[] args) {
        String msgA = "Hello";
        String msgB = "World";
        System.out.println(getString(()->msgA + msgB));
    }

}
