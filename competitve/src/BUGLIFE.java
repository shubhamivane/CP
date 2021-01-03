import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BUGLIFE {
    /*
     * https://www.spoj.com/problems/BUGLIFE/
     */

    public static void main (String[] args) {
        testCases();
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 1 ; tt <= T ; tt++) {
            int[] arr = fs.readArray(2);
            int bugs = arr[0], bug1, bug2;
            int interactions = arr[1];
            int[] memo = new int[bugs + 1];
            boolean flag = false;
            for (int i = 0 ; i < interactions ; i++) {
                int[] interaction = fs.readArray(2);
                bug1 = memo[interaction[0]];
                bug2 = memo[interaction[1]];
                if(bug1 == 0 && bug2 == 0) {
                    memo[interaction[0]] = 1;
                    memo[interaction[1]] = 2;
                } else if(bug2 == 0) {
                    memo[interaction[1]] = bug1 == 1 ? 2 : 1;
                } else if(bug1 == 0) {
                    memo[interaction[0]] = bug2 == 1 ? 2 : 1;
                } else if(bug1 != 0 && bug2 != 0) {
                    if(bug1 == bug2) {
                        flag = true;
                    }
                }
            }
            if(flag) {
                System.out.print("Scenario #"+ tt + ":\nSuspicious bugs found!\n");
            } else {
                System.out.print("Scenario #"+ tt + ":\nNo suspicious bugs found!\n");
            }
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
