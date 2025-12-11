import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTree{
    static class Node{
        int data;
        ArrayList<Node> child;
        Node(int data){
            this.data = data;
            child = new ArrayList<>();
        }
    }
    public static void printing(Node root){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.data + " ");
            q.addAll(temp.child);
        }
    }
    public static int sums(Node root){
        if(root == null) return 0;
        int sums = root.data;
        for(Node node : root.child){
            sums += sums(node);
        }
        return sums;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        if(data == 0){
            sc.close();
            return;
        }
        Queue<Node> q = new LinkedList<>();
        Node root = new Node(data);
        q.add(root);
        while(!q.isEmpty()){
            int no = sc.nextInt();
            Node temp = q.poll();
            for(int i = 0; i < no; i++){
                int val = sc.nextInt();
                Node curr = new Node(val);
                temp.child.add(curr);
                q.add(curr);
            }
        }
        System.out.println(sums(root));
        printing(root);
        sc.close();
    }
}