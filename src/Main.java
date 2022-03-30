import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		TurboScanner in = new TurboScanner(System.in);
		int rows = in.nextInt();
		String[] keyboard = new String[rows];
		
		for (int i = 0; i < rows; i++) {
			keyboard[i] = in.nextLine();
		}
		
		System.out.println(new Transcript(keyboard, in.nextLine(), in.nextLine()).solve());
	}
	
}
