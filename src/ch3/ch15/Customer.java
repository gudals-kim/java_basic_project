package ch3.ch15;

public class Customer implements Buy,Sell{

    @Override
    public void buy() {
        System.out.println("customer sell");
    }

    @Override
    public void order() {
        System.out.println("customer order");
    }

    @Override
    public void sell() {
        System.out.println("customer buy");
    }
    public void hello(){
        System.out.println("customer hello");
    }
}