import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class BYTESM2 {

	/*
	 * https://www.spoj.com/problems/BYTESM2/
	 */

	public static void main(String[] args) {
		testCases();
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		int h, w;
		for (int tt = 0; tt < T; tt++) {
			int[] arr = fs.readArray(2);
			h = arr[0];
			w = arr[1];
			int[][] floor = new int[h][w];
			int[][] memo = new int[h][w];
			for(int i = 0 ; i < h ; i++) {
				floor[i] = fs.readArray(w);
			}
			int mx = 0;
			for(int i = 0 ; i < w ; i++) {
				dp(floor, 0, i, memo);
				mx = Math.max(mx, memo[0][i]);
			}
//			print(memo);
			System.out.println(mx);
		}
	}

	private static void dp(int[][] floor, int row, int col, int[][] memo) {
		if(col < 0 || col >= floor[0].length || row >= floor.length) {
			return;
		}
		if(row == floor.length-1) {
			memo[row][col] = floor[row][col];
			return;
		}
		if(memo[row][col] != 0) {
			return;
		}
//		print("\n Iteration for " + row + " " + col);
		dp(floor, row + 1, col - 1, memo);
		dp(floor, row + 1, col, memo);
		dp(floor, row + 1, col + 1, memo);
		int mx = 0;
		if(col - 1 >= 0) mx = Math.max(mx, memo[row+1][col-1]);
		if(floor.length > row+1 && floor[0].length > col) mx = Math.max(mx, memo[row+1][col]);
		if(floor[0].length > col+1 && floor.length > row+1) mx = Math.max(mx, memo[row+1][col+1]);
		memo[row][col] = floor[row][col] + mx;
	}

	public static void testCase(boolean flag) {
		if (flag) {
			FastScanner fs = new FastScanner();
		} else {
			
		}
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
		for(int i = 0 ; i < arr.length ; i++) {
			print(arr[i]);
		}
	}

}
