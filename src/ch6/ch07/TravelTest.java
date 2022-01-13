package ch6.ch07;

import java.util.ArrayList;
import java.util.List;

public class TravelTest {
    public static void main(String[] args) {
        Customer Kim = new Customer("김유신",40,100);
        Customer Lee = new Customer("이순신",20,100);
        Customer Park = new Customer("박혁거세",13,50);

        List<Customer> customerList = new ArrayList<>();
        customerList.add(Kim);
        customerList.add(Lee);
        customerList.add(Park);

        System.out.println("==고객 명단 추가된 순서대로 출력 ==");
        customerList.stream().forEach(s-> System.out.println(s));

        System.out.println("총 비용");
        int Total = customerList.stream().mapToInt(p->p.getPrice()).sum();
        //고객 리스트 중에서 가격을 합해라
        System.out.println("총 비용은 "+Total+"만원 입니다.");

        System.out.println("20세 이상 고객 명단 이름순으로 출력");
        customerList.stream().filter(i->i.getAge()>=20).map(n->n.getName()).sorted().forEach(s -> System.out.println(s));
        //고객 리스트 중에서 나이가 20세 이상인 사람들의 이름을 정렬해서 출력해라.
    }
}
