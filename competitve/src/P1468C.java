import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1468C {

    public static void main (String[] args) {
        try {
            testCases();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void testCases () throws IOException {
        FastScanner fs = new FastScanner();
        int T = fs.nextInt();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(100, (a, b) -> {
            if (a[0] > b[0])
                return -1;
            else if (b[0] > a[0])
                return 1;
            else
                return a[1] < b[1] ? -1 : 1;
        });
        Set<Integer> deletedElemFromQueue = new HashSet<>();
        Set<Integer> deletedElemFromPQ = new HashSet<>();
        String query;
        int idx = 0;
        for (int t = 0 ; t < T ; t++) {
            query = fs.br.readLine();
            String[] queryToArray = query.split(" ");
//            print("iter" + t);
//            for(int ele: deletedElemFromQueue) {
//                print(ele);
//            }
            if (queryToArray.length == 2) {
                int m = Integer.parseInt(queryToArray[1]);
                int[] idxSetInput = new int[2];
                idxSetInput[0] = ++idx;
                idxSetInput[1] = m;
                queue.add(idxSetInput);
                int[] mSetInput = new int[2];
                mSetInput[0] = m;
                mSetInput[1] = idx;
                priorityQueue.add(mSetInput);
            } else if (queryToArray[0].equals("2")) {
                int[] setInput;
                while(true) {
                    setInput = queue.pollFirst();
                    if(!deletedElemFromQueue.contains(setInput[0])) {
//                        print("deletedFromQueue " + setInput[0]);
                        break;
                    }
                }
                deletedElemFromPQ.add(setInput[0]);
                System.out.print(setInput[0] + " ");
            } else {
                int[] mInput;
                while(true) {
                    mInput = priorityQueue.poll();
                    if(!deletedElemFromPQ.contains(mInput[1])) {
//                        print("deletedFromPQ " + mInput[1]);
                        break;
                    }
                }
                deletedElemFromQueue.add(mInput[1]);
                System.out.print(mInput[1] + " ");
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

    static void print (String[] arr) {
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
