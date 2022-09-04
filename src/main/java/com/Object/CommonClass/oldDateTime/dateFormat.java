package com.Object.CommonClass.oldDateTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// 日期格式化和解析
public class dateFormat {
    /*
        日期格式化类是java.text.DateFormat，DateFormat是抽象类，它的常用具体类是java.text.SimpleDateFormat。
        DateFormat中提供日期格式化和日期解析方法，具体方法说明如下：
            String format(Date date)：将一个Date格式化为日期/时间字符串。
            Date parse(String source)：从给定字符串的开始解析文本，以生成一个日期对象。如果解析失败则抛出ParseException。
        另外，具体类是SimpleDateFormat构造方法如下：
            SimpleDateFormat()：用默认的模式和默认语言环境的日期格式符号构造SimpleDateFormat。
            SimpleDateFormat(String pattern)：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。
                pattern参数是日期和时间格式模式，如下所示是常用的日期和时间格式模式
            字母      日期或者时间元素
            y           年
            M           年中的月份
            D           年中的天数
            d           月份中的天数
            H           一天中的小时数（0-23）
            h           AM/PM中的小时数（1-12）
            a           AM/PM标记
            m           小时中的分钟数
            s           分钟中的秒数
            Z           时区
    */

    // 并不是所有的字符串都能够转换为日期，如果转换失败parse方法会抛出异常ParseException。
    // 由于ParseException异常是受检查类型异常，这种异常必须处理，
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        System.out.println("格式化前date = " + date);

        // 用默认格式输出日期
        DateFormat df = new SimpleDateFormat();
        System.out.println("格式化后date = " + df.format(date));
        // 指定格式输出日期
        df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 重新创建 SimpleDateFormat对象
        System.out.println("格式化后date = " + df.format(date));

        // 字符串转换为日期
        String dateString = "2018-08-18 08:18:58";
        Date date1 = df.parse(dateString);
        System.out.println("从字符串获得日期对象 = " + date1);
    }
}
