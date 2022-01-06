package ch3.ch15;

public interface Queue {

    void enQueue(String title);//들어가는 메서드 책의이름을 가지고있음
    String deQueue();//꺼내는 메서드 책의 이름 반환

    int getSize(); //책이 몇개가 있느냐 라는 메서드

}
