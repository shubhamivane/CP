import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class TotalFruites {

	public static void main(String[] args) {
		testCase();
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			testCase();
		}
	}

	public static void testCase() {
		FastScanner fs = new FastScanner();
//		int n = fs.nextInt();
//		int[] arr = {4,1,1,1,3,1,7,5};
//		int[] arr = {3,3,3,1,2,1,1,2,3,3,4};
		int[] arr = {1,0,1,4,1,4,1,2,3};
		print(totalFruit(arr));
	}
	
	public static int totalFruit(int[] tree) {
        int f1 = -1;
        int f2 = -1;
        int fAmount = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < tree.length ; i++) {
        	System.out.println(f1 + " " + f2 + " " + fAmount + " " + max);
            if(f1 == -1) f1 = i;
            if(tree[f1] == tree[i]) {
                fAmount++;
                continue;
            }
            if(f2 == -1) f2 = i;
            if(tree[f2] == tree[i]) {
            	if(tree[i-1] == tree[f1]) f2 = i;
                fAmount++;
                continue;
            }
            max = Math.max(fAmount, max);
            f1 = f2;
            f2 = i;
            fAmount = f2 - f1 + 1;
        }
        return Math.max(max, fAmount);
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

}
