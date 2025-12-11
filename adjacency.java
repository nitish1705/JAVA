import java.util.Scanner;

public class adjacency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int e = sc.nextInt();
        sc.nextLine();
        String a = sc.nextLine();
        int flag = (a.equals("yes"))?1:0;
        int[][] matrix = new int[v][v];
        while(e-- > 0){
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int w = sc.nextInt();
            matrix[n1][n2] = w;
            if(flag == 0) matrix[n2][n1] = w;
        }
        for(int i = 0; i < v; i++){
            for(int j = 0; j < v; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
