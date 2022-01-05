package ch3.ch03;

//Customer 클래스에 추가해서 구현하는 것은 좋지않음
// VIPCustomer 클래스를 따로 구현
// 이미 Customer에 구현된 내용이 중복되므로 Customer를 확장하여 구현함
public class VIPCustomer extends Customer {

    private String agentID;
    double salesRatio;

    public VIPCustomer(int customerID, String customerName){

        super(customerID,customerName);
        bonusRatio = 0.05;
        salesRatio = 0.1;
        customerGrade = "VIP";

        System.out.println("Customer(int, String) call");
    }

    public String getAgentID(){
        return agentID;
    }
}
