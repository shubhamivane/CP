package preparation.google;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L2034 {

    private static int mod = 1;
    private enum TreeTraversalOrder {
        PREORDER, INORDER, POSTORDER;
    }

    public static void main (String[] args) {
        testCases();
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = true ? 1 : fs.nextInt();
        for (int tt = 0 ; tt < T ; tt++) {
            String s = "abbbc";
            int i = 2;
            int len = 3;
            print(s.substring(i, i+len));
        }
    }

    static class StockPrice {
        private int currentTimestamp;
        private int currentPrice;
        private TreeMap<Integer, Integer> stockPriceFreq;
        private HashMap<Integer, Integer> stockPriceMap;
        private int minimum;
        private int maximum;
        public StockPrice() {
            this.currentTimestamp = 0;
            this.currentPrice = 0;
            this.stockPriceMap = new HashMap<>();
            this.stockPriceFreq = new TreeMap<>();
            this.maximum = Integer.MIN_VALUE;
            this.minimum = Integer.MAX_VALUE;
        }

        public void update(int timestamp, int price) {
            if(timestamp >= this.currentTimestamp) {
                this.currentTimestamp = timestamp;
                this.currentPrice = price;
            }
            if(this.stockPriceMap.containsKey(timestamp)) {
                int oldPrice = this.stockPriceMap.get(timestamp);
                int oldPriceFreq = this.stockPriceFreq.get(oldPrice);
                if(oldPriceFreq == 1) {
                    this.stockPriceFreq.remove(oldPrice);
                    if(this.minimum == oldPrice) {
                        this.minimum = this.stockPriceFreq.size() == 0 ? Integer.MAX_VALUE : this.stockPriceFreq.firstKey();
                    }
                    if(this.maximum == oldPrice) {
                        this.maximum = this.stockPriceFreq.size() == 0 ? Integer.MIN_VALUE : this.stockPriceFreq.lastKey();
                    }
                } else {
                    this.stockPriceFreq.put(oldPrice, oldPriceFreq-1);
                }
            }
            this.minimum = Math.min(this.minimum, price);
            this.maximum = Math.max(this.maximum, price);
            this.stockPriceMap.put(timestamp, price);
            int newPriceFreq = this.stockPriceFreq.getOrDefault(price, 0);
            this.stockPriceFreq.put(price, newPriceFreq+1);
        }

        public int current() {
            return this.currentPrice;
        }

        public int maximum() {
            return this.maximum;
        }

        public int minimum() {
            return this.minimum;
        }
    }



    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        @Contract(pure = true)
        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static TreeNode convertArrayToTree(int[] arr, int idx) {
        TreeNode treeNode = new TreeNode(arr[idx]);
        if (2 * idx + 1 < arr.length) {
            treeNode.right = convertArrayToTree(arr, 2 * idx + 2);
        }
        if (2 * idx + 2 < arr.length) {
            treeNode.left = convertArrayToTree(arr, 2 * idx + 1);
        }
        return treeNode;
    }

    private static void printTree(TreeNode root, TreeTraversalOrder treeTraversalOrder) {
        if (root == null) {
            return;
        }
        switch (treeTraversalOrder) {
            case INORDER:
                printTree(root.left, treeTraversalOrder);
                print(root.val + " ");
                printTree(root.right, treeTraversalOrder);
                break;
            case PREORDER:
                print(root.val + " ");
                printTree(root.left, treeTraversalOrder);
                printTree(root.right, treeTraversalOrder);
                break;
            case POSTORDER:
                printTree(root.left, treeTraversalOrder);
                printTree(root.right, treeTraversalOrder);
                print(root.val + " ");
                break;
        }
    }

    private static long binPower (int n, int p) {
        long ans = 1;
        while (p > 0) {
            if (( p & 1 ) == 1) {
                ans = ans * n;
            }
            n = n * n;
            p = p >> 1;
        }
        return ans;
    }

    private static long mulUnderMod (int m, int n) {
        return ( ( m % mod ) * ( n % mod ) ) % mod;
    }

    private static int gcd (int a, int b) {
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
