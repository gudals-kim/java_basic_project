package ch3.ch04;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer(10010,"이순신");
        customerLee.bonusPoint = 1000;
        int price = customerLee.calcPrice(1000);
        System.out.println(customerLee.showCustomerInFo() + price);

        VIPCustomer customerkim = new VIPCustomer(10030,"김유신");//Customer(부모) 클래스로 생성을 해도 생성이 된다. (업케스팅) 단 이때는 변수 접근이 가능한건 customer 부분만이다.
        customerkim.bonusPoint = 10000;
        price = customerkim.calcPrice(1000);
        System.out.println(customerkim.showCustomerInFo() + price);
    }
}
