import java.util.ArrayList;
import java.util.List;

/**
 * Created by huayu on 2019/10/14.
 */
public class TestDemo {
    private static Integer i = 100;
    public static void main(String[] args) {
        List list  = new ArrayList();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(0,1);
        list.add(0,10);
        list.forEach(i-> System.out.println(i));







//        TestDemo testDemo = new TestDemo();
//        testDemo.i++;
//        TestDemo testDemo1 = new TestDemo();
//        testDemo1.i++;
//        testDemo = new TestDemo();
//        testDemo.i++;
//        TestDemo.i--;
//        System.out.println(i);
//
//
//        Integer.valueOf(1);
//
//
//
//
//
//
//
//        int count= 0;
//        int num =0;
//        for (int i = 0;i<=100;i++){
//            num=num+i;
//            count++;
//            System.out.println(count);
//        }
//        System.out.println("num*count"+(num*count));
    }
}
