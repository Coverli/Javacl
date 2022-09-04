package com.basic.String;

public class immutableString {
	public static void main (String args[]) {
		immutableString is = new immutableString();
		is.createObject();
		is.pools();
		is.splicing();
		is.find();
		is.compare();
		is.intercept();
	}
	
	// 创建String对象
	void createObject () {
		/*
			Java中不可变字符串类是String，属于java.lang包，它也是Java非常重要的类
			java.lang包中提供了很多Java基础类，包括Object、Class、String和Math等基本类
			在使用 java.lang包中的类时不需要引入（import）该包，因为它是由解释器自动引入的
			当然引入 java.lang包程序也不会有编译错误	
		*/
		
		/*
			创建String对象可以通过构造方法实现，常用的构造方法：
			String()：使用空字符串创建并初始化一个新的String对象。
			String(String original)：使用另外一个字符串创建并初始化一个新的 String 对象。
			String(StringBuffer buffer)：使用可变字符串对象（StringBuffer）创建并初始化一个新的 String 对象。
			String(StringBuilder builder)：使用可变字符串对象（StringBuilder）创建并初始化一个新的 String 对象。
			String(byte[] bytes)：使用平台的默认字符集解码指定的byte数组，通过byte数组创建并初始化一个新的 String 对象。
			String(char[] value)：通过字符数组创建并初始化一个新的 String 对象。
			String(char[] value, int offset, int count)：通过字符数组的子数组创建并初始化一个新的 String 对象;offset参数是子数组第一个字符的索引，count参数指定子数组的长度。
		*/
		
		// 创建字符串对象
		String s1 = new String();
		String s2 = new String("Hello World");
		String s3 = new String("\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064");
		System.out.println("s1 = " + s1);
		System.out.println("s2 = " + s2);
		System.out.println("s3 = " + s3);
		
		char chars[] = { 'a', 'b', 'c', 'd', 'e' }; 
		// 通过字符数组创建字符串对象
		String s4 = new String(chars);
		// 通过子字符数组创建字符串对象
		String s5 = new String(chars, 1, 4);
		System.out.println("s4 = " + s4);
		System.out.println("s5 = " + s5);
		
		byte bytes[] = { 97, 98, 99 };
		// 通过byte数组创建字符串对象
		String s6 = new String(bytes);
		System.out.println("s6 = " + s6);
		System.out.println("s6字符串长度 = " + s6.length());
		String s7 = new String(bytes, 1, 1);
		// 通过指定byte数组索引和长度创建字符串对象
		System.out.println("s7 = " + s7);
		System.out.println("s7字符串长度 = " + s7.length());
		System.out.println();
	}
	
	// 字符串池
	void pools () {
		// 字符串和字符串对象的区别
		String a = "abc";
		String b = new String("abc");
		String c = new String("abc");
		String d= a;
		System.out.println( a == b ); // false
		System.out.println( a == d ); // true
		System.out.println( b == c); // false
		System.out.println( a.equals(b) ); // frue
		System.out.println();
		/* 
			==对比的是内存池的分配地址
			.equals()对比是字符串内容
			
			在编码时推荐使用字符串而非字符串对象
		*/
	}
	
	// 字符串拼接
	void splicing () {
		/*
			String字符串虽然是不可变字符串，但也可以进行拼接只是会产生一个新的对象。
			String字符串拼接可以使用+运算符，+=运算符或String的concat(String str)方法。
			+运算符优势是可以连接任何类型数据拼接成为字符串，
			而concat方法只能拼接String类型字符串。
		*/
		String s1 = "Hello";
		// 使用+运算符连接
		String s2 = s1 + " ";
		String s3 = s2 + "World";
		System.out.println(s3);
		String s4 = "Hello";
		
		// 使用+运算符连接，支持+=赋值运算符
		s4 += " ";
		s4 += "World";
		System.out.println(s4);
		String s5 = "Hello";
		
		// 使用concat方法连接
		s5 = s5.concat(" ").concat("World");
		System.out.println(s5);
		// concat方法的完整定义：public String concat ( String str )
		// 它的参数和返回值都是String，因此可以连续调用该方法进行多个字符串的拼接。
		
		int age = 18;
		String s6= "她的年龄是" + age + "岁。";
		System.out.println(s6);
		
		char score = 'A';
		String s7= "她的英语成绩是" + score;
		System.out.println(s7);
		
		java.util.Date now = new java.util.Date();
		//对象拼接自动调用toString()方法
		String s8= "今天是：" + now;
		System.out.println(s8);
		// Java中所有对象都有一个toString()方法，该方法可以将对象转换为字符串，
		// 拼接过程会调用该对象的toString()方法，将该对象转换为字符串后再进行拼接。
		System.out.println();
	}
	
