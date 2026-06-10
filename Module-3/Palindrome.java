import java.util.Scanner;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = sc.nextLine();
        s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String r = "";
        for(int i = s.length() - 1; i >= 0; i--) {
            r += s.charAt(i);
        }
        if(s.equals(r))
            System.out.println("Palindrome");
        else
            System.out.println("Not Palindrome");
    }
}