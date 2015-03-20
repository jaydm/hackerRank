import java.util.Scanner;

public class SumOfFactors {
	public static long sumOfXBelowIterative(int x, long below) {
		// System.out.println("Finding sum of factors of " + x + " below " +
		// below);

		long count = (long) (below - 1) / x;
		long total = 0;

		// System.out.println("Adding...");

		for (int i = 1; i <= count; i++) {
			// System.out.println("..." + (x * i));

			total += (x * i);
		}

		// System.out.println("Totals: " + total);
		// System.out.println();

		return total;
	}

	private static long identity(long cap) {
		return (cap * (cap + 1)) / 2;
	}

	public static long sumOfXBelowIdentity(int x, long below) {
		long count = (long) (below - 1) / x;

		return x * identity(count);
	}

	public static long sumOfThreeAndFiveBelow(long cap) {
		return sumOfXBelowIdentity(3, cap) + sumOfXBelowIdentity(5, cap) - sumOfXBelowIdentity(15, cap);
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			long cap = in.nextLong();

			System.out.println(sumOfThreeAndFiveBelow(cap));
		}

		in.close();
	}
}