	// 字符串查找
	void find () {
		/*
			在String类中提供了indexOf和lastIndexOf方法用于查找字符或字符串，
			返回值是查找的字符或字符串所在的位置，-1表示没有找到。
			这两个方法有多个重载版本：
			
			int indexOf(int ch)：从前往后搜索字符ch，返回第一次找到字符ch所在处的索引。
			int indexOf(int ch, int fromIndex)：从指定的索引开始从前往后搜索字符ch，返回第一次找到字符ch所在处的索引。
			int indexOf(String str)：从前往后搜索字符串str，返回第一次找到字符串所在处的索引。
			int indexOf(String str, int fromIndex)：从指定的索引开始从前往后搜索字符串str，返回第一次找到字符串所在处的索引。
			int lastIndexOf(int ch)：从后往前搜索字符ch，返回第一次找到字符ch所在处的索引。
			int lastIndexOf(int ch, int fromIndex)：从指定的索引开始从后往前搜索字符ch，返回第一次找到字符ch所在处的索引。
			int lastIndexOf(String str)：从后往前搜索字符串str，返回第一次找到字符串所在处的索引。
			int lastIndexOf(String str, int fromIndex)：从指定的索引开始从后往前搜索字符串str，返回第一次找到字符串所在处的索引。
			提示：字符串本质上是字符数组，因此它也有索引，索引从零开始。
			String的charAt(int index)方法可以返回索引index所在位置的字符。
		*/
		
		String sourceStr = "There is a string accessing example.";
		
		//获得字符串长度
		int len = sourceStr.length();
		//获得索引位置16的字符
		char ch = sourceStr.charAt(16);
		
		//查找字符和子字符串
		int firstChar1 = sourceStr.indexOf('r');
		int lastChar1 = sourceStr.lastIndexOf('r');
		int firstStr1 = sourceStr.indexOf("ing");
		int lastStr1 = sourceStr.lastIndexOf("ing");
		int firstChar2 = sourceStr.indexOf('e', 15);
		int lastChar2 = sourceStr.lastIndexOf('e', 15);
		int firstStr2 = sourceStr.indexOf("ing", 5); 
		int lastStr2 = sourceStr.lastIndexOf("ing", 5);
		
		System.out.println("原始字符串:" + sourceStr);
		System.out.println("字符串长度:" + len);
		System.out.println("索引16的字符:" + ch);
		System.out.println("从前往后搜索r字符，第一次找到它所在索引:" + firstChar1);
		System.out.println("从后往前搜索r字符，第一次找到它所在索引:" + lastChar1);
		System.out.println("从前往后搜索ing字符串，第一次找到它所在索引:" + firstStr1);
		System.out.println("从后往前搜索ing字符串，第一次找到它所在索引:" + lastStr1);
		System.out.println("从索引为15位置开始，从前往后搜索e字符，第一次找到它所在索引:" + firstChar2);
		System.out.println("从索引为15位置开始，从后往前搜索e字符，第一次找到它所在索引:" + lastChar2);
		System.out.println("从索引为5位置开始，从前往后搜索ing字符串，第一次找到它所在索引:" + firstStr2);
		System.out.println("从索引为5位置开始，从后往前搜索ing字符串，第一次找到它所在索引:" + lastStr2);
		System.out.println();
	}
	
