import java.util.Scanner;
import java.util.Random;
public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        int num = r.nextInt(100) + 1;
        int g = 0;
        while (g != num) {
            System.out.print("Enter guess: ");
            g = sc.nextInt();
            if (g > num)
                System.out.println("Too High");
            else if (g < num)
                System.out.println("Too Low");
            else
                System.out.println("Correct Guess");
        }
    }
}