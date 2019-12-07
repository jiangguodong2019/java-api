import org.junit.Test;

import java.util.Scanner;

public class StringMatchDemo {
    @Test
    public void m1(){
        String regex="[a-z]";
        System.out.println("a".matches(regex));
        regex="[a-zA-Z0-9]";
        System.out.println("0".matches(regex));
        regex="[^a-zA-Z0-9]";
        System.out.println("q".matches(regex));
        regex="[a-z&&[^bc]]";
        System.out.println("a".matches(regex));
    }
    @Test
    public void m2(){
        String reg="\\d";
        System.out.println("9".matches(reg));
        reg ="\\d+";
        System.out.println("999".matches(reg));
        reg ="\\d*";
        System.out.println("54564".matches(reg));
        System.out.println("--------------info-----------------");
        reg ="\\w+";
        System.out.println("65cddsf".matches(reg));
        reg ="\\w*";
        System.out.println("646a".matches(reg));
    }
    @Test
    public void m3(){
        String regex="(\\+86)?\\s?\\d{11}";
        String phone="18798467793";
       // Scanner scanner= new Scanner(System.in);
       // System.out.println("请输入电话号码");
        if(phone.matches(regex)){
            System.out.println("手机号合法");
        }else {
            System.out.println("手机号不合法");
        }
    }
    //scanner.close()
}
