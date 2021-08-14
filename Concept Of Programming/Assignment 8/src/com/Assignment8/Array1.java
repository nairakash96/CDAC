package com.Assignment8;

import java.util.Scanner;

public class Array1 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n;
		double avg,sm=0;
		System.out.print("Enter size of array ");
		n=sc.nextInt();
		int arr[]=new int[n];
		System.out.println("Enter array elements  ");
		for(int i:arr) {
			arr[i]=sc.nextInt();
			sm+=arr[i];
		}
		avg=sm/n;
		System.out.println("Sum= "+sm+"\nAvrage= "+avg);
		sc.close();
	}

}
