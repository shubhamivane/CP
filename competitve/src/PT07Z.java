import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.*;
import java.util.StringTokenizer;

public class PT07Z {

    /*
     * https://www.spoj.com/problems/PT07Z/
     */
    private static Map<Integer, List<Integer>> graph = new HashMap<>();
    private static int maxLength = 0;

    public static void main (String[] args) {
        testCase(true);
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
            int n = fs.nextInt();
            int nodeSize = n;
            int[] arr;
            n--;
            int[] visited = new int[nodeSize+1];
            Arrays.fill(visited, 0);
            while (n-- > 0) {
                arr = fs.readArray(2);
                visited[arr[0]] += 1;
                visited[arr[1]] += 1;
                addEdge(arr[0], arr[1]);
                addEdge(arr[1], arr[0]);
            }
            int start = 0;
            for(int i: visited) {
                if(i == 1) {
                    start = i;
                    break;
                }
            }
            Arrays.fill(visited, 0);
            DFS(start, visited, 0);
            print(maxLength);
        } else {

        }
    }

    private static int DFS(int start, int[] visited, int sizeOfThePath) {
//        print("sizeOfThePath: " + sizeOfThePath);
        if(visited[start] == 1) {
            return ;
        }
        visited[start] = 1;
        int m, m1=-1, m2=-1;
        for(int ele: graph.get(start)) {
            m = DFS(ele, visited, sizeOfThePath + 1);
        }
        maxLength = Math.max(maxLength, sizeOfThePath);
    }

    private static void addEdge (int node1, int node2) {
        List<Integer> node1AdjacencyList = graph.getOrDefault(node1, new ArrayList<>());
        node1AdjacencyList.add(node2);
        graph.put(node1, node1AdjacencyList);
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

    static void print (boolean[] arr) {
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
