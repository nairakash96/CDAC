package com.Assignment8;

import java.util.Arrays;
import java.util.Scanner;

public class Array2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter size of array ");
		n = sc.nextInt();
		int arr1[] = new int[n];
		System.out.println("Enter array elements  ");
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("Before Reversal\nArray="+Arrays.toString(arr1));
		for (int i=0;i<n/2;i++) {
			int temp=arr1[i];
			arr1[i]=arr1[n-i-1];
			arr1[n-1-i]=temp;
		}
		System.out.println("After Reversal\nArray="+Arrays.toString(arr1));
		sc.close();
	}

}
