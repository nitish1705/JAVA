import java.util.*;
public class pattern{
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = sc.nextInt();
		int k = 0;
		int flag = 0;
		for(int i = 0; i < s.length(); i++){
		    for(int j = 0; j < k; j++){
		        System.out.print("*");
		    }
		    System.out.print(s.charAt(i));
		    System.out.println();
		    if(flag == 0){
		        k++;
		        if(k == n - 1) flag = 1;
		    }
		    else{
		        k--;
		        if(k == 0) flag = 0;
		    }
		}
		sc.close();
	}
}