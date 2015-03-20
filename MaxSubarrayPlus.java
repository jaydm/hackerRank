import java.util.Scanner;

public class MaxSubarrayPlus {
	public int maxContiguous = 0;
	public int maxPositive = 0;

	public void maxSubArray(int[] A) {
		int newsum = A[0];

		maxContiguous = A[0];
		maxPositive = A[0];

		for (int i = 1; i < A.length; i++) {
			newsum = Math.max(newsum + A[i], A[i]);
			maxContiguous = Math.max(maxContiguous, newsum);

			if (maxPositive < 0) {
				if (A[i] > maxPositive) {
					maxPositive = A[i];
				}
			} else if (A[i] > 0) {
				maxPositive += A[i];
			}
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		MaxSubarrayPlus work = new MaxSubarrayPlus();

		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			int size = in.nextInt();

			int[] data = new int[size];

			for (int j = 0; j < size; j++) {
				data[j] = in.nextInt();
			}

			work.maxSubArray(data);

			System.out.println(work.maxContiguous + " " + work.maxPositive);
		}

		in.close();
	}
}
