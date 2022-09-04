package com.basic.Operators;

import java.util.Date;
import java.util.Scanner;

public class otherOperators {
	public static void main(String[] args) {
		// 创建Scanner对象，接受从控制台输入
		Scanner input1 = new Scanner(System.in);
		System.out.println("请输入满分成绩：");
		//接受String类型
		int fullMark = Integer.parseInt(input1.next());
		while (1 == 1) {
			if (fullMark == 0){
				break;
			}
			Scanner input2 = new Scanner(System.in);
			System.out.println("请输入分数：");
			int score = Integer.parseInt(input2.next());
			    if (score == 0){
					break;
				}
			String result = score >= fullMark*0.6 ? "及格" : "不及格"; // 三元运算符（? : ）
			System.out.println(result);
			Date date = new Date();  // new运算符可以创建Date对象
			System.out.println(date.toString());  //通过.运算符调用方法
		}
	}
}
