package textrileread;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Hosp {
	
	public static int[] gethospitalarray() {
		System.out.println("Enter filepath to set up hospital array");
		Scanner scan = new Scanner(System.in);
		String filepa = scan.nextLine();
		try {
			Scanner filescan = new Scanner(new File(filepa));
			filescan.next();
			int hospitalnum = filescan.nextInt();
			int[] hospitalnodes = new int[hospitalnum];
			for(int i=0;i<hospitalnum;i++) {
				hospitalnodes[i] = filescan.nextInt();
			}
			scan.close();
			filescan.close();
			return hospitalnodes;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			scan.close();
		}
		return null;
	}

}
