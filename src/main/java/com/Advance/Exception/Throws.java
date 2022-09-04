package com.Advance.Exception;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// throws与声明方法抛出异常
public class Throws {
    /*
        在一个方法中如果能够处理异常，则需要捕获并处理。但是本方法没有能力处理该异常，
        捕获它没有任何意义，则需要在方法后面声明抛出该异常，通知上层调用者该方法有可以发生异常。
        方法后面声明抛出异常使用 throws关键字，方法中可能抛出的异常（除了 Error和 RuntimeException及其子类外）
        都必须通过throws语句列出，多个异常之间采用逗号（,）分隔。

        注意：如果声明抛出的多个异常类之间有父子关系，可以只声明抛出父类。
        但如果没有父子关系情况下，最好明确声明抛出每一个异常，因为上层调用者会根据这些异常信息进行相应的处理。

        假如一个方法中有可能抛出 IOException和 ParseException两个异常，
        那么声明抛出 IOException和 ParseException呢？还是只声明抛出 Exception呢？
        因为 Exception是 IOException和 ParseException的父类，
        只声明抛出Exception从语法是允许的，但是声明抛出 IOException和 ParseException更好一些。
    */
    public static void main(String[] args) {
        try {
            Date date = readDate();
            System.out.println("读取的日期 = " + date);
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        }
    }

    // 由于 FileNotFoundException属于 IOException异常，所以只声明 IOException和 ParseException就可以了。
    public static Date readDate() throws IOException, ParseException {
        // 自动资源管理
        FileInputStream readfile = new FileInputStream("readme.txt");
        InputStreamReader ir = new InputStreamReader(readfile);
        BufferedReader in = new BufferedReader(ir);

        // 读取文件中的一行数据
        String str = in.readLine();
        if (str == null) {
            return null;
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(str);
        return date;
    }
}
