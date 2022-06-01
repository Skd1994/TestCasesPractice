package com.ArrayTest;

public class TwoDimensionalArrayTest {
	public static void main(String[] args) {
		
		//String[] arr ={"welcome", "to", "tyss"};
		
		String[][] arr = new String[3][2];
		arr[0][0] = "karnataka";
		arr[0][1] = "bangalore";
		
		arr[1][0] = "tamilnadu";
		arr[1][1] = "chennai";
		
		arr[2][0] = "jharkhand";
		arr[2][1] = "jamshedpur";
		
		System.out.println(arr[2][0]);
	}

}
