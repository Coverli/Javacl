package com.basic.DataType.DataTypeReference;

import java.util.Scanner;

public class Reference {
	public static void main (String args[]) {
		/*
			在Java中除了8种基本数据类型外，其他数据类型全部都是引用（reference）数据类型，
			引用数据类型，用来表示复杂数据类型，包含：类、接口和数组声明的数据类型。
			Java中的引用数据类型，相当于C等语言中指针（pointer）类型，
			引用事实上就是指针，是指向一个对象的内存地址。
			引用数据类型变量中保存的是指向对象的内存地址。
			很多资料上提到 Java不支持指针，事实上是不支持指针计算，而指针类型还是保留了下来，
			只是在Java中称为引用数据类型。
		*/

		int x = 1;
		int y = x;
		x+=1;
		System.out.println(x);
		System.out.println(y);
		System.out.println(System.identityHashCode(x));
		System.out.println(System.identityHashCode(y));

		String str1 = "123";
		String str2 = str1;
		String str3 = "123";
		str1 = str1.concat("4");
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);
		System.out.println(str1.getClass()+"@"+str1.hashCode());
		System.out.println(str2.getClass()+"@"+str2.hashCode());
		System.out.println(str3.getClass()+"@"+str3.hashCode());
		System.out.println("str1的内存地址是" + System.identityHashCode(str1));
		System.out.println("str2的内存地址是" + System.identityHashCode(str2));
		System.out.println("str3的内存地址是" + System.identityHashCode(str3));
	}
}