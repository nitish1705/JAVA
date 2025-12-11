import java.util.Arrays;
import java.util.Scanner;

public class sieve_algorithm_prime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] arr = new boolean[n+1];
        for(int i = 2; i*i<=n; i++){
            if(!arr[i]){
                for(int j = i*i; j <= n; j+=i){
                    arr[j] = true;
                }
            }
        }
        for(int i = 2; i < n + 1; i++){
            if(!arr[i]){
                System.out.print(i + " ");
            }
        }
        //System.out.println(Arrays.toString(arr));
    }
}
