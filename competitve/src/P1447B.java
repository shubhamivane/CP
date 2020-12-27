import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1447B {

	public static void main(String[] args) {
		testCases();
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
		int row = fs.nextInt();
		int col = fs.nextInt();
		int[][] grid = fs.readIntGrid(row, col);
		int nonZeroNumCnt = 0;
		int minElement = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (grid[i][j] > 0) {
					nonZeroNumCnt++;
				}
				sum += Math.abs(grid[i][j]);
				minElement = Math.abs(grid[i][j]) < minElement ? Math.abs(grid[i][j]) : minElement;
			}
		}
		System.out.println(nonZeroNumCnt % 2 == 0 ? sum : (sum - 2 * minElement));
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

		int[][] readIntGrid(int row, int col) {
			int[][] grid = new int[row][col];
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					grid[i][j] = nextInt();
				}
			}
			return grid;
		}
	}

}
