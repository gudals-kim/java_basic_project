package ch6.ch08;

public class AutoCloseTest {
    public static void main(String[] args) {
        AutoCloseableObj obj = new AutoCloseableObj();
        try (obj){
            throw new Exception();//강제로 exception을 발생시킴
        }catch (Exception e){
            System.out.println("예외처리 됨");
        }
        System.out.println("프로그램 끝났음");
    }
}
