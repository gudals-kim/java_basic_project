package ch3.naver;

public class Mobile extends Appliance{
    protected String call;
    protected String inter;
    protected String cam;

    public Mobile(){
        call = "전화가 가능합니다.";
        inter = "무선인터넷이 됩니다.";
        cam = "카메라가 작동됩니다.";
    }
    public String MobileInFo(){
        return "모바일의 특징은"+eng+iot+call+inter+cam+"입니다.";
    }

}
