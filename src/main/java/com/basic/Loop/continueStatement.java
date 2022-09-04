package com.basic.Loop;

public class continueStatement{
	public static void main ( String args[] ) {
		// 不带标签的continue语句
		// 当执行到continue语句时，continue语句会终止当前循环，其他循环不影响
		int [] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		for ( int i = 0; i < numbers.length; i++) {
			if ( i ==4 ) {
				continue;
			}
			System.out.println( i );
		}
		
		// 带标签continue的语句
		// 当执行到continue语句，continue语句会终止带相应标签的循环
		// 用for循环输出xy分别从0-5的坐标，利用带标签的continue语句去除x=y时的坐标
		label1:
		for ( int x = 0; x <= 5; x++ ) {
			for ( int y = 5; y >= 0; y-- ) {
				if ( y == x ) {
					continue label1;
				}
				// 在不换行的打印输出时 可以用%d来指定输出int类型数据
				System.out.printf( "(x,y) = (%d,%d)", x, y);
				System.out.println( "" );
			}
		}
	}
}
