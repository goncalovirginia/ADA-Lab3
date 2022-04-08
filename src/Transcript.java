import java.util.HashMap;
import java.util.Map;

public class Transcript {
	
	private final String[] keyboard;
	private final String objective, typed;
	private final int MAX_POINTS;
	private final Map<Character, Integer[]> keyCoordinates;
	
	public Transcript(String[] keyboard, String objective, String typed) {
		this.keyboard = keyboard;
		this.objective = " " + objective;
		this.typed = " " + typed;
		MAX_POINTS = Math.max(this.keyboard.length, this.keyboard[0].length());
		keyCoordinates = new HashMap<>();
		fillKeyCoordinatesMap();
	}
	
	private void fillKeyCoordinatesMap() {
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[0].length(); j++) {
				keyCoordinates.put(keyboard[i].charAt(j), new Integer[] {i, j});
			}
		}
	}
	
	public int solve() {
		return solve(objective.length() - 1, typed.length() - 1);
	}
	
	private int solve(int i, int j) {
		if (i == 0) {
			return 0;
		}
		if (j == 0) {
			return solve(i-1, j) - MAX_POINTS;
		}
		
		return Math.max(solve(i-1, j-1) + MAX_POINTS - distance(objective.charAt(i), typed.charAt(j)), solve(i-1, j) - MAX_POINTS);
	}
	
	private int distance(char key1, char key2) {
		Integer[] key1Coordinates = keyCoordinates.get(key1);
		Integer[] key2Coordinates = keyCoordinates.get(key2);
		
		return Math.max(Math.abs(key1Coordinates[0] - key2Coordinates[0]),
				Math.abs(key1Coordinates[1] - key2Coordinates[1]));
	}
	
}
