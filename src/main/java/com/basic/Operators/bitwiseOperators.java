package com.basic.Operators;

public class bitwiseOperators{
	public static void main (String args[]){
		byte a = 0B00110010;  //十进制50
		byte b = 0B01011110;  // 十进制94
		System.out.println("a | b = " + (a | b));  		// a和b位进行位或运算 0B01111110
		System.out.println("a & b = " + (a & b));  		// a和b位进行位与运算 0B00010010
		System.out.println("a ^ b = " + (a ^ b));  		// a和b位进行位异或运算 0B01101100
		System.out.println("~b = " + (~b)); 			// 将b的值按位取反 0B10100001
		System.out.println("a >> 2 = " + (a >> 2));  	// 有符号右移，a右移2位，高位采用符号位补位 0B00001100
		System.out.println("a >> 1 = " + (a >> 1));  	// 0B00011001
		System.out.println("a >>> 2 = " + (a >>> 2)); 	// 无符号右移，a右移2位，高位用0补位 0B00001100
		/*
			无符号右移>>>运算符仅被允许用在int和long类型
			如果用于short或byte数据，则数据在位移前转换位int类型再进行位移计算
		*/
		System.out.println("a << 2 = " + (a << 2));  	// 左移，a左移2位，低位用0补位 0B11001000
		System.out.println("a << 1 = " + (a << 1));  	// 0B01100100
		/*
			有符号右移n位相当于操作数除以2^n
			有符号左移n位相当于操作数乘以2^n
		*/
		int c = -12;
		System.out.println("c >>> 2 = " + (c >>> 2));
		/*
			变量c为负数，通过以上代码的结果可以看出，c>>>2的结果为1073741821，从一个负数变为一个如此之大的正数
			这说明无符号右移对于负数计算会导致精度的丢失
			而有符号右移对于负数的计算是正确的，例如下列代码运算：c>>2
		*/
		System.out.println("c >> 2 = " + (c >> 2));

		System.out.println("a &= b" + (a &= b));		// 等价于a = a&b
		System.out.println("a |= b" + (a |= b));		// 等价于a = a|b
		System.out.println("a ^= b" + (a ^= b));		// 等价于a = a^b
		System.out.println("a <<= b" + (a <<= b));		// 等价于a = a<<b
		System.out.println("a >>= b" + (a >>= b));		// 等价于a = a>>b
		System.out.println("a >>>= b" + (a >>>= b));	// 等价于a = a>>>b
	}
}
