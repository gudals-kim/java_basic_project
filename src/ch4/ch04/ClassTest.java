package ch4.ch04;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class c1 = Class.forName("ch04.Person");

        Person person = (Person) c1.newInstance();

        person.setName("kim");
        System.out.println(person);

        Class c2 = person.getClass();
        Person person2 = (Person) c2.newInstance();
        System.out.println(person2);

        Class[] parameterTypes = {String.class};
        c2.getConstructor(parameterTypes);



    }
}
