package ch6.ch02;

public class AddTest {
    public static void main(String[] args) {
        Add addF = (x,y) ->{return x+y;};
        System.out.println(addF.add(2,3));
    }
}
