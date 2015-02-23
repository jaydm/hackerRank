import java.util.Scanner;

public class EvenTree {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int nodes = in.nextInt();
		int vertices = in.nextInt();

		int weightChange;

		int[] graph = new int[nodes + 1];
		int[] weight = new int[nodes + 1];

		for (int i = 0; i < nodes + 1; i++) {
			graph[i] = 0;
			weight[i] = 1;
		}

		for (int i = 0; i < vertices; i++) {
			int node = in.nextInt();
			int parent = in.nextInt();

			weightChange = weight[node];

			graph[node] = parent;

			while (graph[node] != 0) {
				weight[graph[node]] += weightChange;

				node = graph[node];
			}
		}

		int cutOff = 2;
		int cuts = 0;

		int parent;

		int maxWeight = 0;

		for (int i = 0; i < weight[i]; i++) {
			maxWeight = (weight[i] > maxWeight ? weight[i] : maxWeight);
		}

		int oldCuts = -1;

		while (cuts != oldCuts) {
			oldCuts = cuts;

			while (cutOff < maxWeight) {
				for (int i = 0; i < vertices; i++) {
					if (weight[i] == cutOff) {
						cuts += 1;

						weightChange = weight[i];
						parent = i;

						while (graph[parent] != 0) {

							weight[parent] -= weightChange;

							parent = graph[parent];
						}

						graph[i] = 0;
					}
				}

				cutOff += 2;
			}

			cutOff = 2;
		}

		System.out.println(cuts);

		in.close();
	}
}
