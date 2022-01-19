package designpatten.singleton;

public class Aclazz {

    private SocketClient socketClient;

    public Aclazz(){
//        this.socketClient = SocketClient.getInstance();\
        this.socketClient = new SocketClient(); //socketClient 객체 생성
    }

    public SocketClient getSocketClient(){
        return this.socketClient;
    }
}
