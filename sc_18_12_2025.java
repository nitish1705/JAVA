import java.util.*;
public class sc_18_12_2025 {

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		System.out.print(s.charAt(0));
		char extra = s.charAt(0);
		int k = 1;
		for(int i = 1; i < s.length(); i++){
		    char c = s.charAt(i);
		    if(extra == c){
		        char num = (char) (((c - 0) + k++ - 'a') % 26 + 'a');
		        System.out.print(num);
		        continue;
		    }
		    extra = c;
		    k = 1;
		    System.out.print(c);
		}
        //System.out.println("...");
        sc.close();
	}
}
