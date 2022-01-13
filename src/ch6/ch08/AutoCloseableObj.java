package ch6.ch08;

public class AutoCloseableObj implements AutoCloseable{//Autocloseable 인터페이스

    @Override
    public void close() throws Exception {// close 메소드 오버라이드
        System.out.println("close 되었다.");//클로즈가 되면 로그를 찍음
    }
}
