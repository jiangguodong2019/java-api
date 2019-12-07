package com.tedu.cn.file;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    @Test
    public void m1() throws IOException {


        File f =new File("t.txt");
        //可以使用exsisits方法检测文件是否存在
if (f.exists()){
    System.out.println("文件存在");
}else {
    System.out.println("文件不存在");
    boolean flag =f.createNewFile();
    System.out.println(flag?"创建成功":"创建失败");
}
    }
}
