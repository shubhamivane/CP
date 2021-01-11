import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class GeeksForGeeksFlipkartProblem3 {

    private static int[] disjointSet;
    private static int[] parentSum;

    public static void main (String[] args) {
        testCase(false);
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        for (int tt = 0 ; tt < T ; tt++) {
            testCase(true);
        }
    }

    public static void testCase (boolean flag) {
        if (flag) {
            FastScanner fs = new FastScanner();
        } else {
            int v = 7;
            int e = 4;
            int[] values = {10, 25, 5, 15, 5, 20, 0};
            int[][] edges = { {1,2} ,{3,4}, {4,5} ,{6,7} };
            print(solve(v, e, values, edges));
        }
    }

    private static long solve (int V, int E, int[] Values, int[][] Edges) {
        int max = 0;
        disjointSet = new int[Values.length + 1];
        parentSum = new int[Values.length + 1];
        for (int i = 0 ; i < Values.length ; i++) {
            disjointSet[i + 1] = i + 1;
            parentSum[i+1] = Values[i];
        }
        for (int[] edge : Edges) {
            union(edge[0], edge[1]);
        }
        for(int i = 1 ; i <= Values.length ; i++) {
            max = Math.max(max, parentSum[i]);
        }
        return max;
    }

    private static void union (int node1, int node2) {
        int node1Parent = find(node1);
        int node2Parent = find(node2);
        if(node1Parent != node2Parent) {
            parentSum[node1Parent] += parentSum[node2Parent];
            disjointSet[node2Parent] = node1Parent;
        }
    }

    private static int find (int node) {
        int parent = node;
        while (parent != getParent(node)) {
            parent = getParent(node);
        }
        return parent;
    }

    private static int getParent (int node) {
        return disjointSet[node];
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

    static void print (char[] arr) {
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
