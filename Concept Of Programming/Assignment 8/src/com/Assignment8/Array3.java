package com.Assignment8;

import java.util.Arrays;
import java.util.Scanner;

public class Array3 {

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
		Arrays.sort(arr);
		System.out.println("Highest= " + arr[n - 1] + "\nSecond Highest= " + arr[n - 2]);
		System.out.println(Arrays.toString(arr));
		sc.close();
	}

}
