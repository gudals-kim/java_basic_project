package ch4.ch02;

import java.util.Objects;

public class Student {

    private int studentNum;
    private String studentName;

    public Student(int studentNum, String studentName){
        this.studentName = studentName;
        this.studentNum = studentNum;
    }

    public String toString(){
        return studentNum+","+studentName;
    }


    //번호가 같으면 논리적으로 두학생은 같다라고 만들어야함
    @Override
    public boolean equals(Object obj) { //equals 함수 재정의
        if (obj instanceof Student){ // 받은 obj 의 인스턴스 실제 타입이 Student 이냐?
            Student std = (Student)obj;//obj를 std로 넘겨준다. object -> Student 다운캐스팅하는거임
            if(this.studentNum == std.studentNum)// this 와 std의 학생번호가 같아?
                return true; //같으면 true 반환
            else return false;
        }
        return false;// Student 타입이 아니면 false

    }

    @Override
    public int hashCode() {
        return studentNum;
    }



}
