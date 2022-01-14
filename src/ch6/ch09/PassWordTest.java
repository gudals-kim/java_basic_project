package ch6.ch09;

import java.util.Scanner;

public class PassWordTest {

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws PassWordException {//사용자 정의 Exception
        if (password == null){//받은 패스워드 변수가 빈값일때
            throw new PassWordException("비밀번호는 빈값일 수 없습니다.");//exception을 발생
        }
        else if(password.length() < 5){//받은 패스워드 변수의 길이가 5미만일때
            throw new PassWordException("비밀번호는 5자 이상이어야 합니다.");//exception을 발생
        }
        else if(password.matches("[a-zA-Z]+")){//패수워드 변수내에 영문자만 들어갔을때
            throw new PassWordException("비밀번호는 문자, 특수문자, 숫자 중 두개 이상의 조합으로  사용해야합니다.");//exception을 발생
        }
        else if(password.matches("[1-9]+")){//패수워드 변수내에 영문자만 들어갔을때
            throw new PassWordException("비밀번호는 문자, 특수문자, 숫자 중 두개 이상의 조합으로  사용해야합니다.");//exception을 발생
        }


        this.password = password;//그 외의 경우엔 password를 세팅해준다.
    }

    public static void main(String[] args) {
        PassWordTest test = new PassWordTest();
        Scanner sc = new Scanner(System.in);
        System.out.println("비밀번호를 입력하세요");
        String password = sc.next();
        try{
            test.setPassword(password);
            System.out.println("비밀번호 일력완료");
        }catch (PassWordException e){
            System.out.println(e.getMessage());
        }
        sc.close();

    }
}
