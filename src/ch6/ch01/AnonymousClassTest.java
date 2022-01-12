package ch6.ch01;

class Outer2{//외부 클래스

    int outNum = 100; //외부 클래스에 선언된 인스턴스 변수
    static int sNum = 200;//외부 클래스에 선언된 정적변수

    Runnable getRunnable(final int i){//i 는 getRunnable의 매개변수 stack에 생성
        //클래스를 쓰레드화 하는 메서드를 만들때 사용하는 인터페이스
        final int num = 10;//getRunnable의 지역변수 stack에 생성
// num과 i 는 getrunnable메서드가 실행이 끝나면 없어진다 그래서 final로 선언되어서(자동으로)
// 값은 못바꾸고 저장만 되어있다.
        class MyRunnable implements Runnable{
            //runnable 인터페이스를 구현한 지역 내부클래스를 만듬
            int localNum = 1000; //멤버변수

            @Override
            public void run() {

//                i = 50; 오류남
//                num = 20; 오류남
//                오류가 나는 이유는 run메서드는 나중에 또 호출될수 있는 여지가 있는데
//                getRunnable의 매개변수와 지역변수는 없어지기 때문에 final로 선언되서 남아있음
//                그래서 값은 못바꾸지만 사용은 가능하다.
                System.out.println("i = "+ i);
                System.out.println("num = "+ num);
                System.out.println("localNum = "+ localNum);

                System.out.println("outNum = "+ outNum + "(외부클래스의 인스턴스 변수");
                System.out.println("Outer2.sNum = "+ Outer2.sNum+"(외부클래스의 정적 변수");


            }

        }
        return new MyRunnable();//MyRunnale을 생성해서 반환한다.
    }


}

public class AnonymousClassTest {
    public static void main(String[] args) {
        Outer2 out = new Outer2();
        Runnable runner = out.getRunnable(100);

        runner.run();

    }
}
