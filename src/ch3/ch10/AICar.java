package ch3.ch10;

public class AICar extends Car{
    @Override
    public void drive() {
        System.out.println("자율주행을 합니다.");
        System.out.println("자동으로 방향을 바꿉니다.");
    }

    @Override
    public void stop() {
        System.out.println("장애물이 있어 자동으로 자동차가 멈춥니다.");

    }

    @Override
    public void wiper() {
        System.out.println("비가와서 자동으로 와이퍼를 킵니다.");
    }

}
