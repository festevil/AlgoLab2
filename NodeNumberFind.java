package textrileread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NodeNumberFind {

	public static int Nodenum(String ins) {

		int i = 0;
		Scanner copyscan;
		try {
			copyscan = new Scanner(new File(ins));
			while(!copyscan.hasNextInt()) {
				copyscan.nextLine();
			}
			while (copyscan.hasNextInt()) {
				int a = copyscan.nextInt();
				if (a > i) {
					i = a;
				}
			}
			copyscan.close();

			return i;
		} catch (FileNotFoundException e) {
			//
			e.printStackTrace();
		}
		return -1;

	}
}
