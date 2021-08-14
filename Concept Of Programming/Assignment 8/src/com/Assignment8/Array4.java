package com.Assignment8;

import java.util.Arrays;
import java.util.Scanner;

public class Array4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter size of array ");
		n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[]=new int[n];
		System.out.println("Enter array elements  ");
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			arr2[i]=arr1[i];
		}
		System.out.println("Array1="+Arrays.toString(arr1));
		System.out.println("Array2="+Arrays.toString(arr2));
		sc.close();
	}

}
