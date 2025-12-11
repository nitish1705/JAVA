import java.util.*;
public class sc_02_10_2025 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k = sc.nextInt();
        StringBuilder sb = new StringBuilder(s);
        while(k-- > 0){
            for(int i = 2; i <= s.length(); i+= 3){
                int temp = sb.charAt(i) - '0';
                if(temp == 9){
                    int j = 0;
                    while(temp == 9 && (i - (j) >= 0)){
                        sb.setCharAt((i - (j)), '0');
                        if((i - (j)) == 0) break;
                        temp = sb.charAt(i - (++j)) - '0';
                    }
                    if((i - (j)) == 0) continue;
                    sb.setCharAt((i - (j)), (char) ('0' + (temp+1)));
                    continue;
                }
                sb.setCharAt(i, (char) ('0' + (temp + 1)));
            }
            System.out.println(sb);
        }
	}
}