package ch6.ch08;

public class ArrayIndexException {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        try {
            for (int i=0; i<=5; i++){
                System.out.println(arr[i]);
            }
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
            System.out.println(e.toString());
        }
        System.out.println("프로그램이 중간에 오류가 안나서 꺼지지 않고 다 실행함");
    }
}
