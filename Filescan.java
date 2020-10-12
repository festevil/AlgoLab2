package com.algo.graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filescan {

	public static void main(String[] args) {
		int i = 0;
		int count = 0;
		Scanner scanner = null;
		Scanner copyscan = null;
		try {
			File inputfile = new File("C:\\Users\\Benjamin Tan\\Downloads\\as20000102.txt\\as20000102.txt");
			scanner = new Scanner(inputfile);
			copyscan = new Scanner(inputfile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("File not found");
		} finally {
			    
				while (copyscan.hasNextInt()) {
					int a = copyscan.nextInt();					
			        if (a>i) {
						i = a;
					}
					
				}
				int[][] graph = new int[i+1][i+1];
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
			}
		}
}

