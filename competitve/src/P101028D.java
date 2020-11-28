import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P101028D {

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
		int[] raw = fs.readArray(3);
		int row = raw[0];
		int col = raw[1];
		int instruction = raw[2];
		char[][] grid = new char[row][];
		for (int i = 0; i < row; i++) {
			grid[i] = new char[col];
			Arrays.fill(grid[i], '.');
		}
		int xCord1, xCord2, yCord1, yCord2;
		char color;
		for (int i = 0; i < instruction; i++) {
			xCord1 = fs.nextInt();
			yCord1 = fs.nextInt();
			xCord2 = fs.nextInt();
			yCord2 = fs.nextInt();
			color = fs.nextChar();
			System.out.println(xCord1 + "," + yCord1 + "," + xCord2 + "," + yCord2 + "," + color);
			fillGrid(xCord1 - 1, yCord1 - 1, xCord2 - 1, yCord2 - 1, color, grid);
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void fillGrid(int x1, int y1, int x2, int y2, char ch, char[][] grid) {
		for (int i = x1; i <= x2; i++) {
			for (int j = y1; j <= y2; j++) {
				grid[i][j] = ch;
			}
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

}
