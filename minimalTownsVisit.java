import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class minimalTownsVisit {
    static ArrayList<Integer>[] graph;
    static ArrayList<ArrayList<Integer>> path1;
    static ArrayList<ArrayList<Integer>> path2;

    private static void findPath(int node, int dest, boolean[] visited, ArrayList<Integer> currPath, ArrayList<ArrayList<Integer>> finalPath){
        if(node == dest){
            currPath.add(node);
            finalPath.add(new ArrayList<>(currPath));
            currPath.remove(currPath.size() - 1);
            return;
        }
        currPath.add(node);
        visited[node] = true;
        for(int adjnode : graph[node]){
            if(!visited[adjnode]){
                findPath(adjnode, dest, visited, currPath, finalPath);
            }
        }
        visited[node] = false;
        currPath.remove(currPath.size() - 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();
        graph = new ArrayList[nodes+1];
        for(int i = 1; i <= nodes; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < edges; i++){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            graph[n1].add(n2);
            graph[n2].add(n1);
        }
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int dest = sc.nextInt();
        path1 = new ArrayList<>();
        path2 = new ArrayList<>();
        findPath(s1, dest, new boolean[nodes+1], new ArrayList<>(), path1);
        findPath(s2, dest, new boolean[nodes+1], new ArrayList<>(), path2);

        boolean found = false;
        int minDist = Integer.MAX_VALUE;
        for(ArrayList<Integer> res1 : path1) {
            HashSet<Integer> set1 = new HashSet<>(res1);
            for(ArrayList<Integer> res2 : path2) {
                HashSet<Integer> set2 = new HashSet<>(res2);
                HashSet<Integer> intersection = new HashSet<>(set1);
                intersection.retainAll(set2);
                if (intersection.size() == 1 && intersection.contains(dest)) {
                    HashSet<Integer> union = new HashSet<>(set1);
                    union.addAll(set2);
                    found = true;
                    minDist = Math.min(minDist, union.size());
                }
            }
        }
        System.out.println(found == true ? minDist-1 : "Impossible");
    }
}
