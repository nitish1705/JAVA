import java.io.*;
import java.util.StringTokenizer;

public class staticRang {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        long[] prefix = new long[n];
        long sums = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sums += arr[i];
            prefix[i] = sums;
        }

        for(int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            long result = prefix[end - 1] - prefix[start - 1] + arr[start - 1];
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
