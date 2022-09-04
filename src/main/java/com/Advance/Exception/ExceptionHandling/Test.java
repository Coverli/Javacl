package com.Advance.Exception.ExceptionHandling;

public class Test {
    public static void main (String[] args) throws Exception {
        int i = 0;
        String greetings [] = {
                "Cover",
                "Miru"
        };

        while ( i < 3 ) {
            try {
                System.out.println (greetings [i]);
            } catch ( Exception e ) {
                // Exception类型
                String e1 = e.toString().substring( 0, e.toString().indexOf(":") );
                // CSDN站点搜索
                String csdn = "https://so.csdn.net/so/search?q=java%20";
                // Stack Overflow站点搜索
                String stackoverflow = "http://stackoverflow.com/search?q=[java] + ";

                // 将Exception与CSDN和Stack Overflow搜索链接拼接成url字符串
                String url_csdn = csdn.concat( e1 );
                String url_stackoverflow = stackoverflow.concat( e1 );

                System.out.println ( e.toString() );
                new BrowserLaunch().openBrowser( url_csdn );
                new BrowserLaunch().openBrowser( url_stackoverflow );
            }
            i++;
        }
    }
}
