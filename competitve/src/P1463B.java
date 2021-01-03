import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class P1463B {

    public static void main (String[] args) {
        testCases();
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        int n;
        for (int tt = 0 ; tt < T ; tt++) {
            n = fs.nextInt();
            int[] arr = fs.readArray(n);
            long sum = 0;
            long evenSum = 0;
            long oddSum = 0;
            for (int i = 0 ; i < arr.length ; i++) {
                if (i % 2 == 1) {
                    oddSum += arr[i] - 1;
                } else {
                    evenSum += arr[i] - 1;
                }
                sum += arr[i];
            }
            if (2 * evenSum <= sum) {
                for (int i = 0 ; i < arr.length ; i += 2) {
                    if (i % 2 == 0) {
                        arr[i] = 1;
                    }
                }
            }
            else if (2 * oddSum < sum) {
                for (int i = 1 ; i < arr.length ; i += 2) {
                    if (i % 2 == 1) {
                        arr[i] = 1;
                    }
                }
            }
            for(int i = 0 ; i < arr.length ;i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }
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
