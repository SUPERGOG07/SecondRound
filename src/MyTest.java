import animal_shop.Cat;
import animal_shop.ChineseGardenDog;
import animal_shop.Customer;
import animal_shop.MyAnimalShop;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyTest {

    public static void main(String[] args) {
//        myAnimalShopTest();
//        myThread();
//        regexTest();
    }

    static void myAnimalShopTest(){
        MyAnimalShop meow = new MyAnimalShop();

        ChineseGardenDog dog1 = new ChineseGardenDog("大黄",3,1,true);
        ChineseGardenDog dog2 = new ChineseGardenDog("小黄",1,2,true);
        Cat cat1 = new Cat("喵喵",2,2);
        Cat cat2 = new Cat("meow_meow",4,1);

        meow.buyNewAnimal(dog1);
        meow.buyNewAnimal(cat1);
        meow.buyNewAnimal(cat2);

        Customer customer1 = new Customer("西西");
        Customer customer2 = new Customer("二二");

        meow.entertainCustomers(customer1);

        meow.open();

        meow.entertainCustomers(customer1);

        meow.entertainCustomers(customer2);

        meow.close();
    }

    static void myThread(){
        int[] number1 ={1,3,5,7,9};
        int[] number2 = {2,4,6,8,10};
        final Object obj = new Object();

        new Thread(()->{
            synchronized (obj){         //锁住本线程,阻塞其他线程
                for (int num:number1){
                    System.out.println(num);
                    try{
                        obj.notify();   //叫醒其他线程
                        obj.wait();     //阻塞本线程，让出锁
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                obj.notify();   //任务结束叫醒其他进程
            }
        }).start();

        new Thread(()->{
            synchronized (obj){
                for (int num:number2){
                    System.out.println(num);
                    try{
                        obj.notify();
                        obj.wait();
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
                obj.notify();
            }
        }).start();
    }

    static boolean regex(String email){

        String rule = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
        Pattern pattern = Pattern.compile(rule);

        return pattern.matcher(email).matches();
    }

    static void regexTest(){
        String email1 = "114514west2@qq.com";
        System.out.println(regex(email1));
        String email2 = "1000111@fzu.edu.cn";
        System.out.println(regex(email2));
        String email3 = "baidu.com";
        System.out.println(regex(email3));
        String email4 = "";
        System.out.println(regex(email4));
        String email5 = "@qq.com";
        System.out.println(regex(email5));
        String email6 = "454444";
        System.out.println(regex(email6));

    }
}
