package function;

import java.util.function.Consumer;

/**
 * @Author alex.chen
 * @Date 2020-05-19 22:21
 * @Version 1.0
 *
 * 字符串数组当中存有多条信息，请按照格式“ 姓名：XX。性别：XX。 ”的格式将信息打印出来
 */
public class ComsumerDemo {
    public static void main(String[] args) {
        String[] array = {"迪丽热巴,女", "古力娜扎,女", "马尔扎哈,男"};
        printInfo(s -> System.out.print("姓名：" + s.split(",")[0]),
                s -> System.out.println("。性别：" + s.split(",")[1] + "。"), array);
    }

    private static void printInfo(Consumer<String> one, Consumer<String> two, String[] array) {
        for (String info : array) {
            // 姓名：迪丽热巴。性别：女。
            one.andThen(two).accept(info);


        }
    }
}