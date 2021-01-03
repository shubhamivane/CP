import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class P1462E1 {

    public static void main (String[] args) {
        testCases();
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        PrintWriter out = new PrintWriter(System.out);
        for (int tt = 0 ; tt < T ; tt++) {
            int n = fs.nextInt();
            int[] arr = fs.readArray(n);
            if (n < 3) {
                out.println("0");
                continue;
            }
            Arrays.sort(arr);
            int cnt = 0;
            for (int i = 0 ; i < n - 2 ; i++) {

            }
            out.println(cnt);
        }
        out.close();
    }

    public static void testCase (boolean flag) {
        if (flag) {
            FastScanner fs = new FastScanner();
        } else {

        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next () {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt () {
            return Integer.parseInt(next());
        }

        int[] readArray (int n) {
            int[] a = new int[n];
            for (int i = 0 ; i < n ; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong () {
            return Long.parseLong(next());
        }

        char nextChar () {
            return next().charAt(0);
        }

        char[] readArray () {
            return next().toCharArray();
        }

        long[] readLongArray (int n) {
            long[] a = new long[n];
            for (int i = 0 ; i < n ; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static void print (int n) {
        System.out.println(n);
    }

    static void print (long n) {
        System.out.println(n);
    }

    static void print (double n) {
        System.out.println(n);
    }

    static void print (float n) {
        System.out.println(n);
    }

    static void print (String n) {
        System.out.println(n);
    }

    static void print (Collection<?> c) {
        System.out.println(c.toString());
    }

    static void print (int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print (float[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print (long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print (double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print (boolean bool) {
        System.out.print(String.valueOf(bool));
    }

    static void print (int[][] arr) {
        for (int i = 0 ; i < arr.length ; i++) {
            print(arr[i]);
        }
    }

}
