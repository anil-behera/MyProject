package org.anil.ms.morg;

public class EggDroppingProblem {

	public static void main(String[] args) {
		System.out.println(eggDrop(2, 36));

	}

	private static int eggDrop(int eggs, int floor) {
		int result = 0;
		int[][] eggFloor = new int[eggs + 1][floor + 1];
		for (int i = 1; i <= eggs; i++) {
			eggFloor[i][0] = 0;
			eggFloor[1][1] = 1;
		}
		for (int i = 1; i <= floor; i++) {
			eggFloor[1][i] = i;
		}
		for (int i = 2; i <= eggs; i++) {
			for (int j = 2; j <= floor; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (int k = 1; k <= j; k++) {
					result = 1+max(eggFloor[i - 1][k - 1], eggFloor[i][j - k]);
					if(result<eggFloor[i][j]) {
						eggFloor[i][j]=result;
					}
				}

			}
		}
		return eggFloor[eggs][floor];
	}

	private static int max(int x, int y) {

		return x > y ? x : y;
	}

}
