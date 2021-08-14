package com.Assignment8;

import java.util.Scanner;

public class Array8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n,i,j,k=0;
		System.out.print("Enter size of array ");
		n = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[]=new int[n];
		System.out.println("Enter array elements  ");
		for (i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		for(i=0;i<n;i++) {
			for(j=i+1;j<n;j++) {
				if(arr1[i]==arr1[j]) {
					arr2[k]=arr1[i];
					k++;
					break;
				}
			}
		}
		System.out.println("Duplicate elements are ");
		for(int ele:arr2) {
			System.out.print(ele+" ");
		}
		sc.close();
	}

}
