package ch3.ch14;


public class CalculatorTest {
    public static void main(String[] args) {
        Calc calc = new CompleteCalc();
        System.out.println(calc.add(10,2));
        System.out.println(calc.substract(10,2));
        System.out.println(calc.times(10,2));
        System.out.println(calc.divide(10,0));

        calc.description();

        int arr[] = {1,2,3,4,5};
        System.out.println(Calc.total(arr));
    }
}
