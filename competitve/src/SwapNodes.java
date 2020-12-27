import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SwapNodes {

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

	public static void nextPermutation(int[] nums) {
		int startIdx = -1;
		int endIdx = nums.length;
		boolean flag = false;
		for (int i = nums.length - 1; i > 0; i--) {
			for (int j = i - 1; j >= 0; j--) {
				System.out.println("nums[" + i + "] = " + nums[i] + ", nums[" + j + "] = " + nums[j]);
				if (nums[i] > nums[j]) {
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					startIdx = j;
					endIdx = i;
					System.out.println(startIdx + " " + nums[startIdx] + " " + endIdx + " " + nums[endIdx]);
					flag = true;
					break;
				}
			}
			if (flag)
				break;
		}
		if (endIdx - startIdx > 1) {
			Arrays.sort(nums, startIdx + 1, nums.length);
		}
	}

	public static void testCase() {
		FastScanner fs = new FastScanner();
		int n = fs.nextInt();
		int[] arr = fs.readArray(n);
		nextPermutation(arr);
		System.out.print(Arrays.toString(arr));
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
