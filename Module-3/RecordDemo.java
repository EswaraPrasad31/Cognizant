import java.util.List;
record Person(String name, int age) {}
public class RecordDemo {
    public static void main(String[] args) {
        Person p1 = new Person("Ravi", 20);
        Person p2 = new Person("Anu", 17);
        System.out.println(p1);
        System.out.println(p2);
        List<Person> list = List.of(p1, p2);
        list.stream()
            .filter(p -> p.age() >= 18)
            .forEach(System.out::println);
    }
}