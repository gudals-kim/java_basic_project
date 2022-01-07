package ch4.ch04;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

//동적바인딩
public class StringTest {
    public static void main(String[] args) throws ClassNotFoundException {
        Class c = Class.forName("java.lang.String");



        //리플렉션 프로그램할때 사용함 (내 로컬에 없을시)
        Constructor[] cons = c.getConstructors();
        for (Constructor co : cons){
            System.out.println(co);
        }
        Method[] m = c.getMethods();
        for(Method ma : m){
            System.out.println(ma);
        }
    }
}
