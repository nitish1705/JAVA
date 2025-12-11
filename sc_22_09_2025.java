import java.util.*;
public class sc_22_09_2025 {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		ArrayList<Integer> l1 = new ArrayList<>();
		int n = 0;
		int i = 0;
		while(y != 0){
		    n++;
		    if((y & 1) == 1){
		        l1.add(i);
		    }
		    i++;
		    y = y >> 1;
		}
		System.out.println(l1);
		for(int k : l1){
		    //System.out.print(n-k + " ");
		    x = x^(1 << k);
		}
        System.out.println(x);
	}
}