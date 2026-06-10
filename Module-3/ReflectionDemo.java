import java.lang.reflect.*;
class Demo {
    public void show() {
        System.out.println("Hello");
    }
}
public class ReflectionDemo {
    public static void main(String[] args)
            throws Exception {
        Class c = Class.forName("Demo");
        Method m[] = c.getDeclaredMethods();
        for(Method x : m) {
            System.out.println(x.getName());
        }
        Object obj =
                c.getDeclaredConstructor().newInstance();
        Method mm = c.getMethod("show");
        mm.invoke(obj);
    }
}