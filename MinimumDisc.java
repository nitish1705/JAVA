import java.util.*;

public class MinimumDisc{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        ArrayList<String[]> l1 = new ArrayList<>();
        l1.add(new String[] {"dummy", String.valueOf(Integer.MAX_VALUE)});
        while(n-- > 0){
            String[] s = sc.nextLine().split(",");
            String item = s[0];
            int price = Integer.parseInt(s[1]);
            int disc = Integer.parseInt(s[2]);
            String[] res = l1.get(0);
            int discounted = (price*disc) / 100;
            if(Integer.parseInt(res[1]) == discounted){
                l1.add(new String[] {item, String.valueOf(discounted)});
            }
            else if(Integer.parseInt(res[1]) > discounted){
                l1.clear();
                l1.add(new String[] {item, String.valueOf(discounted)});
            }
        }
        for(String[] i : l1){
            System.out.println(i[0]);
        }
    }
}