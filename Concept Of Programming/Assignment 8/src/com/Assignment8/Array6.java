package com.Assignment8;

import java.util.Scanner;

public class Array6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arr1[] = { 1, 2, 3, 4, 5 };
		int len1 = arr1.length;
		int flag = 0, i;
		System.out.println("Enter the value to be searched  ");
		int n = sc.nextInt();
		for (i = 0; i < len1; i++) {
			if (n == arr1[i]) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			System.out.println(n + " is present in array");
		} else {
			System.out.println(n + " is not present");
		}
		sc.close();
	}
}
