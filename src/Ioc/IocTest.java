package Ioc;

public class IocTest {
    public static void main(String[] args) {
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";


        //DI 개념
        Encoder encoder = new Encoder(new UrlEncoder());
        String result = encoder.encode(url);
        System.out.println(result);


//        //Base 64 encoding
//        IEncoder base64Encoder = new Base64Encoder();
//        String result = base64Encoder.encode(url);
//
//        System.out.println(result);
//
//        //Url encoding
//        IEncoder urlEncoder = new UrlEncoder();
//        String urlResult = urlEncoder.encode(url);
//
//        System.out.println(urlResult);


    }
}
