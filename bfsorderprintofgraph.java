import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfsorderprintofgraph {
    public static void bfs(ArrayList<ArrayList<Integer>> l1, int v, int e){
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[v];
        q.add(0);
        visited[0] =true;
        while(!q.isEmpty()){
            int n = q.poll();
            System.out.print(n+ " ");
            for(int i : l1.get(n)){
                if(!visited[i]){
                    q.add(i);
                    visited[i] = true;
                }
            }
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        Queue<Integer> q = new LinkedList<>(); 
        ArrayList<ArrayList<Integer>> l1 = new ArrayList<>();
        for(int i = 0; i < v; i++){
            l1.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            l1.get(n1).add(n2);
            l1.get(n2).add(n1);
        }
        System.out.println(l1);
        bfs(l1, v, e);
    }
}
