package designpatten.adapter;

public class AdapterTest {
    //콘센트
    public static void connect(Electronic110V electronic110V){
        electronic110V.powerOn();
    }

    public static void main(String[] args) {
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        AirCon airCon = new AirCon();
        Cleaner cleaner = new Cleaner();
        //connect(airCon);

        Electronic110V airadapter = new SocketAdapter(airCon);
        Electronic110V cleadapter = new SocketAdapter(cleaner);
        connect(airadapter);
        cleadapter.powerOn();
    }

}
