package ch3.ch09;

public abstract class Computer {
    //추상 메소드 왜쓰냐? 하위클래스가 알아서 만들어 써라 이런느낌
    //거의 오로지 상속을 위해 만드는 클래스
    public abstract void display();
    public abstract void typing();


    public void turnOn(){
        System.out.println("전원을 켭니다.");
    }

    public void turnOff(){
        System.out.println("전원을 끕니다.");
    }
}
