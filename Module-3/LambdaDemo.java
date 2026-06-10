import java.util.*;
public class LambdaDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Ravi");
        list.add("Anu");
        list.add("Kiran");
        list.add("Balu");
        Collections.sort(list, (a, b) -> a.compareTo(b));
        System.out.println(list);
    }
}