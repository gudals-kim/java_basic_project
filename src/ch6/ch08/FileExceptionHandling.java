package ch6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileExceptionHandling {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
        } catch (FileNotFoundException e) {
            System.out.println("예외처리 : "+e);
        }finally{
            if(fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    System.out.println("예외처리 : "+e);
                }
            }
            System.out.println("finally이 호출됬습니다");
        }
        System.out.println("예외처리가 다 되어서 프로그램이 끝났습니다.");
    }
}
