import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BinarySearchInRotatedArray {

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
		int n = fs.nextInt();
		int target = fs.nextInt();
		int[] arr = fs.readArray(n);
		print(findPivot(arr));
		print(search(arr, target));
	}

	public static int search(int[] nums, int target) {
		int pivotIdx = findPivot(nums);
		int result = -1;
		if(nums[nums.length-1] >= target) {
			result = Arrays.binarySearch(Arrays.copyOfRange(nums, pivotIdx, nums.length), target);
			return result < 0 ? -1 : (result + pivotIdx);
		} else {
			result = Arrays.binarySearch(Arrays.copyOfRange(nums, 0, pivotIdx), target);
			return result < 0 ? -1 : result;
		}
	}

	private static int findPivot(int[] nums) {
		int mid;
		int r = nums.length - 1;
		int l = 0;
		while (l < r) {
			mid = l + (r - l) / 2;
			if ((mid - 1 < 0 || nums[mid - 1] > nums[mid]) && (mid + 1 == nums.length || nums[mid + 1] > nums[mid])) {
				return mid;
			}
			if (nums[mid] < nums[r]) {
				r = mid - 1;
			} else
				l = mid + 1;
		}
		return l;
	}

	private static void print(int findPivot) {
		System.out.println(findPivot);
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
