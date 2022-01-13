package ch6.ch08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class ThrowsExeption {
    public Class loadClass(String fileName, String className) throws ClassNotFoundException, FileNotFoundException {
        //throws ClassNotFoundException, FileNotFoundException는 이 메서드를 쓰는 쪽에서 예외처리를 해라.
        FileInputStream fis = new FileInputStream(fileName);
        Class c = Class.forName(className);
        return c;
    }
    public static void main(String[] args) {//main에서 throws 하면 안돼 JVM으로 넘어가서 오류나요
        ThrowsExeption test = new ThrowsExeption();
        try {
            test.loadClass("a.txt", "abc");//loadClass 호출
        } catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException : "+e);
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException : "+e);
        } catch (Exception e){//저 위에 두가지 에러 말고 나머지 혹시모를 에러들
            System.out.println("최상위 exception");
        }

    }
}
