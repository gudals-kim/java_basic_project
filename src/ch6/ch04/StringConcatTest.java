package ch6.ch04;

public class StringConcatTest {
    public static void main(String[] args) {

        String s1 = "Hello";
        String s2 = "world";


        StringConcatImpl stringConcat = new StringConcatImpl();
        stringConcat.makeString(s1,s2);//객체지향 표현

        System.out.println("=================================");

        StringConcat concat = (ram,da) -> System.out.println("s1 : "+ram+", s2 :"+da);
        concat.makeString(s1,s2);//람다식표현


    }
}
