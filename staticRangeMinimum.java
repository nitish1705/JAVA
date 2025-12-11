// import java.util.Scanner;

// public class staticRangeMinimum {
//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);
//         int n = sc.nextInt();
//         int t = sc.nextInt();

//         int lg = 1;
//         while ((1 << lg) <= n) lg++;

//         int[][] arr = new int[lg][n];
//         int[] log = new int[n + 1];
//         log[1] = 0;
//         for (int i = 2; i <= n; i++)
//             log[i] = log[i / 2] + 1;

//         for (int i = 0; i < n; i++)
//             arr[0][i] = sc.nextInt();

//         // Build sparse table
//         for (int i = 1; i < lg; i++) {
//             int len = 1 << (i - 1);
//             for (int j = 0; j + (1 << i) <= n; j++) {
//                 arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j + len]);
//             }
//         }

//         // Answer queries
//         while (t-- > 0) {
//             int start = sc.nextInt() - 1;
//             int end = sc.nextInt() - 1;

//             int len = end - start + 1;
//             int pow = log[len];
//             int res = Math.min(arr[pow][start], arr[pow][end - (1 << pow) + 1]);
//             System.out.println(res);
//         }
//     }
// }


// import java.io.*;
// import java.util.StringTokenizer;

// public class staticRangeMinimum {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//         StringTokenizer st = new StringTokenizer(br.readLine());

//         int n = Integer.parseInt(st.nextToken());
//         int t = Integer.parseInt(st.nextToken());

//         int lg = 0;
//         while ((1 << lg) <= n) {
//             lg++;
//         }

//         int[][] arr = new int[lg][n];

//         st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n; i++) {
//             arr[0][i] = Integer.parseInt(st.nextToken());
//         }

//         for (int i = 1; i < lg; i++) {   
//             int len = 1 << (i - 1);
//             for (int j = 0; j + len < n; j++) {
//                 arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j + len]);
//             }
//         }

//         for (int i = 0; i < t; i++) {
//             st = new StringTokenizer(br.readLine());
//             int start = Integer.parseInt(st.nextToken());
//             int end = Integer.parseInt(st.nextToken());

//             int num = (end - start) + 1;
//             int pow = 0;
//             while ((1 << pow) <= num) {
//                 pow++;
//             }
//             pow--;

//             int n1 = start - 1;
//             int n2 = end - (1 << pow);
//             int res = Math.min(arr[pow][n1], arr[pow][n2]);

//             bw.write(res + "\n");
//         }

//         bw.flush();
//         bw.close();
//         br.close();
//     }
// }


// The above is my code and the below is optimized version



import java.io.*;
import java.util.*;

public class staticRangeMinimum {
    static final int MAXN = 200000;
    static final int LOG = 18; // since 2^18 = 262144 > 2e5

    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = fr.nextInt();
        int t = fr.nextInt();

        int[][] arr = new int[LOG][n];
        int[] log = new int[n + 1];

        // Precompute logs (O(n))
        for (int i = 2; i <= n; i++) log[i] = log[i / 2] + 1;

        // Input array (O(n))
        for (int i = 0; i < n; i++) arr[0][i] = fr.nextInt();

        // Build sparse table (O(n log n))
        for (int i = 1; i < LOG; i++) {
            int len = 1 << (i - 1);
            for (int j = 0; j + (1 << i) <= n; j++) {
                arr[i][j] = Math.min(arr[i - 1][j], arr[i - 1][j + len]);
            }
        }

        // Answer queries (O(1) each)
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int start = fr.nextInt() - 1;
            int end = fr.nextInt() - 1;
            int len = end - start + 1;
            int pow = log[len];
            int res = Math.min(arr[pow][start], arr[pow][end - (1 << pow) + 1]);
            sb.append(res).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    // ✅ Super-fast custom input class
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = System.in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }
}

