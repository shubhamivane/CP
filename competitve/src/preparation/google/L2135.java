package preparation.google;

import org.jetbrains.annotations.Contract;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class L2135 {

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
        String[] startWords = {"g","vf","ylpuk","nyf","gdj","j","fyqzg","sizec"};
        String[] endWords = {"r","am","jg","umhjo","fov","lujy","b","uz","y"};
        for (int tt = 0 ; tt < T ; tt++) {
            print(wordCount(startWords, endWords));
        }
    }

    public static int wordCount(String[] startWords, String[] targetWords) {
        int ans = 0;
        Map<String,Map<Character, Integer>> startWordsCharCnt = getWordsCharCntMap(startWords);
        Map<String,Map<Character, Integer>> targetWordsCharCnt = getWordsCharCntMap(targetWords);
        for(Map.Entry<String, Map<Character, Integer>> startWordCharCnt: startWordsCharCnt.entrySet()) {
            for(Map.Entry<String, Map<Character, Integer>> targetWordCharCnt: targetWordsCharCnt.entrySet()) {
                Map<Character, Integer> diff = difference(startWordCharCnt.getValue(), targetWordCharCnt.getValue());
                if(diff.size() == 1) {
                    for(Map.Entry<Character, Integer> diffEntry: diff.entrySet()) {
                        if(diffEntry.getValue() == 1 && !startWordCharCnt.getValue().containsKey(diffEntry.getKey())) {
                            print(startWordCharCnt.getKey());
                            ans++;
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static Map<String, Map<Character, Integer>> getWordsCharCntMap(String[] words) {
        Map<String, Map<Character, Integer>> wordToCharCnt = new HashMap<>();
        for(String word: words) {
            char[] charArray = word.toCharArray();
            Map<Character, Integer> charCnt = new HashMap<>();
            for(char ch: charArray) {
                int charCount = charCnt.getOrDefault(ch, 0);
                charCnt.put(ch, charCount+1);
            }
            wordToCharCnt.put(word, charCnt);
        }
        return wordToCharCnt;
    }

    private static Map<Character, Integer> difference(Map<Character, Integer> word1CharCnt, Map<Character, Integer> word2CharCnt) {
        Map<Character, Integer> diff = new HashMap<>();
        for(Map.Entry<Character, Integer> charEntry: word1CharCnt.entrySet()) {
            int charCnt = word2CharCnt.getOrDefault(charEntry.getKey(), 0);
            if(charCnt-charEntry.getValue() != 0) {
                diff.put(charEntry.getKey(), charCnt-charEntry.getValue());
            }
        }
        for(Map.Entry<Character, Integer> charEntry: word2CharCnt.entrySet()) {
            if(!word1CharCnt.containsKey(charEntry.getKey())) {
                diff.put(charEntry.getKey(), charEntry.getValue());
            }
        }
        return diff;
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
