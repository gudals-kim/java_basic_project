package ch3.ch11;

public class CalculatorTest {
    public static void main(String[] args) {
        CompleteCalc calc = new CompleteCalc();
        System.out.println(calc.add(10,2));
        System.out.println(calc.substract(10,2));
        System.out.println(calc.times(10,2));
        System.out.println(calc.divide(10,0));

        calc.showInfo();
    }
}
