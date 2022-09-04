package com.Advance.Exception.ReleaseResource;

/*
    有时在try-catch语句中会占用一些非Java资源，如：打开文件、网络连接、打开数据库连接和使用数据结果集等，
    这些资源并非Java资源，不能通过JVM的垃圾收集器回收，需要程序员释放。
    为了确保这些资源能够被释放可以使用finally代码块
    或Java 7之后提供自动资源管理（Automatic ResourceManagement）技术。
*/

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

// finally代码块
public class Finally {
    // try-catch语句后面还可以跟有一个finally代码块，如：try-catch-finally语句
    // 无论 try正常结束还是 catch异常结束都会执行 finally代码块
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
            // 读取文件中的一行数据
            String str = in.readLine();
            if (str == null) {
                return null;
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            Date date = df.parse(str);
            return date;
        } catch (FileNotFoundException e) {
            System.out.println("处理FileNotFoundException...");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("处理IOException...");
            e.printStackTrace();
        } catch (ParseException e) {
            System.out.println("处理ParseException...");
            e.printStackTrace();
        } finally {
            // FileInputStream、InputStreamReader和BufferedReader是三个输入流，它们都需要关闭，
            // 通过流的close()关闭流，但是流的close()方法还有可以能发生IOException异常，
            // 所以这里又针对每一个close()语句还需要进行捕获处理。
            try {
                if (readfile != null) {
                    readfile.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ir != null) {
                    ir.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*
                注意：为了代码简洁等目的，可能有的人会将finally代码中的多个嵌套的try-catch语句合并，
                例如将上述代码改成如下形式，将三个有可以发生异常的close()方法放到一个try-catch。
                finally {
                    try {
                        if (readfile != null) {
                            readfile.close();
                        }
                        if (ir != null) {
                            ir.close();
                        }
                        if (in != null) {
                            in.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                请考虑一下这处理是否稳妥呢？
                每一个close()方法对应关闭一个资源，如果第一个close()方法关闭时发生了异常，
                那么后面的两个也不会关闭，因此以上的程序代码是有缺陷的。
            */
        }
        return null;
    }
}
