import java.util.ArrayList;
import java.util.Scanner;

public class dfsorderprintofgraph {

    public static void dfs(ArrayList<ArrayList<Integer>> l1, boolean[] visited, int node) {
        visited[node] = true;
        System.out.print(node + " ");
        for (int neighbor : l1.get(node)) {
            if (!visited[neighbor]) {
                dfs(l1, visited, neighbor);
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            l1.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            l1.get(n1).add(n2);
            l1.get(n2).add(n1);
        }

        System.out.println(l1);

        boolean[] visited = new boolean[v];
        dfs(l1, visited, 0);
    }
}
