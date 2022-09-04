package com.basic.Loop;

import java.util.Scanner;

public class ifStatement{
	public static void main(String args[]){
		// 由if语句引导的选择结构有if结构、if-else结构、else-if语句
		System.out.println("请输入成绩");
		Scanner input = new Scanner (System.in);
		int score = Integer.parseInt(input.next());
		/*
			使用Integer.valueOf()或Integer.parseInt()将String类型转换为int类型
			valueOf(String)方法会返回Integer类的对象
			parseInt(String)方法返回原始的int值
		*/
		// if结构
		if ( score >= 60) {
			System.out.println("if结构判定：成绩及格");
		}
		
		// if-else结果
		if ( score >= 90) {
			System.out.println("if-else结构判定：成绩优秀");
		} else {
			System.out.println("if-else结构判定：成绩未达到优秀");
		}
		
		// else-if结构
		if ( score >= 90) {
			System.out.println("else-if结构判定：A");
		} else if ( score >= 80) {
			System.out.println("else-if结构判定：B");
		} else if ( score >= 70) {
			System.out.println("else-if结构判定：C");
		} else if ( score >= 60) {
			System.out.println("else-if结构判定：D");
		} else {
			System.out.println("else-if结构判定：E");
		}
	}
}
