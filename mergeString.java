import java.util.Scanner;

public class mergeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        int ptr1 = 0, ptr2 = 0;
        while(ptr1 < s1.length()  && ptr2 < s2.length()){
            char c = s1.charAt(ptr1);
            while(ptr1 < s1.length() && s1.charAt(ptr1) == c){
                System.out.print(c);
                ptr1++;
            }
            c = s2.charAt(ptr2);
            while(ptr2 < s2.length() && s2.charAt(ptr2) == c) {
                System.out.print(c);
                ptr2++;
            }
        }
        sc.close();
    }   
}
