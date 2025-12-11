import java.util.Scanner;

public class stringremove {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine().toLowerCase();
        String s2 = sc.nextLine().toLowerCase();
        for(char c : s1.toCharArray()){
            if(!s2.contains(String.valueOf(c))){
                System.out.print(c);
            }
        }
    }
}
