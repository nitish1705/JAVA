import java.io.*;
import java.util.*;
public class time_palindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(":");
        int ans = 0;
        int val1 = Integer.parseInt(arr[0]);
        int val2 = Integer.parseInt(arr[1]);
        int mins = 0;
        while(true){
            String h = String.format("%02d", val1);
            String m = String.format("%02d", val2);
            String time = h + m;
            String rev = new StringBuilder(time).reverse().toString();
            if (time.equals(rev)) {
                System.out.println(mins);
                return;
            }
            else{
                mins++;
                val2++;
                if(val2 == 60){
                    val2 = 0;
                    val1 = (val1 == 24)? 0: val1+1;
                }
            }
        }
    }
}
