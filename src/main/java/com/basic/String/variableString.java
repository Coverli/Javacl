package com.basic.String;

public class variableString {
	public static void main (String args[]) {
		variableString vs = new variableString();
		vs.difference();
		vs.additional();
		vs.insertDeleteUpdate();
	}

	// StringBuffer和StringBuilder的区别
	void difference () {
		/*
			Java提供了两个可变字符串类StringBuffer和StringBuilder，中文翻译为“字符串缓冲区”。
			StringBuffer是线程安全的，它的方法是支持线程同步 ，线程同步会操作串行顺序执行，在单线程环境下会影响效率。
			StringBuilder是StringBuffer单线程版本，它不是线程安全的，但它的执行效率很高。
			
			线程同步是一个多线程概念，就是当多个线程访问一个方法时，
			只能由一个优先级别高的线程先访问，在访问期间会锁定该方法，其他线程只能等到它访问完成释放锁，才能访问。

			StringBuffer和StringBuilder具有完全相同的API，即构造方法和普通方法等内容一样。StringBuilder的中
			构造方法有4个：
			StringBuilder()：创建字符串内容是空的StringBuilder对象，初始容量默认为16个字符。
			StringBuilder(CharSequence seq)：指定CharSequence字符串创建StringBuilder对象。CharSequence接口类型，它的实现类有：String、StringBuffer和StringBuilder等，所以参数seq可以是String、StringBuffer和StringBuilder等类型。
			StringBuilder(int capacity)：创建字符串内容是空的StringBuilder对象，初始容量由参数capacity指定的。
			StringBuilder(String str)：指定String字符串创建StringBuilder对象。

			上述构造方法同样适合于StringBuffer类，这里不再赘述。
		*/

		/*
			字符串长度和字符串缓冲区容量区别。
			字符串长度是指在字符串缓冲区中目前所包含字符串长度，通过length()获得；
			字符串缓冲区容量是缓冲区中所能容纳的最大字符数，通过capacity()获得。当所容纳的字符超过这个长度时，字符串缓冲区自动扩充容量，但这是以牺牲性能为代价的扩容。
		*/

		// 字符串长度length和字符串缓冲区容量capacity
		StringBuilder sbuilder1 = new StringBuilder();
		System.out.println("包含的字符串长度：" + sbuilder1.length());
		System.out.println("字符串缓冲区容量：" + sbuilder1.capacity());
		StringBuilder sbuilder2 = new StringBuilder("Hello");
		System.out.println("包含的字符串长度：" + sbuilder2.length());
		System.out.println("字符串缓冲区容量：" + sbuilder2.capacity());
		// 字符串缓冲区初始容量是16，超过之后会扩容
		StringBuilder sbuilder3 = new StringBuilder();
		for (int i = 0; i < 17; i++) {
			sbuilder3.append(8);
		}
		System.out.println("包含的字符串长度：" + sbuilder3.length());
		System.out.println("字符串缓冲区容量：" + sbuilder3.capacity());
	}

	// 字符串追加
	void additional () {
		/*
			字符串追加方法是append，append有很多重载方法，
			可以追加任何类型数据，它的返回值还是StringBuilder。
			StringBuilder的追加法与StringBuffer完全一样。
		*/

		// 添加字符串、字符
		StringBuilder sbuilder1 = new StringBuilder("Hello");
		// 由于所有的append方法都返回StringBuilder对象，所有可以连续调用该方法，
		sbuilder1.append(" ").append("World");
		sbuilder1.append('.');
		System.out.println(sbuilder1);
		StringBuilder sbuilder2 = new StringBuilder();
		Object obj = null;
		// 添加布尔值、转义符和空对象
		// 布尔值false会转换为false字符串，空对象null也会转换为"null"字符串。
		sbuilder2.append(false).append('\t').append(obj);
		System.out.println(sbuilder2);
		// 添加数值
		StringBuilder sbuilder3 = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			sbuilder3.append(i);
		}
		System.out.println(sbuilder3);
	}

	// 插入、删除和替换
	void insertDeleteUpdate () {
		/*
			StringBuilder中实现插入、删除和替换等操作的常用方法说明如下：
			StringBuilder insert(int offset, String str)：
			在字符串缓冲区中索引为offset的字符位置之前插入str，insert有很多重载方法，可以插入任何类型数据。

			StringBuffer delete(int start, int end)：
			在字符串缓冲区中删除子字符串，要删除的子字符串从指定索引start开始直到索引end-1处的字符。start和end两个参数与substring(int beginIndex, int endIndex)方法中的两个参数含义一样。

			StringBuffer replace(int start, int end, String str)：
			字符串缓冲区中用str替换子字符串，子字符串从指定索引start开始直到索引end - 1处的字符。start和end同delete(int start, int end)方法。
			
			以上介绍的方法虽然是StringBuilder方法，但StringBuffer也完全一样。
		*/

		// 原始不可变字符串
		String str1 = "Java C";
		// 从不可变的字符创建可变字符串对象
		StringBuilder mstr = new StringBuilder(str1);
		// 插入字符串
		mstr.insert(4, " C++");
		System.out.println(mstr);
		// 具有追加效果的插入字符串
		mstr.insert(mstr.length(), " Objective-C");
		System.out.println(mstr);
		// 追加字符串
		mstr.append(" and Swift");
		System.out.println(mstr);
		// 删除字符串
		mstr.delete(11, 23);
		System.out.println(mstr);
	}
}