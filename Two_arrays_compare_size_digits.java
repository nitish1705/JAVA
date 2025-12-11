import java.util.*;
public class Two_arrays_compare_size_digits {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] freq = new int[10];
		String[] temp = sc.nextLine().split(" ");
		int n1 = temp.length;
		Long s1 = 0L;
		for(int i = 0; i < temp.length; i++){
		    s1 += Long.parseLong(temp[i]);
		    for(int j = 0; j < temp[i].length(); j++){
		        freq[temp[i].charAt(j) - '0']++;
		        
		    }
		}
		temp = sc.nextLine().split(" ");
		int n2 = temp.length;
		Long s2 = 0L;
		for(int i = 0; i < temp.length; i++){
		    s2 += Long.parseLong(temp[i]);
		    for(int j = 0; j < temp[i].length(); j++){
		        freq[temp[i].charAt(j)-'0']--;
		    }
		}
		if(n1 != n2){
		    System.out.println("NO");
		    return;
		}
		for(int i = 0; i < 10; i++){
		    if(freq[i] != 0){
		        System.out.println("NO");
		        return;
		    }
		}
		System.out.println("YES");
		System.out.println(s1 + " " + s2);
	//	System.out.println(Arrays.toString(freq));
		sc.close();
	}
}