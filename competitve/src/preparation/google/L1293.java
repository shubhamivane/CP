package preparation.google;


import jdk.internal.util.xml.impl.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class L1293 {

    private static int mod = 1;

    public static void main(String[] args) {
        testCases();
    }

    public static class Block {
        int pathLength;
        int obstacle;

        Block(int pathLength, int obstacle) {
            this.pathLength = pathLength;
            this.obstacle = obstacle;
        }

        @Override
        public String toString() {
            return "Block{" + "pathLength=" + pathLength + ", obstacle=" + obstacle + "}";
        }
    }

    public static void testCases() {
        FastScanner fs = new FastScanner();
        int T = true ? 1 : fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
//            int[][] grid = {{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}};
            int[][] grid = {{0, 1, 1}, {1, 1, 1}, {1, 0, 0}};
            int k = 1;
            int[][] test = new int[3][3];
//            print(test);
            print(shortestPath(grid, k));
        }
    }

    public static int shortestPath(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        Block[][] memo = new Block[rows][cols];
        memo[0][0] = new Block(0, 0);
        shortestPath(grid, rows - 1, cols - 1, rows, cols, k, memo);
        return memo[rows - 1][cols - 1].pathLength;
    }

    private static Block shortestPath(int[][] grid, int currRow, int currCol, int rows,
                                      int cols, int k, Block[][] memo) {
        if (currRow >= rows || currCol >= cols || currRow < 0 || currCol < 0) {
            return null;
        }
        if (memo[currRow][currCol] != null) {
            return memo[currRow][currCol];
        }
        Block leftBlock = shortestPath(grid, currRow, currCol - 1, rows, cols, k, memo);
        Block aboveBlock = shortestPath(grid, currRow - 1, currCol, rows, cols, k, memo);
        int pathLen, obstacle, leftPathLen = Integer.MAX_VALUE-1, rightPathLen = Integer.MAX_VALUE-1, leftPathObstacle = Integer.MAX_VALUE, rightPathObstacle = Integer.MAX_VALUE;
        boolean isCurrBlockObstacle = isObstacle(grid, currRow, currCol);
        if (leftBlock != null && (!isCurrBlockObstacle || leftBlock.obstacle + 1 <= k)) {
            leftPathLen = leftBlock.pathLength + 1;
            leftPathObstacle = leftBlock.obstacle + (isCurrBlockObstacle ? 1 : 0);
        }
        if (aboveBlock != null && (!isCurrBlockObstacle || aboveBlock.obstacle + 1 <= k)) {
            rightPathLen = aboveBlock.pathLength + 1;
            rightPathObstacle = aboveBlock.obstacle + (isCurrBlockObstacle ? 1 : 0);
        }
        if(leftBlock == null && aboveBlock == null) {
            obstacle = 0;
            pathLen = 0;
        } else if(leftPathLen < rightPathLen) {
            pathLen = leftPathLen;
            obstacle = leftPathObstacle;
        } else if(rightPathLen < leftPathLen) {
            pathLen = rightPathLen;
            obstacle = rightPathObstacle;
        } else {
            obstacle = Math.min(rightPathObstacle, leftPathObstacle) ;
            pathLen = leftPathLen;
        }
        print(currRow + " " + currCol + " " + rows + " " + cols + " " + k + " " + pathLen + " " + obstacle);
        memo[currRow][currCol] = new Block(pathLen, obstacle);
        return memo[currRow][currCol];
    }

    private static boolean isObstacle(int[][] grid, int row, int col) {
        return grid[row][col] == 1;
    }

    private static long binPower(int n, int p) {
        long ans = 1;
        while (p > 0) {
            if ((p & 1) == 1) {
                ans = ans * n;
            }
            n = n * n;
            p = p >> 1;
        }
        return ans;
    }

    private static long mulUnderMod(int m, int n) {
        return ((m % mod) * (n % mod)) % mod;
    }

    private static int gcd(int a, int b) {
        int temp;
        if (a < b) {
            temp = a;
            a = b;
            b = temp;
        }
        while (b > 0) {
            a = a % b;
            temp = a;
            a = b;
            b = temp;
        }
        return a;
    }


    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        char nextChar() {
            return next().charAt(0);
        }

        char[] readArray() {
            return next().toCharArray();
        }

        long[] readLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static void print(int n) {
        System.out.println(n);
    }

    static void print(long n) {
        System.out.println(n);
    }

    static void print(double n) {
        System.out.println(n);
    }

    static void print(float n) {
        System.out.println(n);
    }

    static void print(String n) {
        System.out.println(n);
    }

    static void print(Collection<?> c) {
        System.out.println(c.toString());
    }

    static void print(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print(float[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print(long[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print(double[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    static void print(boolean bool) {
        System.out.print(String.valueOf(bool));
    }

    static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i]);
        }
    }
}
