package ch4.ch03;

public class StringBuilder {
    public StringBuilder(String java) {
    }

    public static void main(String[] args) {
        String java = new String("java");
        String android = new String("android");

        StringBuilder buffer = new StringBuilder(java);
        buffer.append(android);

        String test = buffer.toString();
        System.out.println(test);
    }

    private void append(String android) {
    }


}
