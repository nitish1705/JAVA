import java.util.Scanner;

public class YesNoChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (n > 2 && isPrime(n)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

        sc.close();
    }

    // Function to check if a number is prime
    static boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
