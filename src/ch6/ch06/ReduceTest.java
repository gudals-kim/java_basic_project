package ch6.ch06;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String>{

    @Override
    public String apply(String s1, String s2) {//바이너리 오퍼리에터 클래스로 구현
        if (s1.getBytes().length >= s2.getBytes().length) return s1;
        else return s2;
    }
}




public class ReduceTest {
    public static void main(String[] args) {
        String greeting[] = {"안녕하세요~~~","hello","good morning","반갑습니다"};

       String str =Arrays.stream(greeting).reduce(" ",(s1,s2)->
            {if (s1.getBytes().length >= s2.getBytes().length) return s1;//람다식으로 직접구현
            else return s2;}
        );
        System.out.println(str);

        System.out.println("==============");

        String str2 = Arrays.stream(greeting).reduce(new CompareString()).get();

        System.out.println(str2);

    }
}
