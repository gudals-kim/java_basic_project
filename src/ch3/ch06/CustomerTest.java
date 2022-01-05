package ch3.ch06;

import java.util.ArrayList;

public class CustomerTest {
    public static void main(String[] args) {
        ArrayList<Customer> customerArrayList = new ArrayList<>();

        Customer customerT = new Customer(10010,"Tomas");
        Customer customerJ = new Customer(10020,"James");
        Customer customerE = new GoldCustomer(10030,"Edward");
        Customer customerP = new GoldCustomer(10040,"Percy");
        Customer customerK = new VIPCustomer(10050,"kim");

        customerArrayList.add(customerT);
        customerArrayList.add(customerJ);
        customerArrayList.add(customerE);
        customerArrayList.add(customerP);
        customerArrayList.add(customerK);

        for(Customer customer : customerArrayList){
            System.out.println(customer.showCustomerInFo());
        }
        int price = 10000;
        for(Customer customer : customerArrayList){
            int cost = customer.calcPrice(price);
            System.out.println(customer.getCustomerName()+"님이"+cost+"원 지불하셨습니다.");
            System.out.println(customer.getCustomerName()+"님의 현재 보너스 포인트는"+customer.bonusPoint+"입니다.");
        }
    }
}
