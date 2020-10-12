package com.algo.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filescan {

	@SuppressWarnings("finally")
	public static int[][] graphout() {
		int i = 0;
		int count = 0;
		Scanner scanner = null;
		Scanner copyscan = null;
		File inputfile = null;
		int[][] graph;
		try {
			inputfile = new File("C:\\Users\\Benjamin Tan\\Downloads\\as20000102.txt\\as20000102.txt");
			scanner = new Scanner(inputfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} finally {
			    i = NodeNumberFind.Nodenum(inputfile);
				
				graph = new int[i+1][i+1];
				for (int k = 0;k<i+1;k++) {
					for (int j = 0; j<i+1;j++) {
						graph[k][j] = 0;
					}
				}
				while (scanner.hasNextInt()) {
					int b = scanner.nextInt();					
			        int c = scanner.nextInt();
			        graph[b][c] = 1;
			        graph[c][b] = 1;			        					
				}
				for(int l = 0; l<i+1;l++) {
					graph[l][l] = 0;
				}
				scanner.close();
				return graph;
			}
		
		}
}

