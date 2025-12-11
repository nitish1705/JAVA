import java.util.*;

public class stationery_shop_TCS_2{
    public static int fact(int n, int m){
        int res = 1;
        while(n > m){
            res = res * n;
            n = n - 1;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int P = sc.nextInt();
        int E = sc.nextInt();
        if(P > N || E > M){
            System.out.println(0);
            return;
        }
        int ans1 = 0, ans2 = 0;
        int n1 = 0;
        int m1 = 0;
        n1 = fact(N, P);
        m1 = fact(N-P, 0);
        ans1 = n1/m1;
        
        int n2 = 0, m2 = 0;
        n2 = fact(M, E);
        m2 = fact(M-E, 0);
        ans2 = n2/m2;
        System.out.println(ans1 * ans2);
    }
}