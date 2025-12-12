import java.util.*;

public class subIslandCoount{
    private static int[][] diff = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    private static int count = 0;
    private static boolean flag;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] grid1 = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                grid1[i][j] = sc.nextInt();
            }
        }
        int[][] grid2 = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                grid2[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j, r, c)) count++;
                }
            }
        }
        // for(int i = 0; i < r; i++){
        //     for(int j = 0; j < c; j++){
        //        System.out.print(grid2[i][j] + " "); 
        //     }
        //     System.out.println();
        // }
        System.out.println(count);
        sc.close();
    }
    private static boolean dfs(int[][] grid1 , int grid2[][], int x, int y, int R, int C){
        grid2[x][y] = 0;
        flag = (grid1[x][y] == 1)? true : false;
        for(int[] d : diff){
            int adjx = x + d[0];
            int adjy = y + d[1];
            if(adjx >= 0 && adjy >= 0 && adjx < R && adjy < C && grid2[adjx][adjy] != 0 ){
                flag = flag & dfs(grid1, grid2, adjx, adjy, R, C);
            }
        }
        return flag;
    }
}
