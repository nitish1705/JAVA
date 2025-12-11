import java.util.Scanner;

public class primecheck {
    public static boolean check(int n){
        if(n < 2 ) return false;
        if(n == 2) return true;
        for(int i = 2; i * i<= n; i++){
            if(n % i == 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int flag = 0;
        int k = 0;
        while(flag == 0){
        
            if(check(n1 + n2 + k) && k == 0){
                System.out.println(0);
                flag = 1;
            }
            else if(check(n1 + n2 + k) && k != 0){
                System.out.println(k);
                flag = 1;
            }
            else if(!check(n1 + n2 + k)){
                k++;
            }
        }
        sc.close();
    }
}
