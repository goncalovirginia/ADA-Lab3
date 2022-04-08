import java.util.HashMap;
import java.util.Map;

public class Transcript {
	
	private final String objective, typed;
	private final int MAX_POINTS;
	private final Map<Character, Integer[]> keyCoordinates;
	private final int[][] maxScore;
	
	public Transcript(String[] keyboard, String objective, String typed) {
		this.objective = " " + objective;
		this.typed = " " + typed;
		MAX_POINTS = Math.max(keyboard.length, keyboard[0].length());
		keyCoordinates = new HashMap<>();
		fillKeyCoordinatesMap(keyboard);
		maxScore = new int[this.objective.length()][this.typed.length()];
	}
	
	private void fillKeyCoordinatesMap(String[] keyboard) {
		for (int i = 0; i < keyboard.length; i++) {
			for (int j = 0; j < keyboard[0].length(); j++) {
				keyCoordinates.put(keyboard[i].charAt(j), new Integer[] {i, j});
			}
		}
	}
	
	public int solve() {
		for (int i = 1; i < objective.length(); i++) {
			maxScore[i][0] = maxScore[i-1][0] - MAX_POINTS;
		}
		
		for (int i = 1; i < objective.length(); i++) {
			for (int j = 1; j < typed.length(); j++) {
				if (j < i) {
					maxScore[i][j] = Math.max(maxScore[i-1][j-1] + MAX_POINTS - distance(objective.charAt(i), typed.charAt(j)), maxScore[i-1][j] - MAX_POINTS);
				}
				else {
					maxScore[i][j] = maxScore[i-1][j-1] + MAX_POINTS - distance(objective.charAt(i), typed.charAt(j));
					break;
				}
			}
		}
		
		return maxScore[objective.length()-1][typed.length()-1];
	}
	
	private int distance(char key1, char key2) {
		Integer[] key1Coordinates = keyCoordinates.get(key1);
		Integer[] key2Coordinates = keyCoordinates.get(key2);
		
		return Math.max(Math.abs(key1Coordinates[0] - key2Coordinates[0]), Math.abs(key1Coordinates[1] - key2Coordinates[1]));
	}
	
}
