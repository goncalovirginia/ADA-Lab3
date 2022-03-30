public class Transcript {
	
	private final String[] keyboard;
	private final String objective, typed;
	private final int MAX_POINTS;
	
	public Transcript(String[] keyboard, String objective, String typed) {
		this.keyboard = keyboard;
		this.objective = " " + objective;
		this.typed = " " + typed;
		MAX_POINTS = Math.max(this.keyboard.length, this.keyboard[0].length());
	}
	
	public int solve() {
		return solve(objective.length() - 1, typed.length() - 1);
	}
	
	private int solve(int i, int j) {
		if (i == 0) {
			return 0;
		}
		if (i == 1 && j == 0) {
			return -MAX_POINTS;
		}
		if (i > j) {
			return Math.max(solve(i - 1, j - 1) + MAX_POINTS - distance(objective.charAt(i), typed.charAt(j)), solve(i - 1, j) - MAX_POINTS);
		}
		return solve(i - 1, j - 1) + MAX_POINTS - distance(objective.charAt(i), typed.charAt(j));
	}
	
	private int distance(char key1, char key2) {
		if (key1 == key2) {
			return 0;
		}
		
		int[] key1Coordinates = new int[0], key2Coordinates = new int[0];
		boolean key1Found = false;
		
		loop:
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[0].length(); j++) {
				if (keyboard[i].charAt(j) == key1 || keyboard[i].charAt(j) == key2) {
					if (!key1Found) {
						key1Coordinates = new int[]{i, j};
						key1Found = true;
					}
					else {
						key2Coordinates = new int[]{i, j};
						break loop;
					}
				}
			}
		}
		
		return Math.max(key2Coordinates[0] - key1Coordinates[0], key2Coordinates[1] - key1Coordinates[1]);
	}
	
}
