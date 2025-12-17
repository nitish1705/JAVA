import java.util.*;

public class leetocde_279{
    public static int numSquares(int n) {
        List<Integer> l = new ArrayList<>();
        for(int i = 1; i < n; i++){
            if(i*i <= n){
                l.add(i*i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        visited[0] = true;
        q.add(0);
        int count = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int num = q.poll();
                if(num == n) return count;
                for(int temp : l){
                    if(num + temp <= n && !visited[num + temp]){
                        visited[num + temp] = true; 
                        q.add(num + temp);
                    }
                }
            }
            count++;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = numSquares(n);
        System.out.println(res);
        sc.close();
    }
}
