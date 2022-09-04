package com.basic.Loop;

import java.util.Scanner;

public class dowhileLoop{
	public static void main ( String args[] ) {
		int a = 0;
		int b = 0;
		Scanner input = new Scanner ( System.in );
		int number1 = Integer.parseInt(input.next());
		int number2 = number1;
		// 当输入数值为0时，无法进入while循环
		// 而在 do-while 循环当中需要先 do 一次再进行 while 判断
		while ( number1 > 0 ) {
			number1=number1-1;
			a++;
			System.out.println( "while循环" + a + "次" );
		}
		do {
			number2=number2-1;
			b++;
			System.out.println( "do-while循环" + b + "次" );
		} while ( number2 > 0 );
	}
}
