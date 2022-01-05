package ch3.ch06;

//고객의 속성 : 고객 아이디, 고객이름, 고객등급, 보너스 포인트, 보너스 포인트, 적립비율
// 일반 고객의 경우 물품 구매시 1% 보너스 적립


public class Customer {
    protected int customerID; // 고객 ID
    protected String customerName; // 고객 이름
    protected String customerGrade; // 고객등급
    int bonusPoint; // 보너스포인트
    double bonusRatio; // 적립율


    public Customer(int customerID,String customerName){//고객 생성자 인스턴스로 고객아이디와 고객 이름을 받음
        this.customerID = customerID;
        this.customerName = customerName;

        bonusRatio = 0.01; //일반고객 보너스 적립율 정의
        customerGrade = "SIVER"; //일반고객 등급 정의
        System.out.println("Customer(int, String) call");

    }

    public int calcPrice(int price) { //포인트 적립 함수
        bonusPoint += price * bonusRatio; // 보너스포인트를 계산한다.
        return price; //다시가격을 반환한다.
    }

    public String showCustomerInFo() {
        return customerName + "님의 등급은" + customerGrade + "이며, 보너스 포인트는" + bonusPoint + "입니다";
    }


    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

}