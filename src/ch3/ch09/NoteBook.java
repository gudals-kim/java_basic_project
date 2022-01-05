package ch3.ch09;

public abstract class NoteBook extends Computer{
    //추상 메소드를 하나라도 구현 안하면 추상클래스가 되어야함
    @Override
    public void display() {
        System.out.println("NoteBook display");
    }
}
