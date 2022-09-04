package com.basic.Loop;

public class foreachLoop{
	public static void main ( String args[] ) {
		/*
			foreach 循环语句是 Java 1.5 的新特征之一，
			在遍历数组、集合方面，foreach 为开发者提供了极大的方便。
			foreach 循环语句是 for 语句的特殊简化版本，主要用于执行遍历功能的循环。
		*/
		
		/*
			从以下示例中可以发现，
			item 不是循环变量，它保存了集合中的元素，
			for-each 语句将集合中的元素一一取出来，并保存到 item 中，
			这个过程中不需要使用循环变量，通过数组下标访问数组中的元素。
			可见 for-each 语句在遍历集合的时候要简单方便得多
		*/
		int[] numbers = { 43, 32, 53, 54, 75, 7, 10 };
		System.out.println("----for each----");
		// for-each语句
		for (int item : numbers) {
			System.out.println("Count is:" + item);
		}
		
		String[] languages={"Java","ASP.NET","Python","C#","PHP"};
		System.out.println("现在流行的编程语言有：");
		// 使用 foreach 循环语句遍历数组
		for(String lang:languages) {
			System.out.println(lang);
		}
		
		int arr[] = new int[10];
		// 用 for 循环往arr数组插入数据
		for ( int i = 0; i < arr.length; i++) {
			arr[i] = i + 1;
		}
		// 比较 for 循环和 for-each 循环的不同
		for ( int i = 0; i < arr.length; i++) {
			System.out.println( arr[i] );
		}
		for ( int i : arr) {
			System.out.println( i );
		}
		
		String[] urls = { "http://c.biancheng.net/java",
							"http://c.biancheng.net/c",
							"http://c.biancheng.net/golang/" };
		// 使用foreach循环来遍历数组元素，其中 book 将会自动迭代每个数组元素
		for (String url : urls) {
			url = "https://c.biancheng.net";
			System.out.println(url);
		}
		System.out.println(urls[0]);
		/*
			从上面运行结果来看，
			由于在 foreach 循环中对数组元素进行赋值，
			结果导致不能正确遍历数组元素，不能正确地取出每个数组元素的值。
			而且当再次访问第一个数组元素时，发现数组元素的值依然没有改变。
			
			不难看出，当使用 foreach 来迭代访问数组元素时，
			foreach 中的循环变量相当于一个临时变量，系统会把数组元素依次赋给这个临时变量，
			而这个临时变量并不是数组元素，它只是保存了数组元素的值。
			因此，如果希望改变数组元素的值，则不能使用这种 foreach 循环。

			
			使用 foreach 循环迭代数组元素时，并不能改变数组元素的值，
			因此不要对 foreach 的循环变量进行赋值。
		*/
	}
}
