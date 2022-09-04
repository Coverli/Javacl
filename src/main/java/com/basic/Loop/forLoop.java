package com.basic.Loop;

public class forLoop{
	public static void main (String args[]){
		int i;
		int j;
		// 用 for 循环打印出九九乘法表
		for ( i = 1; i <= 9; i++) {
			for ( j = 1; j <=i; j++) {
				System.out.print( i + "x" + j + " = "+ i * j + "   ");
			}
			System.out.println("  ");
		}
	}
}
