package com.Assignment8;

import java.util.Arrays;
import java.util.Scanner;

public class Array5 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int l1,l2,n;
		System.out.println("Enter size of first array");
		l1=sc.nextInt();
		System.out.println("Enter size of second array");
		l2=sc.nextInt();
		int arr1[] = new int[l1];
		int arr2[] = new int[l2];
		n = l1 + l2;
		System.out.println("Enter elements of first array");
		for (int i = 0; i < l1; i++) {
			arr1[i] = sc.nextInt();
		}
		System.out.println("Enter elements of second array");
		for (int i = 0; i < l2; i++) {
			arr2[i] = sc.nextInt();
		}
		int arr3[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (i < l1) {
				arr3[i] = arr1[i];
			} else {
				arr3[i] = arr2[i - l1];
			}
		}
		System.out.println("Array1=" + Arrays.toString(arr1));
		System.out.println("Array2=" + Arrays.toString(arr2));
		System.out.println("Array3=" + Arrays.toString(arr3));
		sc.close();
	}
}
