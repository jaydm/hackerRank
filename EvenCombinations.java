import java.util.Scanner;

public class EvenCombinations {
	private int count = 0;

	public EvenCombinations() {
	}

	private boolean even(int[] list) {
		int total = 0;

		for (int i = 0; i < list.length; i++) {
			total += list[i];
		}

		return ((total % 2) == 0);
	}

	public void combinations(int[] list) {
		count = 0;

		for (int i = 1; i <= list.length; i++) {
			int[] data = new int[i];

			combinations(list, data, 0, list.length - 1, 0, i);
		}

		return;
	}

	private void combinations(int[] list, int[] data, int start, int end, int index, int r) {
		if (index == r) {
			for (int j = 0; j < r; j++) {
				// System.out.print(data[j]);
			}

			if (even(data)) {
				// System.out.println("...Even!");

				count += 1;
			} else {
				// System.out.println();
			}

			return;
		}

		for (int i = start; (i <= end) && (end - i + 1 >= r - index); i++) {
			data[index] = list[i];

			combinations(list, data, i + 1, end, index + 1, r);
		}
	}

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);

		int n = in.nextInt();

		int[] list = new int[n];

		for (int i = 0; i < n; i++) {
			list[i] = in.nextInt();
		}

		for (int i = 0; i < n; i++) {
			// System.out.print(list[i] + ", ");
		}

		EvenCombinations work = new EvenCombinations();

		work.combinations(list);

		System.out.println(work.count);

		in.close();
	}
}
