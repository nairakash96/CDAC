package com.Assignment8;

import java.util.Scanner;

public class Array10 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int arr1[][]=new int[2][3];
		int arr2[][]=new int[2][3];
		int arr3[][]=new int[2][3];
		int i,j;
		System.out.println("Enter element of matrix 1");
		for(i=0;i<2;i++) {
			for(j=0;j<3;j++) {
				arr1[i][j]=sc.nextInt();
				}
		}
		System.out.println("Enter element of matrix 2");
		for(i=0;i<2;i++) {
			for(j=0;j<3;j++) {
				arr2[i][j]=sc.nextInt();
			}
		}
		System.out.println("Element of matrix 3");
		for(i=0;i<2;i++) {
			for(j=0;j<3;j++) {
				arr3[i][j]=arr1[i][j]+arr2[i][j];
				System.out.print(arr3[i][j]+" ");
			}
			System.out.println();
		}
		sc.close();
	}

}
