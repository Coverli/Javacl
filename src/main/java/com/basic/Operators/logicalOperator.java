package com.basic.Operators;

import java.util.Scanner;

public class logicalOperator{
	public static void main (String args[]){
		int i = 0;
		int a = 10;
		int b = 9;
		/*
			||和&& 与 |和& 的区别：
				&&：当第一个计算式判断为false时，则不计算第二个计算式，因为结果必为false
				||：当第一个计算式判断为true时，则不计算第二个计算式，因为结果必为true
				|和&：无论如何两条计算式结果如何都会进行计算
			短路与（&&）和短路或（||）能够采用最优化的计算方式，从而提高效率。
			在实际编程时，应该优先考虑使用短路与和短路或。
		*/
		if ((a > b) || (i == 1)) {
			System.out.println("(a > b) || (i == 1)结果为 真");
		} else {
			System.out.println("(a > b) || (i == 1)结果为 假");
		}
		if ((a < b) && (i == 1)) {
			System.out.println("(a < b) && (i == 1)结果为 真");
		} else {
			System.out.println("(a < b) && (i == 1)结果为 假");
		}
		if ((a > b) || (a++ == --b)) {
			System.out.println("a++ = " + a++);
			System.out.println("--b = " + --b);
		}
	}
}
