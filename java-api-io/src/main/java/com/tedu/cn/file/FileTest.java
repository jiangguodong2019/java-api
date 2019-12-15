package com.tedu.cn.file;

import org.junit.Test;

import java.io.*;

public class FileTest {
    @Test
    public void m1() throws IOException {

        File f = new File("t.txt");

        //可以使用exsisits方法检测文件是否存在
        if (f.exists()) {
            System.out.println("文件存在");
        } else {
            System.out.println("文件不存在");
            boolean flag = f.createNewFile();
            System.out.println(flag ? "创建成功" : "创建失败");
        }

//        f1 = new File(f1, "c.txt");
//        if (f1.exists()) {
//            System.out.println("小溪");
//        } else {
//            System.out.println("文件不存在");
//
//        }
    }

    /**
     * 相对路径（
     * 从自己本身的路径出发，找到目标文件的路径
     * 绝对路径：从根路径出发，找到目标文件的路径
     * linux系统上面用/表示根目录
     * CD(change directory)改变目录
     * 注意：在表示路径的时候一定不要将其写死
     */
    @Test
    public void m2() {
        File f = new File("E:\\t.txt");
        /**
         * isFile方法表示一个抽象路径是文件还是目录（文件夹）
         * 如果是文件，返回True，反之
         */
        System.out.println(f.isFile());
    }

    @Test
    public void m3() {
        /**
         * 使用*.length()API
         * 文件的长度 英文字母各占一个字节
         */
        File f = new File("t.txt");
        System.out.println(f.length());
    }

    @Test
    public void m4() {
        File f = new File("t.txt");
        if (f.exists()) {
            f.delete();
            System.out.println("ok");
        }
    }

    @Test
    public void m5() {
        File f = new File("fs/ns1/ns2");
        if (!f.exists()) {
            System.out.println(f.mkdirs());
        }
    }

    @Test
    public void m6() {
        File f = new File("z.txt");
        if (f.exists()) {
            //重新命名d
            f.renameTo(new File("d.txt"));

        }
        System.out.println(f.lastModified());
        System.out.println(f.getName());
    }

    @Test
    public void m7() {
        File f = new File("fs"
                + File.separator + "ns1"
                + File.separator + "ns2");
        //表示fs1/ns1/ns2
        {
            System.out.println(f.getAbsoluteFile().getName());
            System.out.println(f.getAbsolutePath());

        }
    }

    @Test
    public void m8() {
        /**
         * 测试列出某一个目录
         */
        File f = new File("D:\\院团委文件");
        if (f.exists()) {
            File[] fs = f.listFiles(new FileFilter() {
                public boolean accept(File pathname) {
                    return pathname.getName().contains(".txt") || pathname.getName().contains(".doc") ||
                            pathname.getName().contains(".xlsx");
                    //File[] fs=
                }
            });
            for (int i = 0; i < fs.length; i++) {
                System.out.println(fs[i].getName());
                System.out.println(f.getAbsolutePath());
                System.out.println("这是测试");
            }
        }
    }

    @Test
    public void m9() {
        File f = new File("fs");
        if (f.exists()) {
            System.out.println(f.delete());
        }
    }

    //递归注意边界问题
    static int i = 0;

    public static boolean reversDel(File file) {
        if (file.isDirectory()) {
            File[] fs = file.listFiles();
            for (int i = 0; i < fs.length; i++) ;
            {
                reversDel(fs[i]);
            }
            file.delete();
        }
        return true;
    }

    @Test
    public void m10() throws IOException {
        File f = new File("z1.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        byte[] bs = new byte[6];
        System.out.println("当前指针的位置：" + raf.getFilePointer());
        int i = raf.read(bs);
        System.out.println(i);
        System.out.println(new String(bs));
        System.out.println("当前指针的位置：" + raf.getFilePointer());
        raf.seek(Long.parseLong("0"));
        i = raf.read(bs);
        System.out.println(i);
        System.out.println("当前指针的位置：" + raf.getFilePointer());
        System.out.println("重置指针");
        System.out.println(new String(bs));

        //拿到一个字符
        String first_line = raf.readLine();
        //System.out.println(first_line);不能读汉字
        System.out.println(new String(first_line.getBytes("iso8859-1"), "utf-8"));
        raf.close();

    }

    @Test
    public void m12() throws IOException {
        File f = new File("d.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        byte[] bs = new byte[1024];
        int len = 0;
        String str = "";
        while ((len = raf.read(bs)) != -1) {
            str += new String(bs);
        }
        System.out.println(str);
        System.out.println("读取完毕");
        raf.close();
    }
@Test
    public void m13() throws IOException {
        File f = new File("d.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        //重置指针
        raf.seek(raf.length());
        //raf.write("\n".getBytes());
        raf.write("小海".getBytes());
        raf.write("sc kd".getBytes());
        raf.close();
    }
    /**
     * 测试raf实现文件拷贝（图片）
     */
    @Test
    public void m14() throws IOException {
        File f = new File("1.jpg");
        RandomAccessFile raf1 = new RandomAccessFile(f, "rw");
        File f2 = new File("2.jpg");
        if (!f2.exists()) {
            System.out.println(f2.createNewFile());
        }
        RandomAccessFile raf2 = new RandomAccessFile(f2, "rw");
        //实现拷贝
        byte[] bs = new byte[1024];
        long len = 0;
        while ((len = raf1.read(bs))!= -1) {
            raf2.write(bs);
        }
        raf1.close();
        raf2.close();
    }
}


