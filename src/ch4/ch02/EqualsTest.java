package ch4.ch02;

public class EqualsTest {
    public static void main(String[] args) {
        Student std1 = new Student(100,"lee");
        Student std2 = new Student(100,"lee");

        //번호가 같으면 논리적으로 두학생은 같다라고 만들어야함

        System.out.println(std1 == std2); // 결과 false 물리적 주소가 다름
        System.out.println(std1.equals(std2)); //결과 false 오버라이딩 결과후는 논리적으로 맞다라고 재정의후엔 true가 나옴

        System.out.println(std1.hashCode());//논리적으로 같으면 같은 해쉬값이 나온다.
        System.out.println(std2.hashCode());

        System.out.println(System.identityHashCode(std1)); // 실제 해쉬코드(가상메모리값)를 알려주는 함수
        System.out.println(System.identityHashCode(std2)); // 실제 해쉬코드(가상메모리값)를 알려주는 함수

    }



}
