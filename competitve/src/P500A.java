import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

public class P500A {
	
	private static int mod = 1;

	public static void main(String[] args) {
		testCase(true);
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
			int n = fs.nextInt();
			int t = fs.nextInt();
			int[] p = fs.readArray(n-1);
			int start = 1;
			while(t > start) {
				start = start + p[start-1];
			}
			print(t == start ? "YES" : "NO");
		} else {
			int n = 2;
			int p = 10;
			print(binPower(n,p));
			print(gcd(20, 4));
		}
	}
	
	private static long binPower(int n, int p) {
		long ans = 1;
		while(p > 0) {
			if((p & 1) == 1) {
				ans = ans * n;
			}
			n = n * n;
			p = p >> 1;
		}
		return ans;
	}
	
	private static long mulUnderMod(int m, int n) {
		return ((m % mod) * (n % mod)) % mod;
	}
	
	private static int gcd(int a, int b) {
		int temp;
		if(a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		while(b > 0) {
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
