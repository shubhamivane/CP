import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class P706B {

    private static int mod = 1;

    public static void main (String[] args) {
        testCases();
    }

    public static void testCases () {
        FastScanner fs = new FastScanner();
        int T = true ? 1 : fs.nextInt();
        for (int tt = 0 ; tt < T ; tt++) {
            int s = fs.nextInt();
            int[] p = fs.readArray(s);
            Arrays.sort(p);
            int d = fs.nextInt();
            int c, b;
            for (int i = 0 ; i < d ; i++) {
                c = fs.nextInt();
                b = lowerBound(p, c);
                if (b >= 0 && b < p.length) {
                    print(c == p[b] ? b + 1 : b);
                } else {
                    print(b);
                }
            }
        }
    }

    private static int lowerBound (int[] arr, int target) {
        int l = 0, r = arr.length - 1, mid;
        while (l <= r) {
            mid = l + ( r - l ) / 2;
            if (arr[mid] == target) {
                return binarySearchFindLastOccurence(arr,target);
            } else if (arr[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int binarySearchFindLastOccurence(int[] arr, int target) {
        int mid, right = arr.length - 1, left = 0;
        int endIdx = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(arr[mid] > target) {
                right = mid - 1;
            }
            if(arr[mid] <= target) {
                if(arr[mid] == target) endIdx = Math.max(endIdx, mid);
                left = mid + 1;
            }
        }
        return endIdx;
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

