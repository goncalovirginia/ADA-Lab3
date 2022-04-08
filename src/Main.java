import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int rows = Integer.parseInt(in.readLine());
		String[] keyboard = new String[rows];
		
		for (int i = 0; i < rows; i++) {
			keyboard[i] = in.readLine();
		}
		
		System.out.println(new Transcript(keyboard, in.readLine(), in.readLine()).solve());
	}
	
}
