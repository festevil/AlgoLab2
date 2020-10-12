package com.algo.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NodeNumberFind {

	public static int Nodenum(File ins) {

		int i=0;
		Scanner copyscan;
		try {
			copyscan = new Scanner(ins);
			while (copyscan.hasNextInt()) {
				int a = copyscan.nextInt();
				if (a > i) {
					i = a;
				}
			}
			return i;
		} catch (FileNotFoundException e) {
			// 
			e.printStackTrace();
		}
		return -1;

		
	}
}
