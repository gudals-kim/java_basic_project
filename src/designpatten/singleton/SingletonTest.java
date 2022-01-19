package designpatten.singleton;

public class SingletonTest {
    public static void main(String[] args) {
        Aclazz aclazz = new Aclazz();
        Bclazz bclazz = new Bclazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println("두개의 객체가 동일해?");
        System.out.println(aClient.equals(bClient));
    }
}
