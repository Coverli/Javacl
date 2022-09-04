package com.Advance.Exception.tryCatch;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// try-catch语句嵌套
public class nestTryCatch {
    /*
        Java提供的try-catch语句嵌套是可以任意嵌套
        程序执行时内层如果会发生异常，首先由内层catch进行捕获，如果捕获不到，则由外层catch捕获。
        例如：readLine()方法可能发生IOException异常，该异常无法被内层catch捕获，最后被外层catch捕获。

        注意：try-catch不仅可以嵌套在try代码块中，还可以嵌套在catch代码块或finally代码块。
            try-catch嵌套会使程序流程变的复杂，如果能用多catch捕获的异常，尽量不要使用try-catch嵌套。
            要梳理好程序的流程再考虑try-catch嵌套的必要性
    */
    public static void main(String[] args) {
        Date date = readDate();
        System.out.println("读取的日期 = " + date);
    }
    public static Date readDate() {
        FileInputStream readfile = null;
        InputStreamReader ir = null;
        BufferedReader in = null;
        try {
            readfile = new FileInputStream("readme.txt");
            ir = new InputStreamReader(readfile);
            in = new BufferedReader(ir);
            try {
                String str = in.readLine();
                if (str == null) {
                    return null;
                }
                DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                Date date = df.parse(str);
                return date;
            } catch (ParseException e) {
                System.out.println("处理ParseException...");
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        }
        return null;
    }
}
