package xunlian1;

public class Puppy {
    public Puppy(String name ){
        //这份构造器只有一份参数：name
        System.out.println("小狗狗的名字是 : "+name);
    }
    public static void main(String[] args){
        //下面的语句将会创建一个Puppy对象
        Puppy myPuppy = new Puppy("tony");
    }
}
