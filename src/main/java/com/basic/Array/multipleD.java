package com.basic.Array;

import java.util.*;
import java.lang.Math;

public class multipleD
{
	public static void main (String args[] ) {
		multipleD md = new multipleD();
		md.staticInitialize();
		md.dynamicInitialize();
		md.squareCal();
		md.irregularArray();
	}
	
	// 二维数组声明，有以下三种形式
	int[][] array1;
	int array2[][];
	int[] array3[];
	
	// 静态初始化
	void staticInitialize () {
		/*
			以下代码创建并初始化了一个4×3二维数组，
			理解Java中的多维数组应该从数组的数组的角度出发。
			首先将intArray看成是一个一维数组，它有4个元素，
			其中第1个元素是{ 1, 2, 3 }，第2个元素是{ 11, 12, 13 }，第3个元素是{ 21, 22, 23 }，第4个元素是{ 31, 32, 33 }。
			然后再分别考虑每一个元素，{ 1, 2, 3 }表示形式说明它是一个int类型的一维数组，其他3个元素也是一维int类型数组
			
			意义上说Java中并不存在真正意义上的多维数组，
			只是一维数组，不过数组中 的元素也是数组，
			以此类推三维数组就是数组的数组的数组了，例如{ { {1, 2}, {3} }, { {21}, {22, 23} } }表示一个三维数组。
		*/
		int[][] intArray = {{ 1, 2, 3 },
							{ 11, 12, 13 },
							{ 21, 22, 23 },
							{ 31, 32, 33 }};
		System.out.println("二维数组静态初始化");
		for ( int arr[] : intArray ) {
			for (int i : arr ) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 动态初始化
	void dynamicInitialize () {
		// new 元素数据类型[高维数组长度][低维数组长度]
		int[][] dynamicArray = new int[4][3];
		System.out.println("二维数组动态初始化默认值");
		for ( int arr[] : dynamicArray ) {
			for (int i : arr ) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 案例：动态二维数组赋值
	void squareCal () {
		// 计算intArray数组元素的平方根，结果保存到数组squareArray中
		int[][] intArray = {{ 1, 2, 3 },
							{ 11, 12, 13 },
							{ 21, 22, 23 },
							{ 31, 32, 33 }};
		int[][] squareArray = new int[intArray.length][intArray[0].length];
		for ( int i = 0; i < intArray.length; i++ ) {
			for ( int j = 0; j < intArray[i].length; j++) {
				// Math是java.lang包中提供的用于数学计算类，它提供很多常用的数学计算方法，sqrt是计算平方根，如取绝对值的abs、幂运算的pow等。
				// Math.sqrt()计算的结果为double类型，进行强转为int类型
				squareArray[i][j] = (int)Math.sqrt(intArray[i][j]);
			}
		}
		System.out.println("赋值后结果");
		for ( int arr[] : squareArray ) {
			for (int i : arr ) {
				System.out.print(i + "  ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	// 不规则数组
	void irregularArray () {
		/*
			由于Java多维数组是数组的数组，因此会衍生出一种不规则数组，规则的4×3二维数组有12个元素，而
			不规则数组就不一定了。如下代码静态初始化了一个不规则数组。
		*/
		int intArray1[][] = {{ 1, 2 },
							{ 11 },
							{ 21, 22, 23 },
							{ 31, 32, 33 } };
		
		/*
			动态初始化不规则数组比较麻烦，不能使用new int[4][3]语句，
			而是先初始化高维数组，然后再分别逐 个初始化低维数组。
		*/
		int intArray[][] = new int[4][]; //先初始化高维数组为4
		//逐一初始化低维数组
		intArray[0] = new int[2];
		intArray[1] = new int[1];
		intArray[2] = new int[3];
		intArray[3] = new int[3];
		
		//for循环遍历
		for (int i = 0; i < intArray.length; i++) {
			for (int j = 0; j < intArray[i].length; j++) {
				intArray[i][j] = i + j;
			}
		}
		
		// for-each循环遍历
		for (int[] row : intArray) {
			for (int column : row) {
				System.out.print(column); 
				//在元素之间添加制表符
				System.out.print('\t');
			}
			//一行元素打印完成后换行
			System.out.println();
		}
		//System.out.println(intArray[0][2]); //发生运行期错误，数组下标越界异常
	}
}
