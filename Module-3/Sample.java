public class Sample {
    void show() {
        System.out.println("Hello");
    }
    public static void main(String[] args) {
        new Sample().show();
    }
}

// javac Sample.java
// javap -c Sample