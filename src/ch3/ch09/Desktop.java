package ch3.ch09;

public class Desktop extends Computer{
    //추상클래스 Computer를 상속 받으려면 추상 클래스에 있는 추상메서드를 구현해야함


    @Override
    public void display() {
        System.out.println("Desktop Display");
    }

    @Override
    public void typing() {
        System.out.println("Desktop typing");
    }


    @Override
    public void turnOff() {
        System.out.println("Desktop turnOFF");
    }
}
