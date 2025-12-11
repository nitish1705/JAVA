import java.util.Scanner;

public class appleTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int maxi = -1;
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
                maxi = Math.max(arr[i], maxi);
            }
            int ind = 0;
            int mini = maxi;
            for(int i = n - 1; i >= 0; i--){
                if(arr[i] < mini){
                    mini = arr[i];
                    ind = i;
                }
            }
            int lastApple = mini;
            int count = 1;
            while(lastApple != maxi){
                int currmaxi = maxi;
                while(ind < n){
                    if(arr[ind] > lastApple && currmaxi > arr[ind]){
                        currmaxi = arr[ind];
                    }
                    ind++;
                }
                if(currmaxi != -1){
                    count++;
                    lastApple = currmaxi;
                }
                ind = 0;
            }
            System.out.println(count);
        }
    }
}
