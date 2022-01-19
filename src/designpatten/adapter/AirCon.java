package designpatten.adapter;

public class AirCon implements Electronic220V{
    @Override
    public void connect() {
        System.out.println("에어컨 200v로 켜짐");
    }
}
