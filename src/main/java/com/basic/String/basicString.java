package com.basic.String;

public class basicString {
	public static void main (String args[]) {
		basicString bs = new basicString();
		bs.format();
	}
	
	// 字符串基础与格式
	void format () {
		/*
			Java中的字符采用Unicode编码，
			所以Java字符串可以包含中文等亚洲字符，见字符串c"世界你好"。
			字符串b是用Unicode编码表示的字符串，事实上它表示的也是"Hello World"字符串，可通过System.out.print方法将Unicode编码表示的字符串输出到控制台，则会看到Hello World字符串。
			另外，单个字符如果用双引号括起来，那它表示的是字符串，而不是字符了，见字符串d"A"是字符串A，而不是字符A。

			注意：字符串还有一个极端情况，就字符串e""表示空字符串，双引号中没有任何内容，空字符串不是null，空字符串是分配内存空间，而null是没有分配内存空间。
			
			Java SE提供了三个字符串类：String、StringBuffer和StringBuilder。
			String是不可变字符串
			StringBuffer和StringBuilder是可变字符串
			它们区别在于当字符串进行拼接等修改操作时，
			不可变字符串会创建新的字符串对象，
			而可变字符串不会创建新对象。
		*/
		String a = "Hello World";
		String b = "\u0048\u0065\u006c\u006c\u006f\u0020\u0057\u006f\u0072\u006c\u0064";
		String c = "世界你好";
		String d = "A";
		String e = "";
		
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		System.out.println(e);
	}
}
