package com.Assignment8;

import java.util.Arrays;

public class Array12 {

	public static void main(String[] args) {
		String str[]= {"Zebra","Xmas","Alpha","Self","Jack","Apple","Akash"};
		System.out.println("Before :"+Arrays.toString(str));
		Arrays.parallelSort(str);
		System.out.println("After  :"+Arrays.toString(str));

	}

}
