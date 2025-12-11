import java.util.*;

public class LIS_Optimized {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        ArrayList<Integer> lis = new ArrayList<>();

        for (int x : arr) {
            int pos = Collections.binarySearch(lis, x);
            if (pos < 0) pos = -(pos + 1);
            if (pos == lis.size()) lis.add(x);
            else lis.set(pos, x);
        }
        System.out.println(lis.size());
    }
}
