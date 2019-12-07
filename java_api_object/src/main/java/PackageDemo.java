import org.junit.Test;

import java.io.*;


public class PackageDemo{
        @Test
         public void m1(){

            Integer b=0;
            System.out.println(Integer.MAX_VALUE);
            byte b0=1;
            Byte b1 =new Byte(b0);
            System.out.println(b1);
            System.out.println(Byte.MAX_VALUE);
            Integer i=1;
            System.out.println(Integer.toOctalString(25));
            int b2=1;
            Integer c=b2;
            int d=c;
         }
        /**
         * java异常体系
         * 异常：程序不正常的退出
         * 所有异常的父类是throwable
         * java语言的异常分为两种；
         * 1）Error
         * 硬件故障,比如内存空间的不足，磁盘损坏等。
         *2）Exception
         * --编译异常
         * --运行异常
         * 运行异常时会打印异常信息，运行时异常的父类是RuntimeException,该异常不需要显示异常
         * Java程序错误
         *测试Exception异常
         * 出现异常出现的两种方式
         * 1）通过thorws 显示抛出 抛给方法的调用者
         *2） 通过try catch语句
         * 进行显示的捕获
         */
        @Test
        public void m2(){
            try {
                min();
            } catch (FileNotFoundException e) {
                System.out.println("私下解决");
            }

        }
        public static void min() throws FileNotFoundException {
            InputStream inputStream = new FileInputStream("zz.yxt");
        }
        @Test
        public  void m3(){
            zk();
        }

        public static void zk(){
            try{
                File f =new File("zewqrfqwer.txt");
//                if (!f.exists()){
//                    try {
//                        f.createNewFile();
//                    } catch (IOException e) {
//                        System.out.println("输入输出异常");
//                    }
//                }
                InputStream inputStream = new FileInputStream(f);
                System.out.println(1/0);
                System.out.println("z2.txt");
                String str =null;
                System.out.println(str.lastIndexOf("c"));
            }catch (ArithmeticException f1){
                System.out.println("除数不能为零");
            }catch (NullPointerException f2){
                System.out.println("出现空指针异常");
            }catch (FileNotFoundException f3){
                System.out.println("文件未找到");
                try {
                    f3.printStackTrace(new PrintStream("z.txt"));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
            catch (IOException f4){
                System.out.println("输入输出流异常");
            }

            }
            @Test
            public  void m6(){
                try {
                    autoEX();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            public static void autoEX() throws Exception {
            Exception e =new Exception("我创建的异常");
            throw e;
            }
            public static void mmml(){
            RuntimeException r = new RuntimeException("运行时异常");
                throw r;
            }
            @Test
            public  void m8(){
            String pwd="225";
            if (pwd.length()<8){
                throw new PasswordException(2,"密码安全系数低");
            }
            if (pwd.matches("\\d{4,8}&&\\w{4,8}")){
                throw new PasswordException(1,"密码不匹配");
            }
            if (!pwd.equals("asd1dsa")){
                throw new PasswordException("密码错误");
            }
            }



    }

