package function;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author alex.chen
 * @Date 2020-05-19 21:54
 * @Version 1.0
 */
public class ComparatorDemo {

    private static Comparator<String> newComparator() {
        return (a,b)->b.length()-a.length();
    }

    public static void main(String[] args) {
        String[] array = {"abc", "ab", "abcd"};
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, newComparator());
        System.out.println(Arrays.toString(array));
    }
}
