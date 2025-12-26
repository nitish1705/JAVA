import java.util.*;

public class leetcode_2483{
	public static int bestClosingTime(String customers) {
        int n = customers.length();
		int index = 0;
		int[] pref = new int[n+1];
		pref[0] = 0;
		int num = Integer.MIN_VALUE;
		int i = 0;
		for(i = 0; i < n; i++){
			if(customers.charAt(i) == 'Y'){
				pref[i+1] = pref[i] + 1;
			}
			else{
				pref[i+1] = pref[i] - 1;
			}
			if(num < pref[i]){
				index = i;
				num = pref[i];
			}
			// System.out.println(pref[i+1]);
		}
		if(num < pref[i]){
			index = i;
			num = pref[i];
		}
		// if(customers.charAt(index - 1) == 'Y' && index == n) return index+1;
		return index;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int val = bestClosingTime("YNYY");
		System.out.println(val);
	        sc.close();
    }
}
