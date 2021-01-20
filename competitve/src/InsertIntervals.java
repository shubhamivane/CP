import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class InsertIntervals {

    private static int mod = 1;

    /*
     * https://leetcode.com/problems/insert-interval/
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
            int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
            int[] newInterval = {4, 8};
            print(insert(intervals, newInterval));
        }
    }

    public static int[][] insert (int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            intervals = new int[1][2];
            intervals[0][0] = newInterval[0];
            intervals[0][1] = newInterval[1];
            return intervals;
        }
        int[][] intervalsAfterUpdate = new int[intervals.length + 1][2];
        int k = 0;
        boolean flag = true;
        for(int i = 0 ; i < intervals.length ; i++) {
            if(intervals[i][0] > newInterval[0] && flag) {
                intervalsAfterUpdate[k][0] = newInterval[0];
                intervalsAfterUpdate[k++][1] = newInterval[1];
                flag = false;
            }
            intervalsAfterUpdate[k][0] = intervals[i][0];
            intervalsAfterUpdate[k++][1] = intervals[i][1];
        }
        return merge(intervalsAfterUpdate);
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length == 1){
            return intervals;
        }
        List<List<Integer>> result = new ArrayList<>();
//        Arrays.sort(intervals, Comparator.comparingDouble(ele -> ele[0]));
        List<Integer> temp = null;
        int start = 0, end = 0;
        List<Integer> prevInterval = new ArrayList<>();
        prevInterval.add(intervals[0][0]);
        prevInterval.add(intervals[0][1]);
        for(int i = 1 ; i < intervals.length; i++) {
            if(prevInterval.get(1) < intervals[i][0]) {
                result.add(prevInterval);
                prevInterval = new ArrayList<>();
                prevInterval.add(intervals[i][0]);
                prevInterval.add(intervals[i][1]);
                continue;
            }
            start = Math.min(intervals[i][0], prevInterval.get(0));
            end = Math.max(intervals[i][1], prevInterval.get(1));
            prevInterval.set(0, start);
            prevInterval.set(1, end);
        }
        result.add(prevInterval);
        int[][] mergedIntervals = new int[result.size()][2];
        int i=0;
        for(List<Integer> itr : result) {
            mergedIntervals[i][0] = itr.get(0);
            mergedIntervals[i][1] = itr.get(1);
            i++;
        }
        return mergedIntervals;
    }

    private static int[] lowerBoundInterval (int[][] intervals, int[] newInterval) {
        int target = newInterval[0], l = 0, r = intervals.length-1, mid;
        int[] intRange = new int[2];
        while(l < r) {
            mid = l + (r-l)/2;
            if(intervals[mid][0] == target) {
                l = mid;
                break;
            }
            if(intervals[mid][0] > target) {
                r = mid-1;
            } else {
                l = mid;
            }
        }
        intRange[0] = l;
        target = newInterval[1];
        while(l < r) {
            mid = l + (r-l)/2;
            if(intervals[mid][0] == target) {
                l = mid;
                break;
            }
            if(intervals[mid][0] > target) {
                r = mid-1;
            } else {
                l = mid;
            }
        }
        intRange[1] = l;
        return intRange;
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
