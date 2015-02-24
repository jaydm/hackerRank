// class contents
	private static void show(int[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			// System.out.print(sequence[i]);
		}

		// System.out.println();
	}

	private static int permutations(int[] sequence, int numberOfSetDigits) {
		// System.out.print("Starting with: ");
		show(sequence);

		// System.out.println("Seeking " + numberOfSetDigits +
		// " digits set to one...");

		int bubbles = 0;

		while (true) {
			int pos = sequence.length - 1;
			int ones = 0;

			sequence[pos]++;
			int testPos = pos;

			if (sequence[0] > 1) {
				break;
			}

			while (testPos > 0) {
				if (sequence[testPos] > 1) {
					sequence[testPos] = 0;
					sequence[testPos - 1]++;
				}

				testPos--;
			}

			ones = 0;

			for (int i = 0; i < sequence.length; i++) {
				if (sequence[i] == 1) {
					ones++;
				}
			}

			// System.out.println("Came up with " + ones + " ones...");

			if ((sequence[0] == 1) && (ones == numberOfSetDigits)) {
				// System.out.println("Bubbles!!!");

				bubbles++;
			}

			// System.out.print("Bubbles:  " + bubbles + "     ");
			show(sequence);
		}

		return bubbles;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int cases = in.nextInt();

		for (int i = 0; i < cases; i++) {
			int n = in.nextInt();
			int m = in.nextInt();

			int[] sequence = new int[n + m];

			for (int j = sequence.length - 1; j > 0; j--) {
				sequence[j] = 1;

				show(sequence);
			}

			sequence[0] = 0;

			System.out.println(permutations(sequence, m));
		}

		in.close();
	}
