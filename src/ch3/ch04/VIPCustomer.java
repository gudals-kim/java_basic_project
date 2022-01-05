package ch3.ch04;

//Customer 클래스에 추가해서 구현하는 것은 좋지않음
// VIPCustomer 클래스를 따로 구현
// 이미 Customer에 구현된 내용이 중복되므로 Customer를 확장하여 구현함
public class VIPCustomer extends Customer {//고객클래스를 상속받는다

    private String agentID;//VIP고객아이디
    double salesRatio;//VIP고객 적립율

    @Override//오버라이드 고객클래스의 적립율 계산함수를 가져와서 재정의한다.
    public int calcPrice(int price) {
        bonusPoint += price * bonusRatio; //보너스포인트 적립
        price -= (int)(price * salesRatio);//할인이 적용된 가격을 만든다.

        return price;//할인이 적용된 가격으로 반환한다.
    }

    public VIPCustomer(int customerID, String customerName){//VIP고객 생성자

        super(customerID,customerName);// 고객 클래스에 기본생성자가 없고 매개변수를 받기때문에 super키워드로 매개변수를 받아준다.
        bonusRatio = 0.05; // VIP고객의 보너스 적립율 정의
        salesRatio = 0.1; // VIP고객의 할인율 정의
        customerGrade = "VIP"; //등급정의



        System.out.println("Customer(int, String) call");
    }

    public String getAgentID(){
        return agentID;
    }//
}
