package ch3.ch10;

public abstract class Car {
    public abstract void drive();
    public abstract void stop();
    public abstract void wiper();

    public void startCar(){
        System.out.println("시동을 켭니다.");
    }
    public void turnOff(){
        System.out.println("시동을 끕니다.");
    }

    public void washCar(){}//훅메서드 (필요한 경우에 정의해서 사용한다.) 추상메서드는 무조건 정의해야함.

    final public void run(){
        //시나리오를 정의했다. 변하면 안된다. 그래서 final로 정의한다.
        startCar();
        drive();
        wiper();
        stop();
        turnOff();
        washCar();
    }
}
