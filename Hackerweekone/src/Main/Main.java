package Main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		System.out.println("What is n?");
		int n = in.nextInt();
		int q = n + 2;
		int line = 2;
		for (int x = 2; x < q; x++) {
			String out = "";
			int outSpace = (q - line);
			int outPound = (q - outSpace);
			for (int i = 1; i != outSpace; i++) {
				out = out + " ";
			}
			for (int i = 1; i != outPound; i++) {
				out = out + "#";
			}
			System.out.println(out);
			line++;
		}
		in.close();
	}

}
