package com.scs.web.blog.util;

import java.io.*;

/**
 * 文件复制
 */
public class FileCopy {
    public static void main(String[] args) {
        //1.指定源文件
        File file = new File("D:/web.jpg");
        //2.通过源文件得到字节输入流
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //3.将源文件通过输入流写入内存字节数组,数组长度和文件长度等长
        byte[] b = new byte[(int) file.length()];
        try {
            inputStream.read(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.指定目标文件
        file = new File("D:/code.jpg");
        //5.通过目标文件得到输出流
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //6.将字节数组b童输出流写入目标文件
        try {
            outputStream.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //关闭流
        try {
            outputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
