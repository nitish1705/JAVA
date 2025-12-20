import java.util.*;

public class leetcode_944{
    public static int minDeletionSize(String[] strs) {
        int C = strs.length;
        int R = strs[0].length();
        // char[][] arr = new char[R][C];
        int count = 0;
        for(int i = 0; i < R; i++){
            int flag = 0;
            char c = strs[0].charAt(i);
            for(int j = 1; j < C; j++){
                if(c > strs[j].charAt(i)){
                    flag = 1;
                    break;
                }
                c = strs[j].charAt(i);
            }
            if(flag == 0) count++;
        }
        return R - count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int res = minDeletionSize(new String[] {"a", "b"});
        System.out.println(res);
        sc.close();
    }
}
