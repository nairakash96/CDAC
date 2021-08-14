package com.Assignment8;

import java.util.Arrays;
import java.util.Scanner;

public class Array11 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n;
		System.out.print("Enter size of array ");
		n = sc.nextInt();
		int arr[] = new int[n];
		System.out.println("Enter array elements  ");
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println("Befor Sorting "+Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("After Sorting "+Arrays.toString(arr));
		sc.close();
	}

}
