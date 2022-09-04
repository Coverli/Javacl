package com.basic.Array;

import java.util.Date;
// import org.apache.http.conn.util.*;

public class oneD{
	public static void main ( String args[] ){
		oneD od = new oneD();
		od.dynamicArray();
		od.mergeArray();
		od.modifyLength();
		od.rollbackArray();
		od.min();
		od.max();
		od.param();
		od.asReturn();
	}
	// 数组声明方法有以下两种，建议使用第一种
	int intArray1[];
	int[] intArray2;
	
	// 其他数据类型数组定义
	int intArray[];
	float floatArray[];
	String stringArray[];
	Date[] dateArray;
	
	// 数组静态初始化
	// 静态初始化就是将数组的元素放到 {} 里，元素间用 , 隔开
	void staticArray () {
		// int类型数组静态初始化
		// int intArray4[];
		// intArray4 = {21, 32, 43, 45};
		
		// String类型数字静态初始化
		// String strArray[];
		// strArray = {"张三", "李四", "王五"};
		
		// 定义数组同时初始化数组
		int intArray[] = { 21, 32, 43, 45 };
		String strArray[] = { "张三", "李四", "王五" };
	}
	
	// 数组动态初始化
	// 动态初始化使用 new 运算符分配指定长度的内存空间
	void dynamicArray () {
		// int类型
		int intArray[] = new int[4];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		
		// String类型
		String[] stringArray = new String[3];
		stringArray[0] = "张三";
		stringArray[1] = "李四";
		stringArray[2] = "王五";
		
		/*
			使用 new 分配数组内存空间后，
			数组中元素的内容为默认值
			
			数据类型默认值：
			byte -> 0
			short -> 0
			int -> 0
			long -> 0L
			float -> 0.0f
			double -> 0.0d
			char -> '\u0000'
			boolean -> false
			引用 -> null
		*/
		byte byteArray[] = new byte[1];
		System.out.print( "byte类型数组默认值 -> " );
		for ( byte i : byteArray ) {
			System.out.println(i);
		}
		short shortArray[] = new short[1];
		System.out.print( "short类型数组默认值 -> " );
		for ( short i : shortArray ) {
			System.out.println(i);
		}
		int intArray1[] = new int[1];
		System.out.print( "int类型数组默认值 -> " );
		for ( int i : intArray1 ) {
			System.out.println(i);
		}
		long longArray[] = new long[1];
		System.out.print( "long类型数组默认值 -> " );
		for ( long i : longArray ) {
			System.out.println(i);
		}
		float floatArray[] = new float[1];
		System.out.print( "float类型数组默认值 -> " );
		for ( float i : floatArray ) {
			System.out.println(i);
		}
		double doubleArray[] = new double[1];
		System.out.print( "double类型数组默认值 -> " );
		for ( double i : doubleArray ) {
			System.out.println(i);
		}
		char charArray[] = new char[1];
		System.out.print( "char类型数组默认值 -> " );
		for ( char i : charArray ) {
			System.out.println(i);
		}
		boolean booleanArray[] = new boolean[1];
		System.out.print( "boolean类型数组默认值 -> " );
		for ( boolean i : booleanArray ) {
			System.out.println(i);
		}
		System.out.println();
	}
	
	// 案例：数组合并
	void mergeArray () {
		
		// 两个待合并数组
		int array1[] = { 1, 2, 3, 4 };
		int array2[] = { 5, 6, 7, 8 };
		
		// 设置长度为两个数组长度长度之和的数组用以接受合并后数组
		int array[] = new int[array1.length + array2.length];
		
		System.out.println("数组1合并前");
		for ( int i : array1) {
			System.out.printf("%d", i);
		}
		System.out.println();
		System.out.println("数组2合并前");
		for ( int i : array2) {
			System.out.printf("%d", i);
		}
		System.out.println();
		
		// 用 for 循环添加数组内容
		for ( int i = 0; i < array.length; i++ ) {
			if ( i < array1.length ) {
				array[i] = array1[i];
		 	} else {
				array[i] = array2[i-array1.length];
			}
		}
		System.out.println("数组合并后");
		for ( int i : array) {
			System.out.printf("%d", i);
		}
		System.out.println();
		System.out.println();
	}
	
	// 动态初始化后修改长度
	void modifyLength () {
		int[] intArray = new int[4];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		System.out.println("修改长度前");
		for ( int i : intArray ) {
			System.out.printf("%d", i);
		}
		System.out.println();
		// 修改数组长度为5，修改后数组元素全部改为默认值
		intArray = new int[5];
		System.out.println("修改长度后");
		for ( int i : intArray ) {
			System.out.printf("%d", i);
		}
		System.out.println();
		System.out.println();
	}
	
	// 案例：数组反转
	void rollbackArray () {
		int[] intArray = new int[4];
		intArray[0] = 1;
		intArray[1] = 2;
		intArray[2] = 3;
		intArray[3] = 4;
		System.out.println("数组反转前");
		for ( int i : intArray ) {
			System.out.printf("%d", i);
		}
		System.out.println();
		
		int[] rollback = new int[intArray.length];
		for ( int i = 0; i <= intArray.length-1; i++ ) {
			rollback[intArray.length-1-i] = intArray[i];
		}
		System.out.println("数组反转前");
		for ( int i : rollback ) {
			System.out.printf("%d", i);
		}
		System.out.println();
		System.out.println();
	}

	// 找出数组中最小值
	void min () {
		int[] array = { 5, 15, 30, 20, 10000, -20, 30, 35 };

		int min = array[0]; // 比武擂台
		for (int i = 1; i < array.length; i++) {
			// 如果当前元素，比min更小，则换人
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println("最小值：" + min);
	}

	// 找出数组中最大值
	void max () {
		int[] array = { 5, 15, 30, 20, 10000, 30, 35 };

		int max = array[0]; // 比武擂台
		for (int i = 1; i < array.length; i++) {
			// 如果当前元素，比max更大，则换人
			if (array[i] > max) {
				max = array[i];
			}
		}
		System.out.println("最大值：" + max);
		System.out.println();
	}

	// 数组作为传参
	void param () {
		/*
			数组可以作为方法的参数。
			当调用方法的时候，向方法的小括号进行传参，传递进去的其实是数组的地址值。
 		*/
		int[] array = { 10, 20, 30, 40, 50 };
		System.out.println(array); // 地址值

		printArray(array); // 传递进去的就是array当中保存的地址值
		System.out.println();
	}
	/*
    三要素
    返回值类型：只是进行打印而已，不需要进行计算，也没有结果，用void
    方法名称：printArray
    参数列表：必须给我数组，我才能打印其中的元素。int[] array
     */
	public static void printArray(int[] array) {
		System.out.println("printArray方法收到的参数是：");
		System.out.println(array); // 地址值
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	void asReturn () {
		int[] result = calculate(10, 20, 30);

		System.out.println("asReturn方法接收到的返回值数组是：");
		System.out.println(result); // 地址值

		System.out.println("总和：" + result[0]);
		System.out.println("平均数：" + result[1]);
	}
	public static int[] calculate(int a, int b, int c) {
		int sum = a + b + c; // 总和
		int avg = sum / 3; // 平均数
		// 两个结果都希望进行返回

		// 需要一个数组，也就是一个塑料兜，数组可以保存多个结果
        /*
        int[] array = new int[2];
        array[0] = sum; // 总和
        array[1] = avg; // 平均数
        */

		int[] array = { sum, avg };
		System.out.println("calculate方法内部数组是：");
		System.out.println(array); // 地址值
		return array;
	}
}