	// 字符串比较
	void compare () {
		/*
			比较相等：
				boolean equals(Object anObject)：比较两个字符串中内容是否相等。
				boolean equalsIgnoreCase(String anotherString)：类似equals方法，只是忽略大小写。
		*/
		/*
			比较大小：
				int compareTo(String anotherString)：按字典顺序比较两个字符串。如果参数字符串等于此字符串，则返回值0；如果此字符串小于字符串参数，则返回一个小于0的值；如果此字 符串大于字符串参数，则返回一个大于 0 的值。
				int compareToIgnoreCase(String str)：类似compareTo，只是忽略大小写。
		*/
		/*
			比较前缀和后缀
				boolean endsWith(String suffix)：测试此字符串是否以指定的后缀结束。
				boolean startsWith(String prefix)：测试此字符串是否以指定的前缀开始。
		*/
		
		String s1 = new String("Hello");
		String s2 = new String("Hello");
		// 比较字符串是否是相同的引用
		System.out.println("s1 == s2 : " + (s1 == s2));
		// 比较字符串内容是否相等
		System.out.println("s1.equals(s2) : " + (s1.equals(s2)));
		
		String s3 = "HELlo";
		// 忽略大小写比较字符串内容是否相等
		System.out.println("s1.equalsIgnoreCase(s3) : " + (s1.equalsIgnoreCase(s3)));
		
		// 比较大小
		String s4 = "java";
		String s5 = "Swift";
		// 比较字符串大小 s4 > s5
		System.out.println("s4.compareTo(s5) : " + (s4.compareTo(s5)));
		// 忽略大小写比较字符串大小 s4 < s5
		System.out.println("s4.compareToIgnoreCase(s5) : " + (s4.compareToIgnoreCase(s5)));
		/*
			compareTo方法按字典顺序比较两个字符串，
			s4.compareTo(s5)表达式返回结果大于0，说明s4大于s5，
			字符在字典中顺序事实上就它的Unicode编码，
			先比较两个字符串的第一个字符j和 S，j的Unicode编码是106，S的Unicode编码是83，所以可以得出结论s4 > s5。
			
			忽略大小写比较字符串时，要么全部当成小写字母进行比较，要么当前成全部大写字母进行比较，无论哪种比较结果都是一样的s4 < s5。
		*/
		
		// 判断文件夹中文件名
		String[] docFolder = { "java.docx", " JavaBean.docx", "Objecitve-C.xlsx", "Swift.docx " };
		int wordDocCount = 0;
		// 查找文件夹中Word文档个数
		for (String doc : docFolder) {
			// 去的前后空格
			doc = doc.trim();
			// 比较后缀是否有.docx字符串
			if (doc.endsWith(".docx")) {
				wordDocCount++;
			}
		}
		System.out.println("文件夹中Word文档个数是： " + wordDocCount);
		
		int javaDocCount = 0;
		// 查找文件夹中Java相关文档个数
		for (String doc : docFolder) {
			// 去的前后空格
			doc = doc.trim();
			// 全部字符转成小写
			doc = doc.toLowerCase();
			// 比较前缀是否有java字符串
			if (doc.startsWith("java")) {
				javaDocCount++;
			}
		}
		System.out.println("文件夹中Java相关文档个数是：" + javaDocCount);
		System.out.println();
		/*
			trim()方法可以去除字符串前后空白
			toLowerCase()方法可以将此字符串全部转化为小写字符串
		*/
	}
	
	// 字符串截取
	void intercept () {
		/*
			String substring(int beginIndex)：从指定索引beginIndex开始截取一直到字符串结束的子字符串。
			String substring(int beginIndex, int endIndex)：从指定索引beginIndex开始截取直到索引endIndex 1处的字符，注意包括索引为beginIndex处的字符，但不包括索引为endIndex处的字符。
		*/
		
		String sourceStr = "There is a string accessing example.";
		// 截取example.子字符串
		String subStr1 = sourceStr.substring(28);
		// 截取string子字符串
		String subStr2 = sourceStr.substring(11, 17);
		System.out.printf("subStr1 = %s%n", subStr1);
		System.out.printf("subStr2 = %s%n",subStr2);
		
		// 使用split方法分割字符串
		System.out.println("-----使用split方法-----");
		String[] array = sourceStr.split(" ");
		for (String str : array) {
			System.out.println(str);
		}
		// String还提供了字符串分割方法，参数是分割字符串，根据参数将sourceStr分割成多个字符串数组，返回值 String[]。
		System.out.println();
	}

	// 案例：字符串反转
	void rollbackString () {
		String str0 = "9876543210";
		String str1 = "";
		for ( int i = 0; i < str0.length(); i++) {
			str1 += str0.charAt(str0.length()-i-1);
		}

		System.out.println("字符串反转前：" + str0);
		System.out.println("字符串反转后：" + str1);
	}
}
