package ch6.ch01;


class OutClass{//외부클래스
    private int num = 10;
    private static int sNum = 20;
    private InClass inClass;
    public OutClass(){//외부클래스가 생성될때 인클래스가 같이 생성되게 함
        inClass = new InClass();
    }

    private class InClass{//내부클래스
        int iNum = 100;
//        static int sInNum = 500;
//  오류가 난다. 왜냐하면 내부클래스는 외부클래스가 생성이 된 다음 생성이 되는데
// 정적변수는 외부클래스의 생성과 상관없이 계속 사용되어야하는데 외부클래스가 생성이 안되면 정적변수를 사용할수 없음에 오류가 나옴
// 정적 변수를 사용하려면 정적 내부클래스에서 선언해야함
        void inTest(){
            System.out.println("OutClass num = "+num+"(외부 클래스의 인스턴스 변수");
            System.out.println("OutClass sNum = "+sNum+"(외부 클래스의 스태틱(정적) 변수");
            System.out.println("OutClass iNum = "+iNum+"(내부 클래스의 인스턴스 변수");

        }
    }
    public void usingClass(){//이런식으로 내부클래스가 자동적으로 생성이 되니 외부클래스에서 내부클래스의 메서드를 사용한다.
        //다른 클래스에서 내부클래스의 메서드를 사용할수 있음
        inClass.inTest();
    }

    static class InStaticClass{//정적 내부클래스
        int iNum = 100;
        static int sInNum = 200;
        void inTest(){
//            System.out.println("OutClass num = "+num+"(외부 클래스의 인스턴스 변수");
//            오류가 나는 이유는 정적클래스에 선언된 메소드이기 때문에 외부클래스(OutClass)가 생성되기 전에 사용될수 있어야 해서 오류가남
//            num이 외부 클래스의 인스턴스 변수이기 때문에
            System.out.println("InClass iNum = "+iNum+"(내부 정적 클래스의 인스턴스 변수");
            System.out.println("OutClass sNum = "+sNum+"(외부 클래스의 스태틱(정적) 변수");
            System.out.println("OutClass sInNum = "+sInNum+"(내부 정적클래스의 스태틱 변수");

        }
        static void sTest(){//스태틱 클래스의 스태틱 메서드
//            System.out.println("InClass iNum = "+iNum+"(내부 정적 클래스의 인스턴스 변수");
//            스태틱 클래스의 스태틱 메서드는 스태틱 클래스가 생성되지 않아도 메서드를 사용할 수 있어야하는데
//            스태틱 클래스에서 선언된 인스턴스 변수는 스태틱 클래스가 선언이 되어야 사용할 수 있음으로 사용불가능하다.
            System.out.println("OutClass sNum = "+sNum+"(외부 클래스의 스태틱(정적) 변수");
            System.out.println("OutClass sInNum = "+sInNum+"(내부 정적클래스의 스태틱 변수");
        }
    }
}


public class InnerTest {
    public static void main(String[] args) {
        OutClass outClass = new OutClass();
        outClass.usingClass();//다른 클래스에서는 내부클래스를 이런식으로 접근한다.
        System.out.println("====================================");
        OutClass.InStaticClass sInClass = new OutClass.InStaticClass();
        sInClass.inTest();//외부클래스의 정적내부클래스에 선언된 일반 메서드
        OutClass.InStaticClass.sTest();
        // 외부클래스의 정적내부클래스에 선언된 정적 메서드는 정적내부클래스가 생성이 안되도 사용할수 있다.
    }
}
