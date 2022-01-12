package ch6.ch06;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayStreamTest {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};

        for (int num:arr){
            System.out.println("for문 사용"+num);
        }

        Arrays.stream(arr).filter(n->n>2).forEach(n-> System.out.println("stream 사용"+n));


    }
}
