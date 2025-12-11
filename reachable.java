import java.util.*;

public class reachable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[R][C];
        int r_start = 0, c_start = 0, r_end = 0, c_end = 0;
        for (int row = 0; row < R; row++) {
            String line = sc.next();
            for (int col = 0; col < C; col++) {
                grid[row][col] = line.charAt(col);
                if(grid[row][col] == 'A'){
                    r_start = row;
                    c_start = col; 
                }
                else if(grid[row][col] == 'B'){
                    r_end = row;
                    c_end = col;
                }
            }
        }
        boolean[][] visited = new boolean[R][C];
        int[][] change = new int[R][C];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {r_start, c_start});
        boolean flag = false;
        while(!q.isEmpty()){
            int[] arr = q.poll();
            if(arr[0] == r_end && arr[1] == c_end){
                flag = true;
                break;
            }
            for(int i = 0; i < 4; i++){
                
            }
        }
    }
}
