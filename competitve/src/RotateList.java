import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class RotateList {

    private static int mod = 1;
    /*
     * https://leetcode.com/problems/rotate-list/
     */

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
            ListNode node = new ListNode(1);
            node.next = new ListNode(2);
            node.next.next = new ListNode(3);
            node.next.next.next = new ListNode(4);
            node.next.next.next.next = new ListNode(5);
            ListNode head = rotateRight(node, 2);
            while (head != null) {
                print(head.val + " ");
                head = head.next;
            }
        }
    }

    private static ListNode rotateRight (ListNode head, int k) {
        ListNode fastNode = null, slowNode = null;
        while (k-- > 0) {
            fastNode = (fastNode.next == null) ? head : fastNode.next;
        }
        if (fastNode == head) {
            return head;
        }
        ListNode prevFastNode = null;
        while (fastNode != null) {
            prevFastNode = fastNode;
            fastNode = fastNode.next;
            if (slowNode == null)
                slowNode = head;
            else
                slowNode = slowNode.next;
        }
        print(slowNode.val + "\n");
        fastNode = slowNode.next;
        slowNode.next = null;
        prevFastNode.next = head;
        print(fastNode.val + "\n");
        return fastNode;
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

    static public class ListNode {
        int val;
        ListNode next;

        ListNode () {
        }

        ListNode (int val) {
            this.val = val;
        }

        ListNode (int val, ListNode next) {
            this.val = val;
            this.next = next;
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
