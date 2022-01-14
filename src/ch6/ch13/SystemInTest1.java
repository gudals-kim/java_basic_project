package ch6.ch13;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SystemInTest1 {
    public static void main(String[] args) {
        System.out.println("알파벳 여러 개를 쓰고 [Enter]를 누르세요");

        int i;

        try {
            InputStreamReader irs = new InputStreamReader(System.in);
            while ((i = irs.read()) != '\n') {//System.in 은 1byte씩 받는다
                //그래서 한글이나 1바이트 이상 문자 처리 불가
                //=> 그러면 어떡함? => inputStreamReader로 감싸면 가능
                System.out.print((char) i);
            }
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
