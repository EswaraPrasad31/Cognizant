import java.util.Scanner;
public class ArraySumAvg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int n = sc.nextInt();
        int a[] = new int[n];
        int sum = 0;
        for(int i = 0; i < n; i++) {
            System.out.print("Enter element: ");
            a[i] = sc.nextInt();
            sum += a[i];
        }
        double avg = (double)sum / n;
        System.out.println("Sum = " + sum);
        System.out.println("Average = " + avg);
    }
}