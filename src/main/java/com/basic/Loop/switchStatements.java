package com.basic.Loop;

import java.util.Scanner;

public class switchStatements{
	public static void main ( String args[] ) {
		System.out.println("请输入成绩");
		Scanner input = new Scanner (System.in);
		int score = Integer.parseInt(input.next());
		char grade;
		switch ( score /10 ) {
			case 9:
				grade = '优';
				break;
			case 8:
				grade = '良';
				break;
			case 7:		// case7是贯通的，与case6执行同一个代码块，后面可以不加break，
			case 6:
				grade = '中';
				break;
			default:		// 在前面所以case语句中都无法匹配后执行的语句
				grade = '差';
		}
		System.out.println("switch语句判定：" + grade);
	}
}
