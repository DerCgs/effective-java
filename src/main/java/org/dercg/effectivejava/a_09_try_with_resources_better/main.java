package org.dercg.effectivejava.a_09_try_with_resources_better;

import java.io.*;

// try-with-resource 优先于 try-finally
public class main {
    private static final int BUFFER_SIZE = 1024;

    // Java 类库中包括许多必须通过调用close方法来手动关闭的资源。如：InputStream、OptionStream、java.sql.Connection等
    // 过去 try-finally是确保资源被适时关闭的最佳方法，就算发生异常或者返回也是如此
    static String firstLineOfFile(String path) throws IOException {
        // 这种方法可以确保资源适时关闭，但是在有多个需要关闭的资源时，代码会很不好操作
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            // 如果close也发生了异常，则会覆盖readLine发生的异常，不便于问题的定位。
            // 虽然可以通过编码保留第一个异常，但是过于繁琐。TODO 通过怎样的方式可以保留第一个异常？
            br.close();
        }
    }

    // Java 7 引入了 try-with-resources 语句，解决了上述问题。
    // 如果编写了一个类，它代表的是必须别关闭的资源，则这个类应该实现 AutoCloseable
    // 在try-with-resource中，如果readLine和close都产生了异常，则后一个异常会被禁止，只保留第一个异常。
    // 被禁止的异常并不会被抛弃，而是会打印在堆栈轨迹中，并注明他们是被禁止的异常，通过调用getSuppressed方法可以访问到他们
    // ex:单个资源关闭
    static String firstLineOfFile_2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    // ex:多个资源关闭
    static void copy(String src, String dst) throws IOException {
        try (InputStream in = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte[] buf = new byte[BUFFER_SIZE];
            int n;
            while ((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    // ex:catch捕获
    static String firstLineOfFile(String path, String defaultVal) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        } catch (IOException e) {
            return defaultVal;
        }
    }

    // 在处理必须关闭的资源时，要优先考虑使用try-with-resources，而不是用try-finally
}
