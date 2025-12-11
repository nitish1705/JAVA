import java.util.*;

public class adjacencylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int v = sc.nextInt();
            int e = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < e; i++) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                adj.get(n1).add(n2);
                adj.get(n2).add(n1);
            }
            for (int i = 0; i < v; i++) {
                System.out.print(i);
                for (int neighbor : adj.get(i)) {
                    System.out.print("-> " + neighbor);
                }
                System.out.println();
            }
        }
    }
}
