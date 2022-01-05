package ch3.ch02;

public class CustomerTest {
    public static void main(String[] args) {
        Customer customerLee = new Customer();
        customerLee.setCustomerName("이순신");
        customerLee.setCustomerID(10010);
        customerLee.bonusPoint = 1000;
        System.out.println(customerLee.showCustomerInFo());

        VIPCustomer customerkim = new VIPCustomer();
        customerkim.setCustomerName("김유신");
        customerkim.setCustomerID(10030);
        customerkim.bonusPoint = 10000;
        System.out.println(customerkim.showCustomerInFo());
    }
}
