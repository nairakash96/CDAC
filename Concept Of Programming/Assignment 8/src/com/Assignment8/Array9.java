package com.Assignment8;

public class Array9 {

	public static void main(String[] args) {
		int arr1[]= {1,2,3,4,5};
		int arr2[]= {5,39,28,8,9};
		for (int i=0;i<5;i++) {
			for(int j=i+1;j<5;j++) {
			if(arr1[i]==arr2[j]) {
				System.out.print(arr1[i]+" ");
			}
		}
	}

}
}
