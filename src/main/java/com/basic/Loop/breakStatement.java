package com.basic.Loop;

public class breakStatement{
	public static void main ( String args[] ) {
		// 不带标签的break语句
		// 当执行到break语句时，break语句会终止循环
		int [] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for ( int i = 0; i < numbers.length; i++) {
			if ( i ==4 ) {
				break;
			}
			System.out.println( i );
		}
		
		// 带标签的break语句
		// 当执行到break语句，break语句会终止带相应标签的循环
		// 用for循环输出xy分别从0-5的坐标，当xy第一次相等之后跳出彻底循环
		label1:
		for ( int x = 0; x <= 5; x++ ) {
			for ( int y = 5; y >= 0; y-- ) {
				if ( y == x ) {
					break label1;
				}
				// 在不换行的打印输出时 可以用%d来指定输出int类型数据
				System.out.printf( "(x,y) = (%d,%d)", x, y);
				System.out.println( "" );
			}
		}
	}
}
