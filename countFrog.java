import java.util.ArrayList;
import java.util.Scanner;

public class countFrog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        int[] start = new int[n];
        int[] end = new int[n];
        for(int i = 0; i < n; i++){
            start[i] = sc.nextInt();

        }
        for(int j = 0; j < n; j++){
            end[j] = sc.nextInt();
        }
        int sums = 0;
        for(int i = 0; i < n; i++){
            int maxi = 0;
            for(int j = 0; j < n; j++){
                int s = start[i];
                int e = end[j];
            }
        }
    }
}
