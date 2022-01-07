package ch4.ch03;

public class StringTest {
    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        System.out.println(System.identityHashCode(java));
        //단일 쓰레드에는 StringBuilder
        //멀티쓰레드에는 StringBuffer
        java = java.concat("android");
        System.out.println(System.identityHashCode(java));
        System.out.println(java);
    }
}
