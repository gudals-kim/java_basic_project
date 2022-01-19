package designpatten.singleton;

public class SocketClient {
    private static SocketClient socketClient;

    //private SocketClient(){}//싱글톤은 기본 생성자는 프라이빗으로 막아줘야한다.
    public SocketClient(){}// public 으로 직접 접근가능하게 풀었다.


    public static SocketClient getInstance(){//객체에 접근할수 있게 get메서드 정의
        if(socketClient == null){ // 만약 생성된 객체가 없는 경우
            socketClient = new SocketClient(); //객체를 생성
        }
        return socketClient; //객체를 반환한다.
    }

    public void connect(){
        System.out.println("connect");
    }

}
