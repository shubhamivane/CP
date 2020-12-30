import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class SpiralMatrix {

	/*
	 *	https://leetcode.com/problems/spiral-matrix/
	 */
	public static void main(String[] args) {
		testCase(false);
	}

	public static void testCases() {
		FastScanner fs = new FastScanner();
		int T = fs.nextInt();
		for (int tt = 0; tt < T; tt++) {
			testCase(true);
		}
	}

	public static void testCase(boolean flag) {
		if (flag) {
			FastScanner fs = new FastScanner();
		} else {
//			int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//			int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}, {13,14,15,16}};
//			int[][] matrix = {{1},{2},{3}};
			int[][] matrix = {{1,2},{3,4},{5,6}};
			print(spiralOrder(matrix));
		}
	}

	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		int rows = matrix.length;
		int cols = matrix[0].length;
		int i = 0, k = 0;
		while(true) {
			if(i >= (rows+1)/2 || k >= (cols+1)/2) break;
			result.add(matrix[i][i]);
			int row = i;
			int col = i + 1;
			for(int j = col ; j < cols - i; j++) {
//				System.out.println("1. row: " + row + " col: " + j);
				result.add(matrix[row][j]);
			}
			row = i + 1;
			col = cols - i - 1;
			for(int j = row ; j < rows - i ; j++) {
//				System.out.println("2. row: " + j + " col: " + col);
				result.add(matrix[j][col]);
			}
			row = rows - i - 1;
			col = cols - i - 1 - 1;
			for(int j = col ; j >= i && row > i ; j--) {
//				System.out.println("3. row: " + row + " col: " + j);
				result.add(matrix[row][j]);
			}
			row = rows - i - 1 - 1;
			col = i;
			for(int j = row ; j > i && col < cols - 1 - i; j--) {
//				System.out.println("4. row: " + j + " col: " + col);
				result.add(matrix[j][col]);
			}
			i++;
			k++;
		}
		return result;
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

}
