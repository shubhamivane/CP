package preparation.google;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class L2096 {

    private static int mod = 1;

    private enum TreeTraversalOrder {
        PREORDER, INORDER, POSTORDER;
    }

    public static void main(String[] args) {
        testCases();
    }

    public static void testCases() {
        FastScanner fs = new FastScanner();
        int T = true ? 1 : fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
            String a = "L";
            TreeMap<Integer, Integer> t = new TreeMap<>();
//            t.floorKey();
//            print(a.substring(1));
            int[] root = {5, 1, 2, 3, 0, 6, 4};
            int startValue = 4, destValue = 3;
            print(getDirections(convertArrayToTree(root, 0), startValue, destValue));
        }
    }

    public static String getDirections(TreeNode root, int startValue, int destValue) {
        String startValuePath = getDirection(root, startValue, "");
        String destValuePath = getDirection(root, destValue, "");
        int commonPathIdx = 0;
        while (startValuePath.length() > commonPathIdx && destValuePath.length() > commonPathIdx) {
            if (startValuePath.charAt(commonPathIdx) != destValuePath.charAt(commonPathIdx)) {
                break;
            }
            commonPathIdx++;
        }
        if (startValuePath.length() > commonPathIdx) {
            startValuePath = startValuePath.substring(commonPathIdx);
            startValuePath = startValuePath.replace('L', 'U').replace('R', 'U');
        } else{
            startValuePath = "";
        }
        if (destValuePath.length() > commonPathIdx) {
            destValuePath = destValuePath.substring(commonPathIdx);
        } else{
            destValuePath = "";
        }
        return startValuePath + destValuePath;
    }

    private static String getDirection(TreeNode root, int target, String currPath) {
        if (root == null) {
            return "";
        }
        if (root.val == target) {
            return currPath;
        }
        String lPath = getDirection(root.left, target, currPath + "L");
        String rPath = getDirection(root.right, target, currPath + "R");
        return lPath.length() > 0 ? lPath : rPath;
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
